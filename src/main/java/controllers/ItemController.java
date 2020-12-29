package controllers;

import javafx.fxml.FXML;
import javafx.scene.layout.Background;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class ItemController {

    @FXML
    private Text titleBook;

    @FXML
    private Text authorBook;


    public void setTitle(String title){
        titleBook.setText(title);
    }

    public void setAuthor(String author){
        authorBook.setText(author);
    }

}
