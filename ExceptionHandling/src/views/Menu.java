package views;

import entities.Bank;
import entities.BookSaving;
import entities.Customer;
import services.BankService;
import services.BookSavingService;
import services.CustomerService;
import utils.Constant;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    public void startMenu(ArrayList<Customer> customers, ArrayList<Bank> banks, ArrayList<BookSaving> bookSavings){
        CustomerService customerService = new CustomerService();
        BankService bankService = new BankService();
        BookSavingService bookSavingService = new BookSavingService();

        if (customers == null){
            System.out.println("ArrayList<Customer> to startMenu null !");
            customers = new ArrayList<>();
        }
        else if (banks == null){
            System.out.println("ArrayList<Bank> to startMenu null !");
            banks = new ArrayList<>();
        }
        else if (bookSavings == null){
            System.out.println("ArrayList<BookSaving> to startMenu null !");
            bookSavings = new ArrayList<>();
        }
        System.out.println("------------ Menu -------------");
        int choose = 0;
        do {
            System.out.println("1. Nhập danh sách các khách hàng");
            System.out.println("2. In danh sách các khách hàng");
            System.out.println("3. Nhập danh sách các ngân hàng");
            System.out.println("4. In ra danh sách các ngân hàng");
            System.out.println("5. Nhập danh sách sổ tiết kiệm");
            System.out.println("6. In danh sách sổ tiết kiệm");
            System.out.println("7. Sắp xếp sổ tiết kiệm theo tên");
            System.out.println("8. Sắp xếp sổ tiết kiệm theo số tiền gửi");
            System.out.println("9. Bảng thống kê");
            System.out.println("10. Thoát");
            System.out.print("Nhập lựa chọn: ");
            do {
                try {
                    choose = new Scanner(System.in).nextInt();
                    if (choose < 1 || choose > 10){
                        System.out.print("Nhập đúng lựa chọn: ");
                        continue;
                    }
                    break;
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    System.out.print("Nhập lại:");
                    continue;
                }
            } while(true);
            switch (choose){
                case Constant.INPUT_CUSTOMER:
                    customerService.addCustomer(customers);
                    break;
                case Constant.DISPLAY_CUSTOMER:
                    customerService.displayList(customers);
                    break;
                case Constant.INPUT_BANK:
                    bankService.addBank(banks);
                    break;
                case Constant.DISPLAY_BANK:
                    bankService.displayList(banks);
                    break;
                case Constant.INPUT_BOOKSAVING:
                    bookSavingService.inputInfo(customers, banks, bookSavings);
                    break;
                case Constant.DISPLAY_BOOKSAVING:
                    bookSavingService.displayList(bookSavings);
                    break;
                case Constant.BOOKSAVING_SORTBY_NAME:
                    bookSavingService.sortByName(bookSavings);
                    break;
                case Constant.BOOKSAVING_SORTBY_DEPOSIT:
                    bookSavingService.sortByDeposit(bookSavings);
                    break;
                case Constant.TOTAL_DEPOSIT:
                    customerService.displayTotalDeposit(customers, bookSavings);
                    break;
                case Constant.EXIT:
                    return;
            }
        } while(true);
    }
}
