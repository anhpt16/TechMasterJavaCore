package views;

import entities.User;
import services.UserService;
import utils.Constant;
import utils.RemoveBlank;

import java.util.ArrayList;
import java.util.Scanner;

public class ForgotPassword {
    public void fogotPasswordView(Scanner sc, ArrayList<User> users, User user) {
        UserService userService = new UserService();
        MainMenu mainMenu = new MainMenu();

        if (users == null) {
            users = new ArrayList<>();
            System.out.println("ArrayList<User> to forgotPassword null !");
        }

        System.out.println("-------- Forgot Password -----------");
        boolean isEmailTrue;
        do {
            System.out.print("--Enter Email: ");
            String email = RemoveBlank.removeBlank(sc.nextLine());
            //Kiểm tra email
            isEmailTrue = userService.findUserByEmail(email, users) != null;
            if (!isEmailTrue) {
                System.out.println("Account does not exist !");
            } else {
                boolean isCorrectFormat;
                do {
                    System.out.print("--Enter new password: ");
                    String newPassword = RemoveBlank.removeBlank(sc.nextLine());
                    //Kiểm tra định dạng cho new password
                    isCorrectFormat = userService.checkFormat(newPassword, Constant.regexPassword);
                    if (!isCorrectFormat) {
                        System.out.println("Password is 7 to 15 characters long, contains at least 1 uppercase character, 1 special character !");
                    } else {
                        //Lưu lại password mới
                        if (userService.updateUserByPassword(newPassword, user) == null) {
                            System.out.println("Password update failed !");
                        } else {
                            System.out.println("Password update successfully !");
                            System.out.println("----------------------------------");
                            mainMenu.mainMenu(sc, users, user);
                        }
                    }
                } while (!isCorrectFormat);
            }
        } while (!isEmailTrue);
    }
}
