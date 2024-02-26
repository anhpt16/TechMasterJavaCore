package services;

import Utils.Constant;
import entities.Person;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PersonService {
    public Person input(Scanner sc){
        System.out.println("Nhập id: ");
        int id = Integer.parseInt(sc.nextLine());
        System.out.println("Nhập tên: ");
        String name = sc.nextLine();
        System.out.println("Nhập ngày sinh: ");
        String dateString = sc.nextLine();
        LocalDate birth = LocalDate.parse(dateString, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        System.out.println("Nhập nghề: ");
        String job = sc.nextLine();
        Person pr = new Person(id, name, birth, job);
        return pr;
    }
    public void output(ArrayList<Person> arr){
        for(Person p : arr){
            System.out.println(p);
        }
    }
    public void menu(Scanner sc, ArrayList<Person> lstPerson){
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
                    Person person = input(sc);
                    lstPerson.add(person);
                    break;
                case Constant.OUTPUT:
                    output(lstPerson);
                    break;
            }
        } while (choose != 0);
    }
}
