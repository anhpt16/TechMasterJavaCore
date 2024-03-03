package services;

import entities.Center;
import entities.Course;
import utils.Constant;
import entities.Student;

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


}
