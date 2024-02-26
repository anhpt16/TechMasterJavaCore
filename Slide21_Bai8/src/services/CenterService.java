package services;

import entities.Center;
import entities.Course;
import Utils.Constant;
import entities.Student;

import java.util.ArrayList;
import java.util.Scanner;

public class CenterService {
    //Nhập thông tin cho trung tâm
    public Center inputInfo(Scanner sc){
        CourseService courseService = new CourseService();

        System.out.print("Nhập tên người quản lý: ");
        String manager = sc.nextLine();
        System.out.print("Nhập tên giảng viên: ");
        String teacher = sc.nextLine();
        System.out.println("Nhập thông tin cho khóa học: ");
        Course course = courseService.inputInfo(sc);
        return new Center(manager, teacher, course);
    }
    //Hiển thị thông tin trung tâm
    public void displayInfo(Center center){
        System.out.println("Quản lý: " + center.getManager());
        System.out.println("Giảng viên: " + center.getTeacher());
        System.out.println("Khóa học: " + center.getCourse().getSubject());
        System.out.println("Danh sách học viên: ");
        for (Student s : center.getCourse().getStudents()) {
            System.out.println(s);
        }
    }

    public void Menu(Scanner sc, Center center){
        CourseService courseService = new CourseService();
        StudentService studentService = new StudentService();
        int choose = 0;
        do {
            System.out.println("---------------------------------");
            System.out.println("1. Hiển thị thông tin trung tâm");
            System.out.println("2. Thêm học viên");
            System.out.println("3. Cập nhật thông tin");
            System.out.println("4. Xóa học viên");
            System.out.println("0. Thoát");
            System.out.print("Nhập lựa chọn: ");
            choose = Integer.parseInt(sc.nextLine());
            System.out.println("-----------------------------------");
            switch (choose){
                case Constant.DISPLAY:
                    displayInfo(center);
                    break;
                case Constant.ADD:
                    System.out.println(studentService.addStudent(sc, center.getCourse()));
                    break;
                case Constant.UPDATE:
                    System.out.println(studentService.updateStudent(sc, center.getCourse().getStudents()));;
                    break;
                case Constant.DELETE:
                    System.out.println(studentService.deleteStudent(sc, center.getCourse().getStudents()));;
                    break;
                default:
                    break;
            }
        } while (choose != 0);
    }
}
