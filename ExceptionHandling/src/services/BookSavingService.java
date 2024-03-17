package services;

import Comparetor.BookSavingCompareByDeposit;
import entities.Bank;
import entities.BookSaving;
import entities.Customer;
import Comparetor.BookSavingCompareByName;

import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
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
                }
                if (cus == null){
                    System.out.println("Không tìm thấy khách hành này !");
                    System.out.print("Nhập lại: ");
                    continue;
                }
                break;
            } catch (InputMismatchException e) {
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
                }
                if (bak == null){
                    System.out.println("Không tìm thấy ngân hàng này !");
                    System.out.print("Nhập lại: ");
                    continue;
                }
                break;
            } catch (InputMismatchException e) {
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
            } catch (InputMismatchException e) {
                e.printStackTrace();
                System.out.print("Nhập lại");
                continue;
            }
        } while (true);

        bookSavings.add(new BookSaving(cus, bak, deposit));
    }

    public void displayList(ArrayList<BookSaving> bookSavings){
        try {
            for (BookSaving b : bookSavings){
                System.out.println(b);
            }
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public void sortByName(ArrayList<BookSaving> bookSavings){
        Collections.sort(bookSavings, new BookSavingCompareByName());
        try {
            for (BookSaving b : bookSavings){
                System.out.println(b);
            }
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public void sortByDeposit(ArrayList<BookSaving> bookSavings){
        Collections.sort(bookSavings, new BookSavingCompareByDeposit());
        try {
            for (BookSaving b : bookSavings){
                System.out.println(b);
            }
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
