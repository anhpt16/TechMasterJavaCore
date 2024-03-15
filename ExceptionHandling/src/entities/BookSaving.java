package entities;

public class BookSaving {
    private Customer customer;
    private Bank bank;
    private long deposit;

    public BookSaving(Customer customer, Bank bank, long deposit) {
        this.customer = customer;
        this.bank = bank;
        this.deposit = deposit;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public long getDeposit() {
        return deposit;
    }

    public void setDeposit(long deposit) {
        this.deposit = deposit;
    }
}
