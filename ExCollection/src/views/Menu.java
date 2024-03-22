package views;

import entities.Bill;
import entities.Customer;
import entities.Ministration;
import services.BillService;
import services.CustomerService;
import services.MinistrationService;
import utils.InputCheck;
import utils.Constant;

import java.util.ArrayList;

public class Menu {
    CustomerService customerService = CustomerService.getInstance();
    MinistrationService ministrationService = MinistrationService.getInstance();
    BillService billService = BillService.getInstance();

    InputCheck inputCheck = InputCheck.getInstance();

    public void startMenu(ArrayList<Customer> customers, ArrayList<Ministration> ministrations, ArrayList<Bill> bills){


        int choice;
        do {
            System.out.println("---------Menu--------");
            System.out.println("1. Nhập danh sách các khách hàng");
            System.out.println("2. In danh sách các khách hàng");
            System.out.println("3. Nhập danh sách các dịch vụ");
            System.out.println("4. In danh sách các dịch vụ");
            System.out.println("5. Nhập hóa đơn cho khách hàng");
            System.out.println("6. In danh sách các hóa đơn");
            System.out.println("7. Sắp xếp danh sách hóa đơn theo họ tên");
            System.out.println("8. Sắp xếp danh sách hóa đơn theo số lượng sử dụng");
            System.out.println("9. Bảng thống kê số tiền phải trả");
            System.out.println("10. Thoát");
            System.out.print("Chọn: ");
            choice = inputCheck.checkIntInput(1, 10);

            switch (choice){
                case Constant.INPUT_LIST_CUSTOMER:
                    customerService.addCustomer(customers);
                    break;
                case Constant.DISPLAY_LIST_CUSTOMER:
                    customerService.displayList(customers);
                    break;
                case Constant.INPUT_LIST_MINISTRATION:
                    ministrationService.addMinistration(ministrations);
                    break;
                case Constant.DISPLAY_LIST_MINISTRATION:
                    ministrationService.displayList(ministrations);
                    break;
                case Constant.INPUT_LIST_BILL:
                    billService.inputInfo(customers, ministrations, bills);
                    break;
                case Constant.DISPLAY_LIST_BILL:
                    billService.displayList(bills);
                    break;
                case Constant.SORT_BILL_NAME:
                    break;
                case Constant.SORT_BILL_AMOUNT:
                    break;
                case Constant.STATISTICAL_TABLE:
                    break;
                case Constant.EXIT:
                    return;
                default:
                    break;
            }
        } while(true);
    }

//    public void menuBill(){
//        int choice;
//        do {
//            System.out.println("1. Tiếp tục nhập");
//            System.out.println("2. Chuyển sang khách hàng khác");
//            System.out.println("3. Quay lại menu");
//            System.out.print("Chọn: ");
//            choice = inputCheck.checkIntInput(1,3);
//
//            switch (choice){
//                case 1:
//                    break;
//                case 2:
//                    break;
//                case 3:
//                    return;
//                default:
//                    break;
//            }
//        } while();
//    }

}
