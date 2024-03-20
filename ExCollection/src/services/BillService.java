package services;

import IServices.IBillService;
import entities.Bill;
import entities.Customer;
import entities.Ministration;
import utils.InputCheck;

import java.util.ArrayList;

public class BillService implements IBillService {
    CustomerService customerService = CustomerService.getInstance();
    MinistrationService ministrationService = MinistrationService.getInstance();
    InputCheck inputCheck = InputCheck.getInstance();
    @Override
    public Bill inputInfo(ArrayList<Customer> customers, ArrayList<Ministration> ministrations, ArrayList<Bill> bills) {
        int idCustomer;
        Customer customer;
        int customerCount = 0;
        do {
            System.out.print("--Nhập id khách hàng: ");
            idCustomer = inputCheck.checkIntInput();
            customer = customerService.findCustomerById(customers, idCustomer);
            if (customer == null){
                System.out.print("Không tồn tại khách hàng này, vui lòng nhập lại: ");
                continue;
            }
            for (Bill b : bills){
                if (b.getCustomer() == customer){
                    customerCount++;
                }
            }
            if (customerCount >= 5){
                System.out.print("Khách hàng này đã sử dụng đủ 5 dịch vụ !");
                continue;
            }
        } while(customerCount >= 5);

        int idMinistration;
        Ministration ministration;
        boolean ministrationExist = false;
        do {
            System.out.print("--Nhập id dịch vụ: ");
            idMinistration = inputCheck.checkIntInput();
            ministration = ministrationService.findMinistrationById(ministrations, idMinistration);
            if (ministration == null){
                System.out.print("Không tồn tại dịch vụ này, vui lòng nhập lại: ");
                continue;
            }
            for (Bill b : bills){
                if (b.getMinistration() == ministration){
                    ministrationExist = true;
                    break;
                }
            }
            if (ministrationExist == true){
                System.out.print("Khách hàng đã có hóa đơn cho dịch vụ này, nhập lại: ");
                continue;
            }
        } while(ministrationExist == true);


        return null;
    }
}
