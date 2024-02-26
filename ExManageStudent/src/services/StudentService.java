package services;

import Comparators.StudentCompareByAge;
import Comparators.StudentCompareByName;
import Comparators.StudentCompareByPoint;
import entities.Student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import Utils.Constant;

public class StudentService {
    public void menu(Scanner sc, ArrayList<Student> students){
        int choose = 0;
        do {
            System.out.println("--------------------------");
            System.out.println("1. Xem danh sách học sinh");
            System.out.println("2. Thêm học sinh");
            System.out.println("3. Cập nhật điểm học sinh");
            System.out.println("4. Xóa học sinh");
            System.out.println("5. Xem danh sách học sinh theo lớp");
            System.out.println("6. Sắp xếp theo tên");
            System.out.println("7. Sắp xếp theo tuổi");
            System.out.println("8. Sắp xếp theo điểm");
            System.out.println("0. Thoát");
            System.out.print("Nhập lựa chọn: ");
            choose = Integer.parseInt(sc.nextLine());
            System.out.println("----------------------------");

            switch (choose){
                case Constant.DISPLAY_LIST:
                    displayListStudent(students);
                    break;
                case Constant.ADD_STUDENT:
                    System.out.println(addStudent(sc, students));;
                    break;
                case Constant.UPDATE_STUDENT:
                    System.out.println(updatePoint(sc, students));;
                    break;
                case Constant.DELETE_STUDENT:
                    System.out.println(deleteStudent(sc, students));;
                    break;
                case Constant.DISPLAY_LIST_BY_CR:
                    displayStudentByClassroom(sc, students);
                    break;
                case Constant.SORT_BY_NAME:
                    sortStudentByName(students);
                    break;
                case Constant.SORT_BY_AGE:
                    sortStudentByAge(students);
                    break;
                case Constant.SORT_BY_POINT:
                    sortStudentByPoint(students);
                    break;
                default:
                    break;
            }
        } while(choose != 0);
    }

    public String addStudent(Scanner sc, ArrayList<Student> students){
        System.out.print("Nhập số lượng học sinh muốn thêm: ");
        int count = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < count; i++) {
            System.out.println("Nhập thông tin của học sinh " + (i+1));
            System.out.print("--Nhập id: ");
            int id = Integer.parseInt(sc.nextLine());
            System.out.print("--Nhập tên: ");
            String name = sc.nextLine();
            System.out.print("--Nhập tuổi: ");
            int age = Integer.parseInt(sc.nextLine());
            System.out.print("--Nhập địa chỉ: ");
            String address = sc.nextLine();
            System.out.print("--Nhập điểm: ");
            double point = Double.parseDouble(sc.nextLine());
            System.out.print("--Nhập lớp học: ");
            String classroom = sc.nextLine();
            students.add(new Student(id, name, age, address, point, classroom));
        }
        return "Thêm thành công !";
    }

    public void displayListStudent(ArrayList<Student> students){
        for(Student s : students){
            System.out.println(s);
        }
    }

    public String updatePoint(Scanner sc, ArrayList<Student> students){
        System.out.print("Nhập id học sinh: ");
        int id = Integer.parseInt(sc.nextLine());
        for (Student s : students){
            if(s.getId() == id){
                System.out.print("Nhập vào điểm muốn sửa: ");
                double point = Double.parseDouble(sc.nextLine());
                s.setPoint(point);
                return "Sửa thành công !";
            }
        }
        return "Không tìm thấy id !";
    }

    public String deleteStudent(Scanner sc, ArrayList<Student> students){
        System.out.print("Nhập id học sinh: ");
        int id = Integer.parseInt(sc.nextLine());
        for(Student s : students){
            if(s.getId() == id){
                students.remove(s);
                return "Xóa thành công !";
            }
        }
        return "Không tìm thấy id !";
    }

    public void displayStudentByClassroom(Scanner sc, ArrayList<Student> students){
        System.out.print("Nhập vào lớp muốn xem: ");
        String classroom = sc.nextLine();

        int count = 0;
        for (Student s : students){
            if(s.getClassroom().equalsIgnoreCase(classroom) == true){
                System.out.println(s);
                count++;
            }
        }
        if(count == 0)
            System.out.println("Không có lớp học này !");
    }

    public void sortStudentByName(ArrayList<Student> students){
        Collections.sort(students, new StudentCompareByName());
        for (Student s : students){
            System.out.println(s);
        }
    }

    public void sortStudentByAge(ArrayList<Student> students){
        Collections.sort(students, new StudentCompareByAge());
        for (Student s : students){
            System.out.println(s);
        }
    }

    public void sortStudentByPoint(ArrayList<Student> students){
        Collections.sort(students, new StudentCompareByPoint());
        for (Student s : students){
            System.out.println(s);
        }
    }
}
