package controllers;

import helpers.Button;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import models.MainWindowModel;

import java.io.IOException;

public class MainWindowController {


    @FXML
    private VBox emptyListBook;

    @FXML
    private Text nickText;

    @FXML
    private TextField titleBookText;

    private MainWindowModel model;

    public MainWindowController(){
        model=new MainWindowModel(this);
    }

    public void initialize() {
        setList();
    }

    private void setList(){
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/BooksList.fxml"));
        try {
            setScreen(loader.load());
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        BookListController controller=loader.getController();
        controller.setList(Button.TopBooks);
    }

    private void setScreen(VBox pane) {
        emptyListBook.getChildren().clear();
        emptyListBook.getChildren().add(pane);
    }

    public void setNick(String nick){
        nickText.setText(nick);
    }

    public void setToken(String token){
        model.setToken(token);
    }

    public void onClickedTitleButton(ActionEvent actionEvent) {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/BooksList.fxml"));
        try {
            setScreen(loader.load());
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        BookListController controller=loader.getController();
        controller.setList(Button.Tittle);
    }

    public void onClickedHistoryButton(ActionEvent actionEvent) {
        //wyświetlenie histori przeczytanych książke
    }

    public void onClickedReadingButton(ActionEvent actionEvent) {
        //wyśiwetlenie książek po rankingu
    }

    public void onClickedDiscoverButton(ActionEvent actionEvent) {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/BooksList.fxml"));
        try {
            setScreen(loader.load());
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        BookListController controller=loader.getController();
        controller.setList(Button.Discover);
    }

    public void onClickedTopBooksButton(ActionEvent actionEvent) {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/BooksList.fxml"));
        try {
            setScreen(loader.load());
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        BookListController controller=loader.getController();
        controller.setList(Button.TopBooks);
    }

    public void onClickedDateButton(ActionEvent actionEvent) {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/BooksList.fxml"));
        try {
            setScreen(loader.load());
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        BookListController controller=loader.getController();
        controller.setList(Button.Date);
    }

    public void onClickedRantingButton(ActionEvent actionEvent) {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/BooksList.fxml"));
        try {
            setScreen(loader.load());
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        BookListController controller=loader.getController();
        controller.setList(Button.Ranting);
    }
}
