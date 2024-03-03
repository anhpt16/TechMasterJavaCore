package services;

import entities.User;
import utils.Constant;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserService {
    public void addUser(User user, ArrayList<User> users) {
        if (users == null) {
            users = new ArrayList<>();
            System.out.println("ArrayList<User> to addUser null !");
        }
        users.add(user);
        System.out.println("Đăng ký thành công !");
    }

    // Tìm kiếm user theo tên đăng nhập
    public User findUserByUsername(String username, ArrayList<User> users) {
        if (users == null) {
            System.out.println("ArrayList<User> to findUserByUsername null!");
            return null;
        }
        for (User u : users) {
            if (u.getUsername().equals(username) == true) {
                return u;
            }
        }
        return null;
    }

    // Tìm kiếm user theo email
    public User findUserByEmail(String email, ArrayList<User> users) {
        if (users == null) {
            System.out.println("ArrayList<User> to findUserByEmail null!");
            return null;
        }
        for (User u : users) {
            if (u.getEmail().equals(email) == true) {
                return u;
            }
        }
        return null;
    }

    // Kiểm tra định dạng
    public boolean checkFormat(String string, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(string);
        return matcher.matches();
    }

    // Tìm kiếm tài khoản
    public User findAccount(String username, String password, ArrayList<User> users) {
        if (users == null) {
            System.out.println("ArrayList<User> to findAccount null !");
            return null;
        }
        User user = findUserByUsername(username, users);
        if (user == null) {
            System.out.println("Username to findAccount wrong !");
            return null;
        } else {
            if (user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    //Cập nhập mật khẩu mới
    public User updateUserByPassword(String password, User user) {
        if (user == null) {
            System.out.println("User to updateUserByPassword null !");
            return null;
        }
        user.setPassword(password);
        return user;
    }

    //Cập nhật username mới
    public User updateUserByUsername(String username, User user) {
        if (user == null) {
            System.out.println("User to updatedUserByUsername null !");
            return null;
        }
        user.setUsername(username);
        return user;
    }

    //Cập nhật email mới
    public User updateUserByEmail(String email, User user) {
        if (user == null) {
            System.out.println("User to updatedUserByUsername null !");
            return null;
        }
        user.setEmail(email);
        return user;
    }
}
