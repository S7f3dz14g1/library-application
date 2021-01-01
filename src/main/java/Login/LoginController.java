package Login;

import mainWindow.MainWindowController;
import registration.RegistrationController;
import informationBox.InformationBox;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
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
        controllerMain.setParent(LoginController.this);
        setScreen(pane);
    }

    private LoginModel model;

    public void initialize() {
        model = new LoginModel(this);
    }

    public void openMainWindow(String token) {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/MainWindow.fxml"));
        try {
            setScreen(loader.load());
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        MainWindowController controller=  loader.getController();
        controller.setNick(loginLoginText.getText().toString());
        controller.setToken(token);
        controller.setList();
    }

    public void showMessage(String message) {
        InformationBox.infoBox(message);
    }

    public void setScreen(Pane pane) {
        loginPane.getChildren().clear();
        loginPane.getChildren().add(pane);
    }
}