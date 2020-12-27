package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class BookListController implements Initializable {
    
    @FXML
    private VBox listItem;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        Node[] node=new Node[5];//rozmiar listy 5

        for (int i = 0; i <5; i++) {

            try {
                node[i]= FXMLLoader.load(getClass().getResource("/fxml/Item.fxml"));
                //add some effect

                //add to list
                listItem.getChildren().add(node[i]);
            }catch (Exception e){

            }
        }
    }
}
