package services;

import entities.Course;
import entities.Student;

import java.util.ArrayList;
import java.util.Scanner;

public class CourseService {
    public Course inputInfo(Scanner sc){
        ArrayList<Student> students = new ArrayList<>();
        StudentService studentService = new StudentService();

        System.out.print("Nhập tên môn học: ");
        String subject = sc.nextLine();
        System.out.print("Nhập số lượng học viên: ");
        int count = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < count; i++) {
            System.out.println("Nhập thông tin cho học viên " + (i+1) + ":");
            students.add(studentService.inputInfo(sc));
        }
        return new Course(subject, students);
    }

}
