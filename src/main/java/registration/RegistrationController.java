package registration;

import Login.LoginController;
import informationBox.InformationBox;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import mainWindow.MainWindowController;

import java.io.IOException;

public class RegistrationController {

    private LoginController parent;

    private RegistrationModel registrationModel;

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
        parent.setScreen(pane);
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

    public void setParent(LoginController parent) {
        this.parent = parent;
    }

    public void alertWindow(String message){
        InformationBox.infoBox(message);
    }

    public void openMainWindow(String token, String nick) {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/MainWindow.fxml"));
        try {
            parent.setScreen(loader.load());
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        MainWindowController mainWindowController=loader.getController();
        mainWindowController.setToken(token);
        mainWindowController.setList();
        mainWindowController.setNick(nick);
    }
}
