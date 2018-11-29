package database;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Book {
    private SimpleStringProperty isbn;
    private SimpleStringProperty title;
    private SimpleStringProperty author;
    private SimpleIntegerProperty year;

    public Book(String isbn, String title, String author, int year) {
        this.isbn = new SimpleStringProperty(isbn);
        this.title = new SimpleStringProperty(title);
        this.author = new SimpleStringProperty(author);
        this.year = new SimpleIntegerProperty(year);
    }

    public void setIsbn(String isbn) {
        this.isbn.set(isbn);
    }

    public void setTitle(String title) {
        this.title.set(title);
    }

    public void setAuthor(String author) {
        this.author.set(author);
    }

    public void setYear(int year) {
        this.year.set(year);
    }

    public String getIsbn() {
        return isbn.get();
    }


    public String getTitle() {
        return title.get();
    }



    public String getAuthor() {
        return author.get();
    }



    public int getYear() {
        return year.get();
    }


}
