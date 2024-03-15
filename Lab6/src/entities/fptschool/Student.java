package entities.fptschool;

import entities.User;

import java.io.Serializable;

public class Student extends User implements Serializable {
    private double avgScore;

    public Student(int id, String username, String password, int role, String name, String email, String address, String phone, double avgScore) {
        super(id, username, password, role, name, email, address, phone);
        this.avgScore = avgScore;
    }
}
