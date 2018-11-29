package database;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

import static javafx.application.Platform.exit;

public class DBController implements Initializable {

    @FXML private TextField searchIsbn;
    @FXML private TextField searchAuthor;
    @FXML private Button search;
    @FXML private Button showAll;

    @FXML private TextField addIsbn;
    @FXML private TextField addTitle;
    @FXML private TextField addAuthor;
    @FXML private TextField addYear;
    @FXML private Button add;

    @FXML private TableView<Book> table;
    @FXML private TableColumn<Book, String> isbnCol;
    @FXML private TableColumn<Book, String> titleCol;
    @FXML private TableColumn<Book, String> authorCol;
    @FXML private TableColumn<Book, Integer> yearCol;

    private Connection conn = null;
    private Statement stmt = null;
    private ResultSet rs = null;

    @FXML private ObservableList<Book> data;

    @FXML public void connect(){
        int attempts = 0;

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn =
                    DriverManager.getConnection("jdbc:mysql://mysql.agh.edu.pl/dbName",
                            "username","password");

        } catch (SQLException ex) {
            if (conn == null) {
                attempts++;
            }
            if (attempts > 2){
                System.out.println("Przekroczono limit prób połączenia");
                System.out.println("SQLException: " + ex.getMessage());
                System.out.println("SQLState: " + ex.getSQLState());
                System.out.println("VendorError: " + ex.getErrorCode());
                exit();
            }

        }catch(Exception e){e.printStackTrace();}


    }

    @FXML public void listAll(){
        updateTable("SELECT * FROM books");
    }

    @FXML public void searchRecords(){
        String isbn_ = searchIsbn.getText();
        String author_ = searchAuthor.getText();
        if(!isbn_.isEmpty() && !author_.isEmpty()) {
            updateTable("SELECT * FROM books WHERE author LIKE \"%"+author_+"\" AND isbn = \'"+isbn_+"\'");
        }
        else if(isbn_.isEmpty() && !author_.isEmpty()){
            updateTable("SELECT * FROM books WHERE author LIKE \"%"+author_+"\"");
        }
        else if(author_.isEmpty() && !isbn_.isEmpty()){

            updateTable("SELECT * FROM books WHERE isbn = \'"+isbn_+"\'");
        }

    }

    @FXML public void addRecord(){
        String isbn_ = addIsbn.getText();
        String title_ = addTitle.getText();
        String author_ = addAuthor.getText();
        String year_ = addYear.getText();

        try{
            connect();
            stmt = conn.createStatement();
            stmt.executeUpdate(
                    "INSERT INTO books (isbn,title,author,year) "
                            + "values (\'"+isbn_+"\',\'"+title_+"\',\'"+author_+"\',\'"+year_+"\')");

        }catch (SQLException ex){
            // handle any errors
        }
        updateTable("SELECT * FROM books WHERE isbn = \'"+isbn_+"\'");
    }

    public void updateTable(String statement){

        try {
            connect();
            stmt = conn.createStatement();

            rs = stmt.executeQuery(statement);

            data.clear();

            while(rs.next()){
                String isbn = rs.getString(1);
                String title = rs.getString(2);
                String author = rs.getString(3);
                Integer year = Integer.parseInt(rs.getString(4));
                data.add(new Book(isbn,title,author,year));
                //System.out.println("isbn: "+isbn+" | title: "+title+" | author: "+author+" | year: "+year);
            }

            table.setItems(data);


        }catch (SQLException ex){
            // handle any errors
        }finally {
            // zwalniamy zasoby, które nie będą potrzebne
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException sqlEx) { } // ignore
                rs = null;
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException sqlEx) { } // ignore
                stmt = null;
            }
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        isbnCol.setCellValueFactory(new PropertyValueFactory<Book, String>("isbn"));
        titleCol.setCellValueFactory(new PropertyValueFactory<Book, String>("title"));
        authorCol.setCellValueFactory(new PropertyValueFactory<Book, String>("author"));
        yearCol.setCellValueFactory(new PropertyValueFactory<Book, Integer>("year"));
        data = FXCollections.observableArrayList();
        table.setItems(data);
    }
}