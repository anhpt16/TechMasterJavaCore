package entities;

public class Customer {
    private int id;
    private String name;
    private String address;
    private String phoneNumber;
    private int type;
    private static int autoIncrease = 10000;

    public Customer(String name, String address, String phoneNumber, int type) {
        this.id = autoIncrease;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.type = type;
        autoIncrease++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", type=" + type +
                '}';
    }
}
