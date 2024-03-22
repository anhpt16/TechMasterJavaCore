package entities;

import utils.TypeOfCustomer;

public class Customer {
    private int id;
    private String name;
    private String address;
    private String phoneNumber;
    private TypeOfCustomer customerType;
    private static int autoIncrease = 10000;

    public Customer(String name, String address, String phoneNumber, TypeOfCustomer customerType) {
        this.id = autoIncrease++;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.customerType = customerType;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void display(){
        System.out.printf("|%-6d|%-30s|%-30s|%-15s|%-20s|\n", id, name, address, phoneNumber, customerType.value);
    }
}
