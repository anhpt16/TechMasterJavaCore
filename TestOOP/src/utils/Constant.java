package utils;

public class Constant {
    public static final int LOGIN = 1;
    public static final int REGISTER = 2;

    public static final int LOGIN_AGAIN = 1;
    public static final int FORGOT_PASSWORD = 2;

    public static final int CHANGE_USERNAME = 1;
    public static final int CHANGE_EMAIL = 2;
    public static final int CHANGE_PASSWORD = 3;
    public static final int LOGOUT = 4;
    public static final int EXIT = 5;
    //Regex
    public static final String regexEmail = "[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
    public static final String regexPassword = "^(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{7,15}$";
}
