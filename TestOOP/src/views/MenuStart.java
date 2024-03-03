package views;

import java.util.ArrayList;
import java.util.Scanner;

import entities.User;
import utils.Constant;

public class MenuStart {
    public void menuStart(Scanner sc, ArrayList<User> users) {
        Register register = new Register();
        Login login = new Login();

        if (users == null) {
            users = new ArrayList<>();
            System.out.println("ArrayList<User> to menuStart null !");
        }

        int choose = 0;
        do {
            System.out.println("1 - Login");
            System.out.println("2 - Register");
            do {
                System.out.print("Choose: ");
                choose = Integer.parseInt(sc.nextLine());
            } while (choose != 1 && choose != 2);
            switch (choose) {
                case Constant.LOGIN:
                    login.loginView(sc, users);
                    break;
                case Constant.REGISTER:
                    register.registerView(sc, users);
                    break;
            }
        } while (true);
    }
}
