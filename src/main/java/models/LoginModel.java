package models;

import controllers.LoginController;
import helpers.StringHelper;

public class LoginModel {

    private LoginController controller;

    public LoginModel(LoginController controller){
        this.controller=controller;
    }

    public void login(User user){
        if(!StringHelper.validatePasswordLogin(user.getPassword())||!StringHelper.validateNickLogin(user.getName())){
            controller.showMessage("Błędne dane");
        }else {
            controller.openMainWindow();
        }
        //sprawdzić czy istnieje w bazie
        //zalogować i przenieść
        //metoda z controllera
    }
}
