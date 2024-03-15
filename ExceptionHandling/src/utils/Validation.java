package utils;

import MyException.InvalidPhoneException;

public class Validation {
    public static boolean checkPhoneNumber(String phoneNumber) throws InvalidPhoneException {
        if (!phoneNumber.matches("[0-9]+")){
            throw new InvalidPhoneException("Số điện thoại chỉ được chứa chữ số !");
        }
        if (phoneNumber.length() != 10){
            throw new InvalidPhoneException("Số điện thoại phải có 10 chữ số !");
        }
        return true;
    }

}
