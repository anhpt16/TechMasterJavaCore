package views;

import entities.Student;
import services.StudentService;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    public void menuStudent(Scanner sc, ArrayList<Student> students){
        if (students == null){
            students = new ArrayList<>();
        }
        StudentService studentService = new StudentService();
        String next;
        do {
            students.add(studentService.inputInfo(sc));
            do {
                System.out.print("Bạn có muốn nhập tiếp không (y/n) ?");
                next = sc.nextLine();
            } while (!next.equalsIgnoreCase("y") && !next.equalsIgnoreCase("n"));
            if (next.equalsIgnoreCase("n")){
                studentService.outputInfo(students);
            }
        } while(!next.equalsIgnoreCase("n"));
    }
}
