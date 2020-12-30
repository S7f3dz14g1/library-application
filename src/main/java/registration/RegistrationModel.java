package registration;

import api.ApiConfig;
import helpers.StringHelper;

public class RegistrationModel {

    private RegistrationController controller;

    private ApiConfig apiConfig;

    public RegistrationModel(RegistrationController controller) {
        this.controller = controller;
        apiConfig=new ApiConfig();
    }

    public void login(String login,String password1,String password2,String email){
        if (!StringHelper.validateLoginRegistration(login)) {
            controller.alertWindow("invalid login");
        }else if(!StringHelper.validateEmailRegistration(email)){
            controller.alertWindow("invalid email");
        }else if(!StringHelper.validatePasswordRegistration(password1)){
            controller.alertWindow("invalid password");
        }else if(!StringHelper.validateTwoPasswordRegistration(password1,password2)){
            controller.alertWindow("Passwords don't match");
        }else {
            try{
                if(apiConfig.registration(login,password1,email).equals("1")) {
                    controller.openMainWindow(apiConfig.login(login, password1),login);
                }
            }catch (Exception e){
                controller.alertWindow("The specified user already exists");
            }
        }
    }
}
