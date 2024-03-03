package views;

import entities.Center;
import entities.Student;
import services.CenterService;
import services.CourseService;
import services.StudentService;
import utils.Constant;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    public void Menu(Scanner sc, Center center){
        CenterService centerService = new CenterService();
        CourseService courseService = new CourseService();
        StudentService studentService = new StudentService();
        int choose = 0;
        do {
            System.out.println("---------------------------------");
            System.out.println("1. Hiển thị thông tin trung tâm");
            System.out.println("2. Thêm học viên");
            System.out.println("3. Cập nhật thông tin");
            System.out.println("4. Xóa học viên");
            System.out.println("5. Tìm học viên theo tên");
            System.out.println("0. Thoát");
            System.out.print("Nhập lựa chọn: ");
            choose = Integer.parseInt(sc.nextLine());
            System.out.println("-----------------------------------");
            switch (choose){
                case Constant.DISPLAY:
                    centerService.displayInfo(center);
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
                case Constant.SEARCH_STUDENT_BY_NAME:
                    ArrayList<Student> listSearch
                case Constant.EXIT:
                    break;
                default:
                    break;
            }
        } while (choose != 0);
    }
}
