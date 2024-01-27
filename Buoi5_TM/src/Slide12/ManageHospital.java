package Slide12;

import java.math.BigInteger;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ManageHospital {
    public static void main(String[] args) {
        Doctor doctor = new Doctor(123, "Nhật Anh", 21, "CNTT", 100);

        BigInteger courtNumber = new BigInteger("2342535");
        LocalDate hospitalDay = LocalDate.parse("2002-12-16", DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        Patient patient = new Patient(234, "Nhật Anh", 22, courtNumber, hospitalDay);

        System.out.println(doctor);
        System.out.println(patient);
    }
}
