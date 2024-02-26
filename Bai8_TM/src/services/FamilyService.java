package services;

import Utils.Constant;
import entities.Family;
import entities.Person;

import java.util.ArrayList;
import java.util.Scanner;

public class FamilyService {
    public Family input(Scanner sc){
        PersonService pr = new PersonService();
        ArrayList<Person> arrPerson = new ArrayList<>();

        System.out.println("Nhập id hộ dân: ");
        int id = Integer.parseInt(sc.nextLine());
        System.out.println("Nhập địa chỉ hộ dân: ");
        String address = sc.nextLine();

        System.out.println("Nhập số lượng thành viên: ");
        int count = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < count; i++) {
            System.out.println("Nhập thông tin cho thành viên " + (i+1) + ": ");
            arrPerson.add(pr.input(sc));
        }
        Family fam = new Family(id, address, arrPerson);
        return fam;
    }
    public void output(ArrayList<Family> fam){
        for (Family f : fam){
            System.out.println(f);
        }
    }
    public void menu(Scanner sc, ArrayList<Family> fam){
        int choose;
        do {
            System.out.println("1. Nhập");
            System.out.println("2. Xem");
            System.out.println("0. Thoát");
            System.out.println("Nhập lựa chọn: ");
            choose = Integer.parseInt(sc.nextLine());
            switch (choose){
                case Constant.EXIT:
                    break;
                case Constant.INPUT:
                    Family family = input(sc);
                    fam.add(family);
                    break;
                case Constant.OUTPUT:
                    output(fam);
                    break;
            }
        } while (choose != 0);
    }
}
