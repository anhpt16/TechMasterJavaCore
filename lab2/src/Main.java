import entities.Student;
import services.StudentService;
import views.Menu;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Menu menuStudent = new Menu();
        StudentService studentService = new StudentService();
        ArrayList<Student> students = new ArrayList<>();

        menuStudent.menu(sc);
    }
}
