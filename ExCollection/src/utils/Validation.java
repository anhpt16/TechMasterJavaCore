package utils;

import utils.Constant;

public class Validation {
    private static Validation instance;
    private Validation(){}
    public static Validation getInstance(){
        if (instance == null){
            instance = new Validation();
        }
        return instance;
    }

    public boolean validatePhoneNumber(String phoneNumber){
        if (phoneNumber.matches(Constant.regexPhone))
            return true;
        else
            return false;
    }
}
