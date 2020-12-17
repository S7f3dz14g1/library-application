package controllers;

import javafx.fxml.FXML;
import javafx.scene.layout.Pane;

public class RegistrationController {

    private LoginController loginController;

    @FXML
    private Pane registrationPane;

    public void setLoginController(LoginController loginController) {
        this.loginController = loginController;
    }
}
