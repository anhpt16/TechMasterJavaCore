package entities;

import java.io.Serializable;
import java.time.LocalDate;

public class Bill implements Serializable {
    private Customer customer;
    private Ministration ministration;
    private double capacity;
    private LocalDate date;

    public Bill(Customer customer, Ministration ministration, double capacity) {
        this.customer = customer;
        this.ministration = ministration;
        this.capacity = capacity;
        this.date = java.time.LocalDate.now();
    }

}
