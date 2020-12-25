package models;

import api.ApiConfig;
import controllers.LoginController;
import helpers.StringHelper;

public class LoginModel {

    private LoginController controller;
    private ApiConfig apiConfig;

    public LoginModel(LoginController controller){
        this.controller=controller;
        apiConfig=new ApiConfig();
    }

    public void login(User user){
        if(!StringHelper.validatePasswordLogin(user.getPassword())||!StringHelper.validateNickLogin(user.getName())){
            controller.showMessage("Dane niepoprawne");
        }else {
            try{
                apiConfig.login(user.getName(),user.getPassword());
                controller.openMainWindow();
            }catch (Exception e){
                controller.showMessage("Błędne dane");
            }
        }
        //sprawdzić czy istnieje w bazie
        //zalogować i przenieś do mainWindow
    }
}
