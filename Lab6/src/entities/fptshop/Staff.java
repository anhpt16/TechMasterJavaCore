package entities.fptshop;

import entities.User;

import java.io.Serializable;

public class Staff extends User implements Serializable {
    public Staff(int id, String username, String password, int role, String name, String email, String address, String phone) {
        super(id, username, password, role, name, email, address, phone);
    }
}
