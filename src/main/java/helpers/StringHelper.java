package helpers;

public class StringHelper {

    public static boolean validateNickLogin(String nick){
        return nick.length()>3;
    }
    public static boolean validatePasswordLogin(String password){
        return password.length()>3;
    }

}
