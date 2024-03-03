import entities.Student;
import services.StudentService;
import views.Menu;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Menu menu = new Menu();
        ArrayList<Student> students = new ArrayList<>();

        menu.menuStudent(sc, students);
    }
}
