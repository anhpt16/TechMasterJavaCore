package entities;

public class Staff extends Person{
    private int id;
    private long salary;
    private static int autoIncrease = 100;

    public Staff(String name, String address, String phoneNumber, long salary) {
        super(name, address, phoneNumber);
        this.id = autoIncrease++;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public long getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return String.format("|%-5d|%-25s|%-25s|%-15s|%-15s|", id, getName(), getAddress(), getPhoneNumber(), salary);
    }
}
