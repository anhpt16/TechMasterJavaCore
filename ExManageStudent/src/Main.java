import entities.Student;
import services.StudentService;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();
        StudentService studentService = new StudentService();

        studentService.menu(sc, students);
    }
}
