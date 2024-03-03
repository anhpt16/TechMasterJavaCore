package views;

import entities.User;
import services.UserService;
import utils.Constant;
import utils.RemoveBlank;

import java.util.ArrayList;
import java.util.Scanner;

public class MainMenu {
    public void mainMenu(Scanner sc, ArrayList<User> users, User user) {
        UserService userService = new UserService();

        int choose;
        do {
            System.out.println("------------- Main Menu -------------");
            System.out.println("Welcome " + user.getUsername() + ", You can do the following: ");
            System.out.println("1 - Change username");
            System.out.println("2 - Change email");
            System.out.println("3 - Change password");
            System.out.println("4 - Logout");
            System.out.println("5 - Exit");
            System.out.print("Choose: ");
            choose = Integer.parseInt(sc.nextLine());
            System.out.println("-------------------------------------");

            switch (choose) {
                case Constant.CHANGE_USERNAME:
                    System.out.print("Enter new username: ");
                    String newUsername = RemoveBlank.removeBlank(sc.nextLine());
                    //Kiểm tra tồn tại của username mới
                    if (userService.findUserByUsername(newUsername, users) == null) {
                        if (userService.updateUserByUsername(newUsername, user) != null) {
                            System.out.println("Update Username Successfully !");
                        } else
                            System.out.println("Update Username Failed !");
                    } else {
                        System.out.println("Username exists !");
                    }
                    break;
                case Constant.CHANGE_EMAIL:
                    System.out.print("Enter new email: ");
                    String newEmail = RemoveBlank.removeBlank(sc.nextLine());
                    //Kiểm tra định dạng cho email mới
                    if (!userService.checkFormat(newEmail, Constant.regexEmail)) {
                        System.out.println("Email format is wrong !");
                    } else {
                        //Kiểm tra tồn tại của email mới
                        if (userService.findUserByEmail(newEmail, users) != null) {
                            System.out.println("Email exists !");
                        } else {
                            if (userService.updateUserByEmail(newEmail, user) != null) {
                                System.out.println("Update Email Successfully !");
                            } else
                                System.out.println("Update Email Failed !");
                        }
                    }
                    break;
                case Constant.CHANGE_PASSWORD:
                    System.out.print("Enter new password: ");
                    String newPassword = RemoveBlank.removeBlank(sc.nextLine());
                    //Kiểm tra định dạng cho password mới
                    if (userService.checkFormat(newPassword, Constant.regexPassword)) {
                        if (userService.updateUserByPassword(newPassword, user) != null) {
                            System.out.println("Update Password Successfully !");
                        } else
                            System.out.println("Update Password Failed !");
                    } else
                        System.out.println("Password format is wrong !");
                    break;
                case Constant.LOGOUT:
                    break;
                case Constant.EXIT:
                    System.exit(0);
                    break;
            }
        } while (choose != 4);
    }
}
