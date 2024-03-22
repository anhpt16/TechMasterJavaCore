package utils;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class InputCheck {
    private static InputCheck instance;
    private InputCheck(){}
    public static InputCheck getInstance(){
        if (instance == null)
            instance = new InputCheck();
        return instance;
    }

    Validation validation = Validation.getInstance();
;
    public <T> boolean checkNullArrayList(ArrayList<T> list, String dateType , String location){
        if (list == null){
            list = new ArrayList<>();
            System.out.println("ArrayList<" + dateType + "> to " + location + " is null !");
            return false;
        }
        return true;
    }

    public String checkPhoneNumber(){
        String phoneNumber;
        boolean isTrue;
        do {
            phoneNumber = new Scanner(System.in).nextLine();
            isTrue = validation.validatePhoneNumber(phoneNumber);
            if (!isTrue){
                System.out.print("Số điện thoại không hợp lệ, vui lòng nhập lại: ");
                continue;
            }
        } while(!isTrue);
        return phoneNumber;
    }

    public int checkIntInput(){
        int count = 0;
        do {
            try {
                count = new Scanner(System.in).nextInt();
            } catch(InputMismatchException e){
                System.out.print("Dữ liệu phải là một số, vui lòng nhập lại: ");
                continue;
            }
            if (count <= 0){
                System.out.print("Dữ liệu phải là một số nguyên dương, vui lòng nhập lại: ");
                continue;
            }
            break;
        } while(true);
        return count;
    }

    public int checkIntInput(int min, int max){
        int count = 0;
        do {
            try {
                count = new Scanner(System.in).nextInt();
            } catch(InputMismatchException e){
                System.out.print("Dữ liệu phải là một số, vui lòng nhập lại: ");
                continue;
            }
            if (count < min && count > max){
                System.out.print("Lựa chọn không hợp lệ, vui lòng nhập lại: ");
                continue;
            }
            break;
        } while(true);
        return count;
    }

    public long checkLongInput(){
        long rate = 0;
        do {
            try {
                rate = new Scanner(System.in).nextLong();
            } catch(InputMismatchException e){
                System.out.print("Dữ liệu phải là một số, vui lòng nhập lại: ");
                continue;
            }
            if (rate <= 0){
                System.out.print("Dữ liệu phải là một số dương, vui lòng nhập lại: ");
                continue;
            }
        } while(rate <= 0);
        return rate;
    }
}
