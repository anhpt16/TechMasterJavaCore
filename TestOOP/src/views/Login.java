package views;

import entities.User;
import services.UserService;
import utils.Constant;
import utils.RemoveBlank;

import java.util.ArrayList;
import java.util.Scanner;

public class Login {
    public void loginView(Scanner sc, ArrayList<User> users) {
        MainMenu mainMenu = new MainMenu();

        ForgotPassword forgotPassword = new ForgotPassword();
        UserService userService = new UserService();

        if (users == null) {
            users = new ArrayList<>();
            System.out.println("ArrayList<User> to loginView null !");
        }

        System.out.println("----------- Login -----------");
        User user = null;
        int choose = 0;
        do {
            System.out.print("--Enter Username: ");
            String username = RemoveBlank.removeBlank(sc.nextLine());
            //Kiểm tra tồn tại username
            user = userService.findUserByUsername(username, users);
            if (user == null) {
                System.out.println("Check your username again !");
            } else {
                System.out.print("--Enter Password: ");
                String password = RemoveBlank.removeBlank(sc.nextLine());
                //Kiểm tra mật khẩu
                if (userService.findAccount(username, password, users) == null) {
                    System.out.println("Wrong Password !");
                    do {
                        System.out.println("------------------");
                        System.out.println("1 - Login again");
                        System.out.println("2 - Forgot password");
                        System.out.print("Choose: ");
                        choose = Integer.parseInt(sc.nextLine());
                        System.out.println("------------------");

                        switch (choose) {
                            case Constant.LOGIN_AGAIN:
                                break;
                            case Constant.FORGOT_PASSWORD:
                                forgotPassword.fogotPasswordView(sc, users, user);
                                break;
                        }
                    } while (choose != 1 && choose != 2);
                } else {
                    mainMenu.mainMenu(sc, users, user);
                }
            }
        } while (choose == 1);
    }
}
