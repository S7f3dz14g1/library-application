package controllers;

import informationBox.InformationBox;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
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
    private TextField loginLoginText;

    @FXML
    private PasswordField passwordLoginText;

    @FXML
    public void onLoginClicked() {
        model.login(new User(loginLoginText.getText().toString(),
                passwordLoginText.getText().toString()));
    }

    @FXML
    public void onRegistrationClicked() {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/Registration.fxml"));
        Pane pane = null;
        try {
            pane = loader.load();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        RegistrationController controllerMain = loader.getController();
        controllerMain.setLoginController(LoginController.this);
        setScreen(pane);
    }

    private LoginModel model;

    public void initialize() {
        model = new LoginModel(this);
    }

    public void openMainWindow() {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/MainWindow.fxml"));
        try {
            //zmiana rozmiarów okna
            setScreen(loader.load());
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    public void showMessage(String message) {
        InformationBox.infoBox(message);
    }

    public void setScreen(Pane pane) {
        loginPane.getChildren().clear();
        loginPane.getChildren().add(pane);
    }
}
