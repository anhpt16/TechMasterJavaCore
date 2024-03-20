package services;

import IServices.ICustomerService;
import entities.Customer;
import utils.InputCheck;
import utils.TypeOfCustomer;

import java.util.ArrayList;
import java.util.Scanner;

public class CustomerService implements ICustomerService {
    private static CustomerService instance;
    private CustomerService(){}
    public static CustomerService getInstance(){
        if (instance == null){
            instance = new CustomerService();
        }
        return instance;
    }

    InputCheck inputCheck = InputCheck.getInstance();

    @Override
    public Customer inputInfo() {
        System.out.print("--Nhập tên khách hàng: ");
        String name = new Scanner(System.in).nextLine();
        System.out.print("--Nhập địa chỉ khách hàng: ");
        String address = new Scanner(System.in).nextLine();
        System.out.print("--Nhập số điện thoại: ");
        String phoneNumber = inputCheck.checkPhoneNumber();
        System.out.println("Chọn loại khách hàng: ");
        System.out.println("1-Personal" + "\t2-ADMINISTRATIVE" + "\t3-BUSINESS");
        TypeOfCustomer customerType = inputCheck.checkCustomerType();
        return new Customer(name, address, phoneNumber, customerType);
    }

    @Override
    public void displayList(ArrayList<Customer> customers) {
        inputCheck.checkNullArrayList(customers, "Customer", "displayList");
        System.out.println("-".repeat(107));
        System.out.printf("|%-6s|%-30s|%-30s|%-15s|%-20s|\n", "ID", "Name", "Address", "PhoneNumber", "Type");
        System.out.println("-".repeat(107));
        for (Customer c : customers){
            c.display();
        }
    }

    @Override
    public void addCustomer(ArrayList<Customer> customers) {
        inputCheck.checkNullArrayList(customers, "customer", "addCustomer");
        System.out.print("Nhập số lượng khách hàng muốn thêm: ");
        int count = inputCheck.checkIntInput();
        for (int i = 0; i < count; i++) {
            System.out.println("Nhập thông tin cho khách hàng thứ " + (i + 1));
            customers.add(inputInfo());
        }
    }

    @Override
    public Customer findCustomerById(ArrayList<Customer> customers, int id) {
        if (inputCheck.checkNullArrayList(customers, "Customer", "findCustomerById") == false)
            return null;
        for (Customer c : customers){
            if (c.getId() == id){
                return c;
            }
        }
        return null;
    }
}
