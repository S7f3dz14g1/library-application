package Login;

import api.ApiConfig;
import helpers.StringHelper;
import models.User;

public class LoginModel {

    private LoginController controller;
    private ApiConfig apiConfig;

    public LoginModel(LoginController controller){
        this.controller=controller;
        apiConfig=new ApiConfig();
    }

    public void   login(User user){
        if(!StringHelper.validatePasswordLogin(user.getPassword())||!StringHelper.validateNickLogin(user.getName())){
            controller.showMessage("Incorrect data");
        }else{
            try{
                controller.openMainWindow(apiConfig.login(user.getName(),user.getPassword()));
            }catch (Exception e){
                controller.showMessage("Incorrect data");
            }
        }
    }

}
