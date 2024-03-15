package entities;

import java.io.Serializable;

public class User implements Serializable {
    private int id;
    private String username;
    private String password;
    private int role;
    private String name;
    private String email;
    private String address;
    private String phone;

    public User(int id, String username, String password, int role, String name, String email, String address, String phone) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
        this.name = name;
        this.email = email;
        this.address = address;
        this.phone = phone;
    }
}
