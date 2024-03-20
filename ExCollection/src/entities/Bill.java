package entities;

import java.time.LocalDate;

public class Bill {
    private Customer customer;
    private Ministration ministration;
    private int amount;
    private LocalDate date;

    public Bill(Customer customer, Ministration ministration, int amount) {
        this.customer = customer;
        this.ministration = ministration;
        this.amount = amount;
        this.date = java.time.LocalDate.now();
    }

    public Customer getCustomer() {
        return customer;
    }

    public Ministration getMinistration() {
        return ministration;
    }
}
