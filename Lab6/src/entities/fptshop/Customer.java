package entities.fptshop;

import entities.User;

import java.io.Serializable;

public class Customer extends User implements Serializable {
    private long balance;

    public Customer(int id, String username, String password, int role, String name, String email, String address, String phone, long balance) {
        super(id, username, password, role, name, email, address, phone);
        this.balance = balance;
    }
}
