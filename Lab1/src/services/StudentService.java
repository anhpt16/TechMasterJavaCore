package services;

import entities.Student;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentService {
    public Student inputInfo(Scanner sc){
        System.out.print("--Nhập tên: ");
        String name = sc.nextLine();
        System.out.print("--Nhập địa chỉ: ");
        String address = sc.nextLine();
        return new Student(name, address);
    }
    public void outputInfo(ArrayList<Student> students){
        if (students == null){
            students = new ArrayList<>();
        }
        for (Student s : students){
            System.out.println(s);
        }
    }
}
