package services;

import IServices.IBillService;
import entities.Bill;
import entities.Customer;
import entities.Ministration;
import utils.InputCheck;

import java.util.ArrayList;

public class BillService implements IBillService {
    private static BillService instance;
    private BillService(){}
    public static BillService getInstance(){
        if (instance == null){
            instance = new BillService();
        }
        return instance;
    }

    CustomerService customerService = CustomerService.getInstance();
    MinistrationService ministrationService = MinistrationService.getInstance();
    InputCheck inputCheck = InputCheck.getInstance();

    @Override
    public void inputInfo(ArrayList<Customer> customers, ArrayList<Ministration> ministrations, ArrayList<Bill> bills) {
        int idCustomer;
        Customer customer;
        Ministration ministration;
        int customerCount = 0;
        int choice = 0;
        do {
            do {
                System.out.print("--Nhập id khách hàng: ");
                idCustomer = inputCheck.checkIntInput();
                customer = customerService.findCustomerById(customers, idCustomer);
                if (customer == null) {
                    System.out.println("Không tồn tại khách hàng này !");
                    continue;
                }
                for (Bill b : bills) {
                    if (b.getCustomer() == customer) {
                        customerCount++;
                    }
                }
                if (customerCount >= 5 || customerCount == ministrations.size()) {
                    System.out.print("Khách hàng này đã sử dụng đủ dịch vụ !");
                    System.out.println("1. Chuyển sang khách hàng khác");
                    System.out.println("2. Quay lại menu");
                    System.out.print("Chọn: ");
                    int choose = inputCheck.checkIntInput(1, 2);
                    switch (choose) {
                        case 1:
                            continue;
                        case 2:
                            return;
                    }
                }
            } while (customerCount >= 5);

            int idMinistration;
            boolean ministrationExist = false;
            do {
                System.out.print("--Nhập id dịch vụ: ");
                idMinistration = inputCheck.checkIntInput();
                ministration = ministrationService.findMinistrationById(ministrations, idMinistration);
                if (ministration == null) {
                    System.out.print("Không tồn tại dịch vụ này, vui lòng nhập lại: ");
                    continue;
                }
                for (Bill b : bills) {
                    if (b.getMinistration() == ministration) {
                        ministrationExist = true;
                        break;
                    }
                }
                if (ministrationExist) {
                    System.out.print("Khách hàng đã có hóa đơn cho dịch vụ này !");
                    System.out.println("1. Nhập tiếp");
                    System.out.println("2. Chuyển sang khách hàng khác");
                    System.out.println("3. Quay lại menu");
                    choice = inputCheck.checkIntInput(1, 3);
                    switch (choice) {
                        case 1:
                            continue;
                        case 2:
                            break;
                        case 3:
                            return;
                        default:
                            continue;
                    }
                }
                else {
                    System.out.println("--Nhập số lượng sử dụng: ");
                    int amount = inputCheck.checkIntInput();
                    bills.add(new Bill(customer, ministration, amount));
                    System.out.println("Nhập hóa đơn thành công !");
                    System.out.println("1. Nhập tiếp");
                    System.out.println("2. Chuyển sang khách hàng khác");
                    System.out.println("3. Quay lại menu");
                    choice = inputCheck.checkIntInput(1, 3);
                    switch (choice) {
                        case 1:
                            continue;
                        case 2:
                            break;
                        case 3:
                            return;
                        default:
                            continue;
                    }
                }

                break;
            } while (ministrationExist);
            continue;
        } while (choice == 2);

    }

    @Override
    public void displayList(ArrayList<Bill> bills) {
        inputCheck.checkNullArrayList(bills, "Bill", "displayList");
        System.out.println("-".repeat(90));
        System.out.printf("|%-30s|%-30s|%-10s|%-15s|\n", "Name", "Dịch vụ", "Số lượng", "Thời gian");
        System.out.println("-".repeat(90));
        for (Bill b : bills){
            b.display();
        }
    }
}
