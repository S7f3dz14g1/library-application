package controllers;

import informationBox.InformationBox;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import models.RegistrationModel;
import models.User;

import java.io.IOException;

public class RegistrationController {

    private LoginController loginController;

    private RegistrationModel registrationModel;

    public RegistrationController(RegistrationModel registrationModel) {
        this.registrationModel = registrationModel;
    }

    public RegistrationController() {
    }

    @FXML
    private TextField loginText;

    @FXML
    private PasswordField password1Text;

    @FXML
    private PasswordField password2Text;

    @FXML
    private TextField mailText;

    @FXML
    public void onBackClicked() {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/Login.fxml"));
        Pane pane = null;
        try {
            pane = loader.load();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        loginController.setScreen(pane);
    }

    @FXML
    public void onRegistrationClicked() {
        registrationModel.login(
                loginText.getText().toString(),
                password1Text.getText().toString(),
                password2Text.getText().toString(),
                mailText.getText().toString());
    }

    @FXML
    public void initialize() {
        registrationModel = new RegistrationModel(this);
    }

    public void setLoginController(LoginController loginController) {
        this.loginController=loginController;
    }

    public void alertWindow(String message){
        InformationBox.infoBox(message);
    }

    public void openMainWindow(String taken, String nick) {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/MainWindow.fxml"));
        try {
            loginController.setScreen(loader.load());
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        MainWindowController mainWindowController=loader.getController();
        mainWindowController.setToken(taken);
        mainWindowController.setNick(nick);
    }
}
