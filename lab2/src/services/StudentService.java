package services;

import entities.Student;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentService {
    public ArrayList<Student> inputInfo(Scanner sc){
        ArrayList<Student> students = new ArrayList<>();

        System.out.print("Số lượng học sinh muốn nhập: ");
        int count = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < count; i++) {
            System.out.print("Nhập tên học sinh " + (i + 1) + ": ");
            String name = sc.nextLine();
            System.out.print("--Nhập điểm toán: ");
            double scoreMath = Double.parseDouble(sc.nextLine());
            System.out.print("--Nhập điểm thể chất: ");
            double scorePhysic = Double.parseDouble(sc.nextLine());
            System.out.print("--Nhập điểm vật lý: ");
            double scoreChemistry = Double.parseDouble(sc.nextLine());
            students.add(new Student(name, scoreMath, scorePhysic, scoreChemistry));
        }
        return students;
    }

    public void outputInfo(ArrayList<Student> students){
        if (students == null){
            students = new ArrayList<>();
        }
        for (Student s : students){
            System.out.println(s);
        }
    }

    public void percentageLevelStudent(ArrayList<Student> students){
        if (students == null){
            students = new ArrayList<>();
        }
        double perA = 0, perB = 0, perC = 0;
        for (Student s : students){
            if (s.level(s.getScoreMath(), s.getScorePhysic(), s.getScoreChemistry()).equalsIgnoreCase("A")){
                perA++;
            }
            else if (s.level(s.getScoreMath(), s.getScorePhysic(), s.getScoreChemistry()).equalsIgnoreCase("B")){
                perB++;
            }
            else
                perC++;
        }
        System.out.println("A: " + (perA/students.size()) * 100 + "%");
        System.out.println("B: " + (perB/students.size()) * 100 + "%");
        System.out.println("C: " + (perC/students.size()) * 100 + "%");
    }
}
