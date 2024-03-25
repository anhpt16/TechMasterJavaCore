package entities;

import utils.TypeCustomer;

import java.io.Serializable;

public class Customer implements Serializable {
    private int id;
    private String name;
    private String address;
    private String phoneNumber;
    private TypeCustomer type;
    private static int autoIncrease = 10000;

    public Customer(String name, String address, String phoneNumber, TypeCustomer type) {
        this.id = autoIncrease++;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
