package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import models.MainWindowModel;


public class MainWindowController {


    @FXML
    private VBox emptyListBook;

    @FXML
    private Text nickText;

    @FXML
    private TextField titleBookText;

    private MainWindowModel model;

    public MainWindowController(){
        model=new MainWindowModel();
    }

    public void initialize() {

        Node[] node=new Node[5];//rozmiar listy 5

        for (int i = 0; i <5; i++) {
            final int j=i;

            try {
                node[j]= FXMLLoader.load(getClass().getResource("/fxml/Item.fxml"));
                //add some effect

                //add to list
                emptyListBook.getChildren().add(node[j]);
            }catch (Exception e){

            }
        }

        /*
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/BooksList.fxml"));
        try {
            setScreen(loader.load());
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        */
    }

    private void setScreen(Pane pane) {
        emptyListBook.getChildren().clear();
        emptyListBook.getChildren().add(pane);
    }

    public void setNick(String nick){//przez to nie chce działąć
       // nickText.setText(nick);
    }

    public void setToken(String token){
        model.setToken(token);
    }

}
