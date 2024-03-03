package views;

import entities.User;
import services.UserService;
import utils.Constant;
import utils.RemoveBlank;

import java.util.ArrayList;
import java.util.Scanner;

public class Register {
    public void registerView(Scanner sc, ArrayList<User> users) {
        UserService userService = new UserService();

        if (users == null) {
            users = new ArrayList<>();
            System.out.println("ArrayList<User> to registerView null");
        }
        //Nhập thông tin
        System.out.println("---------- Register --------");
        //Đăng ký username
        String username;
        do {
            System.out.print("--Enter Username: ");
            username = RemoveBlank.removeBlank(sc.nextLine());
            //Kiểm tra tồn tại cho username
            if (userService.findUserByUsername(username.trim(), users) != null) {
                System.out.println("Username already exists !");
            }
        } while (userService.findUserByUsername(username, users) != null);
        //Đăng ký email
        String email;
        boolean isValidEmail;
        boolean isEmailExist = false;
        do {
            System.out.print("--Enter Email: ");
            email = RemoveBlank.removeBlank(sc.nextLine());
            //Kiểm tra định dạng cho email;
            isValidEmail = userService.checkFormat(email, Constant.regexEmail);
            if (!isValidEmail) {
                System.out.println("Email is in wrong format !");
            } else {
                //Kiểm tra tồn tại cho email
                isEmailExist = userService.findUserByEmail(email, users) != null;
                if (isEmailExist) {
                    System.out.println("Email already exists !");
                }
            }
        } while (!isValidEmail || isEmailExist == true);
        //Đăng ký password
        String password;
        boolean isValidPassword;
        do {
            System.out.print("--Enter Password: ");
            password = RemoveBlank.removeBlank(sc.nextLine());
            //Kiểm tra định dạng cho password
            isValidPassword = userService.checkFormat(password, Constant.regexPassword);
            if (!isValidPassword) {
                System.out.println("Password is 7 to 15 characters long, contains at least 1 uppercase character, 1 special character !");
            }
        } while (!isValidPassword);

        //Thêm user vào arraylist
        users.add(new User(username, password, email));
        System.out.println("Registered Successfully !");
        System.out.println("-----------------------------");
    }
}
