package services;

import MyException.InvalidPhoneException;
import entities.Bank;
import entities.Customer;
import utils.Validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomerService {
    public Customer inputInfo(){
        System.out.print("--Nhập họ tên: ");
        String name = new Scanner(System.in).nextLine();
        System.out.print("--Nhập địa chỉ: ");
        String address = new Scanner(System.in).nextLine();
        System.out.print("--Nhập số điện thoại: ");
        String phoneNumber;
        do {
            phoneNumber = new Scanner(System.in).nextLine();
            try {
                Validation.checkPhoneNumber(phoneNumber);
                break;
            } catch (InvalidPhoneException e){
                e.printStackTrace();
                continue;
            }
        } while(true);
        System.out.println("--Chọn loại khách hàng");
        System.out.println("(1): Cá nhân" + "\t" + "(2): Tập thể" + "\t" + "(3): Doanh nghiệp");
        int type = 0;
        do {
            try {
                type = new Scanner(System.in).nextInt();
                if (type != 1 || type != 2 || type != 3){
                    System.out.println("Chọn lại: ");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                e.printStackTrace();
                System.out.print("Chọn lại: ");
                continue;
            }
        } while (true);
        return new Customer(name, address, phoneNumber, type);
    }

    public void displayList(ArrayList<Customer> customers){
        try {
            for (Customer c : customers) {
                c.toString();
            }
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public void addCustomer(ArrayList<Customer> customers){
        System.out.print("Nhập số lượng khách hàng muốn thêm: ");
        int choose;
        do {
            try {
                choose = new Scanner(System.in).nextInt();
                break;
            } catch (NumberFormatException e) {
                e.printStackTrace();
                System.out.print("Nhập lại: ");
                continue;
            }
        } while (true);
        for (int i = 0; i < choose; i++) {
            System.out.println("Nhập thông tin cho khách hàng " + (i + 1));
            try {
                customers.add(inputInfo());
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
