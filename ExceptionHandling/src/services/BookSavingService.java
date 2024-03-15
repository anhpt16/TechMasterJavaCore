package services;

import entities.Bank;
import entities.BookSaving;
import entities.Customer;

import java.util.ArrayList;
import java.util.Scanner;

public class BookSavingService {
    public void inputInfo(ArrayList<Customer> customers, ArrayList<Bank> banks, ArrayList<BookSaving> bookSavings) {
        System.out.print("--Nhập mã khách hàng: ");
        Customer cus = null;
        Bank bak = null;
        int idC;
        do {
            try {
                idC = new Scanner(System.in).nextInt();
                for (Customer c : customers) {
                    if (c.getId() == idC) {
                        cus = c;
                        break;
                    }
                    System.out.println("Không tìm thấy khách hàng này !");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                e.printStackTrace();
                System.out.print("Nhập lại: ");
                continue;
            }
        } while (true);

        System.out.print("--Nhập mã ngân hàng: ");
        int idB;
        do {
            try {
                idB = new Scanner(System.in).nextInt();
                for (Bank b : banks) {
                    if (b.getId() == idB) {
                        bak = b;
                        break;
                    }
                    System.out.println("Không tìm thấy ngân hàng này !");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                e.printStackTrace();
                System.out.print("Nhập lại: ");
                continue;
            }
        } while (true);

        int count = 0;
        try {
            for (BookSaving i : bookSavings) {
                if (i.getCustomer().getId() == idC && i.getBank().getId() == idB) {
                    count++;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (count == 5) {
            System.out.println("Đã đủ 5 sổ tiết kiệm !");
            return;
        }

        System.out.print("--Nhập tiền gửi: ");
        long deposit;
        do {
            try {
                deposit = new Scanner(System.in).nextLong();
                break;
            } catch (NumberFormatException e) {
                e.printStackTrace();
                System.out.print("Nhập lại");
                continue;
            }
        } while (true);

        bookSavings.add(new BookSaving(cus, bak, deposit));
    }
    
}
