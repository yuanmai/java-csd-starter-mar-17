package csd.starter;

/**
 * Created by luxb on 2017/3/7.
 */
public class PasswordCheck {

    public static boolean checkPassword(String password){
        if(password == null){
            return false;
        }

        if(password.length() < 10){
            return false;
        }

        if(password.matches("^[A-Za-z0-9]+$")){
            return false;
        }

        return true;
    }
}
