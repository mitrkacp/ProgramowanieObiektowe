package images;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;

import static javafx.scene.input.MouseEvent.MOUSE_CLICKED;

public class Controller implements Initializable {

    @FXML private StackPane imageStackPane;
    @FXML private ScrollPane imageSlider;
    private File folder;

    @Override
    public void initialize(URL url, ResourceBundle rb){

        folder = new File("foto");
        File[] files = folder.listFiles();

        TilePane tilePane = new TilePane();
        tilePane.setPrefColumns(1);
        tilePane.setMaxWidth(200);

        for(int i=0; i<files.length; i++){

                String input = files[i].toURI().toString();
                Image image = new Image(input);
                ImageView imageView = new ImageView(image);
                imageView.setFitHeight(200);
                imageView.setFitWidth(200);
                imageView.setPreserveRatio(true);
                imageView.addEventFilter(MouseEvent.MOUSE_CLICKED,new EventHandler<MouseEvent>(){
                    @Override
                    public void handle(MouseEvent event){
                        System.out.println(input);
                        Image img = new Image(input);
                        ImageView imageV = new ImageView(img);
                        imageV.setFitHeight(600);
                        imageV.setFitWidth(600);
                        imageV.setPreserveRatio(true);
                        imageStackPane.getChildren().clear();
                        imageStackPane.getChildren().add(imageV);

                    }
                });
                tilePane.getChildren().addAll(imageView);

        }

        imageSlider.setContent(tilePane);

    }



}
