package Slide12;

import java.math.BigInteger;
import java.time.LocalDate;

public class Patient extends Person{
    private BigInteger courtNumber;
    private LocalDate hospitalDay;

    public Patient(int id, String name, int age, BigInteger courtNumber, LocalDate hospitalDay) {
        super(id, name, age);
        this.courtNumber = courtNumber;
        this.hospitalDay = hospitalDay;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "Id: " + getId() +
                ", Name: " + getName() +
                ", Age: " + getAge() +
                ", CourtNumber: " + courtNumber +
                ", HospitalDay: " + hospitalDay +
                '}';
    }
}

