package QLNV;

import java.math.BigInteger;
import java.time.LocalDate;

public class Employee {
    private String id;
    private String name;
    private LocalDate birth;
    private Sex sex;
    private String phoneNumber;
    private String email;
    private String address;

    public Employee(String id, String name, LocalDate birth, Sex sex, String phoneNumber, String email, String address) {
        this.id = id;
        this.name = name;
        this.birth = birth;
        this.sex = sex;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public Sex getSex() {
        return sex;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", birth=" + birth +
                ", sex=" + sex +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
