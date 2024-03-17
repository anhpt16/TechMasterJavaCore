package services;

import MyException.InvalidPhoneException;
import MyException.InvalidPositiveNumber;
import entities.Bank;
import entities.BookSaving;
import entities.Customer;
import utils.CustomerType;
import utils.Validation;

import java.util.*;

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
        System.out.println("--Chọn loại khách hàng:");
        System.out.println("(1): Cá nhân" + "\t" + "(2): Tập thể" + "\t" + "(3): Doanh nghiệp");
        int typeInput = 0;
        CustomerType customerType = null;
        do {
            try {
                typeInput = new Scanner(System.in).nextInt();
                if (typeInput != 1 && typeInput != 2 && typeInput != 3){
                    System.out.println("Chọn lại: ");
                    continue;
                }
            } catch (InputMismatchException e) {
                e.printStackTrace();
                System.out.print("Chọn lại: ");
                continue;
            }

            switch (typeInput){
                case 1:
                    customerType = CustomerType.INDIVIDUAL;
                    break;
                case 2:
                    customerType = CustomerType.GROUP;
                    break;
                case 3:
                    customerType = CustomerType.BUSINESS;
                    break;
            }
            break;
        } while (true);
        return new Customer(name, address, phoneNumber, customerType);
    }

    public void displayList(ArrayList<Customer> customers){
        try {
            for (Customer c : customers) {
                System.out.println(c);
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
            } catch (InputMismatchException e) {
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

    public Customer findCustomerById(ArrayList<Customer> customers, int id){
        for (Customer c : customers){
            if (c.getId() == id){
                return c;
            }
        }
        return null;
    }

    public void displayTotalDeposit(ArrayList<Customer> customers, ArrayList<BookSaving> bookSavings){
        System.out.print("Nhập id khách hàng: ");
        int idCustomer;
        Customer customer;
        while (true) {
            try {
                idCustomer = new Scanner(System.in).nextInt();
            } catch(InputMismatchException e) {
                e.printStackTrace();
                System.out.print("Yêu cầu nhập số, nhập lại: ");
                continue;
            }
            customer = findCustomerById(customers, idCustomer);
            if (findCustomerById(customers, idCustomer) == null) {
                System.out.println("Khách hàng không tồn tại, nhập lại: ");
                continue;
            }
            break;
        }
        Map<Bank, Long> totalDeposit = new HashMap<>();
        long totalAll = 0;
        for (BookSaving b : bookSavings){
            if (b.getCustomer() == customer){
                if (totalDeposit.containsKey(b.getBank())){
                    Long currenValue = totalDeposit.get(b.getBank());
                    totalDeposit.put(b.getBank(), currenValue + b.getDeposit());
                }
                else {
                    totalDeposit.put(b.getBank(), b.getDeposit());
                }
                totalAll += b.getDeposit();
            }
        }
        if (totalAll == 0){
            System.out.println(customer.getName() + " chưa gửi bất kỳ sổ tiết kiệm nào !");
            return;
        }
        for (Bank key : totalDeposit.keySet()){
            System.out.println("---Tổng tiền của " + customer.getName() + " tại ngân hàng " + key.getName() + " là: " + totalDeposit.get(key));
        }
        System.out.println("-->Tổng số tiền đã gửi: " + totalAll);
    }
}
