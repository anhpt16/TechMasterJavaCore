package services;

import entities.Course;
import entities.Student;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentService {
    public Student inputInfo(Scanner sc){
        System.out.print("--Nhập id cho học viên: ");
        int id = Integer.parseInt(sc.nextLine());
        System.out.print("--Nhập tên học viên: ");
        String name = sc.nextLine();
        System.out.print("--Nhập tuổi học viên: ");
        int age = Integer.parseInt(sc.nextLine());
        System.out.print("--Nhập học lực học viên: ");
        String level = sc.nextLine();
        return new Student(id, name, age, level);
    }

    public String addStudent(Scanner sc, Course course){
        System.out.print("Số lượng học viên muốn thêm: ");
        int numberStudent = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < numberStudent; i++) {
            System.out.println("Nhập thông tin cho học viên " + (i + 1) + ":");
            course.getStudents().add(inputInfo(sc));
        }
        return "Thêm thành công !";
    }

    public String updateStudent(Scanner sc, ArrayList<Student> students){
        System.out.print("Nhập id của học viên muốn sửa: ");
        int id = Integer.parseInt(sc.nextLine());
        for(Student s : students){
            if(s.getId() == id){
                System.out.print("Nhập level muốn sửa: ");
                String updateLevel = sc.nextLine();
                s.setLevel(updateLevel);
                return "Cập nhật thành công !";
            }
        }
        return "Không tìm thấy id !";
    }

    public String deleteStudent(Scanner sc, ArrayList<Student> students){
        System.out.print("Nhập id của học viên muốn xóa: ");
        int id = Integer.parseInt(sc.nextLine());
        for (Student s : students){
            if(s.getId() == id){
                students.remove(s);
                return "Xóa thành công !";
            }
        }
        return "Không tìm thấy id !";
    }
}
