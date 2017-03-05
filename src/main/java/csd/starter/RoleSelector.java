package csd.starter;

/**
 * Created by CK on 2017/3/5.
 */
public class RoleSelector {

    public static String select(String role) {
        switch (role) {
            case "p":
            case "P":
                return "P";
            case "m":
            case "M":
                return "M";
            default:
                return "";
        }
    }
}
