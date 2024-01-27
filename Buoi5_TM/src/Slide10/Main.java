package Slide10;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập số lượng nhân viên: ");
        int n = Integer.parseInt(sc.nextLine());

        Employee[] arrEmp = new Employee[n];
        int id;
        String name;
        int age;
        double exp;

        for (int i = 0; i < n; i++) {
            do {
                System.out.println("Nhập id nhân viên " + (i + 1) + ": ");
                id = Integer.parseInt(sc.nextLine());
                if (id <= 0) {
                    System.out.println("*Id phải lớn hơn 0 !*");
                }
            } while (id <= 0);
            System.out.println("Nhập tên cho nhân viên " + (i + 1) + ": ");
            name = sc.nextLine();
            do {
                System.out.println("Nhập tuổi cho nhân viên " + (i + 1) + ": ");
                age = Integer.parseInt(sc.nextLine());
                if (age <= 0) {
                    System.out.println("*Tuổi phải lớn hơn 0 !*");
                }
            } while (age <= 0);
            do {
                System.out.println("Nhập số năm kinh nghiệm cho nhân viên " + (i + 1) + ": ");
                exp = Double.parseDouble(sc.nextLine());
                if (exp >= age) {
                    System.out.println("*Số năm kinh nghiệm phải nhỏ hơn số tuổi !*");
                }
            } while (exp >= age);
            arrEmp[i] = new Employee(id, name, age, exp);
        }

        System.out.println("Thông tin của các Employee vừa nhập: ");
        for (int i = 0; i < n; i++) {
            System.out.println(arrEmp[i]);
        }
    }
}
