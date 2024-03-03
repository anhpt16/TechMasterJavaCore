package views;

import entities.Student;
import services.StudentService;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    public void menu(Scanner sc){


        StudentService studentService = new StudentService();
        ArrayList<Student> students = new ArrayList<>();

        int choose = 0;
        do {
            System.out.println("-----------------------");
            System.out.println("1. Nhập thông tin");
            System.out.println("2. Hiển thị thông tin");
            System.out.println("0. Thoát");
            System.out.print("Nhập lựa chọn: ");
            choose = Integer.parseInt(sc.nextLine());
            System.out.println("-----------------------");

            switch (choose){
                case 1:
                    students.addAll(studentService.inputInfo(sc));
                    break;
                case 2:
                    studentService.outputInfo(students);
                    studentService.percentageLevelStudent(students);
                    break;
                case 0:
                    break;
            }
        } while(choose != 0);
    }
}
