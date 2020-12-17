package controllers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import models.LoginModel;
import models.User;

import java.io.IOException;

public class LoginController {

    @FXML
    private Pane loginPane;

    @FXML
    private Button loginButton;

    @FXML
    private TextField loginLoginText;

    @FXML
    private Hyperlink registrationLoginText;

    @FXML
    private PasswordField passwordLoginText;

    @FXML
    public void onLoginClicked(){
        model.login(new User(loginLoginText.toString(),passwordLoginText.toString()));
    }

    private LoginModel model;

    public void initialize(){
        model=new LoginModel(this);
        registrationLoginText.setOnAction(onClickedRegistration);
    }
    private EventHandler<ActionEvent> onClickedRegistration = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent e) {
            FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/Registration.fxml"));
            Pane pane  = null;
            try {
                pane = loader.load();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            RegistrationController controllerMain=loader.getController();
            controllerMain.setLoginController(LoginController.this);
            setScreen(pane);
        }
    };
//metoda do przenoszenia do głównego okna
    public void openMainWindow(){
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/MainWindow.fxml"));
        try {
            setScreen(loader.load());
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }


    public void showMessage(String message){
       //wyświetleniee alertu o błędzie chyba nowe okno
    }

    public void setScreen(Pane pane){
        loginPane.getChildren().clear();
        loginPane.getChildren().add(pane);
    }
}
