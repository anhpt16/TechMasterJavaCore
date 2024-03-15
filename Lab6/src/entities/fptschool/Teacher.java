package entities.fptschool;

import entities.User;

import java.io.Serializable;

public class Teacher extends User implements Serializable {
    private Enum major;

    public Teacher(int id, String username, String password, int role, String name, String email, String address, String phone, Enum major) {
        super(id, username, password, role, name, email, address, phone);
        this.major = major;
    }
}
