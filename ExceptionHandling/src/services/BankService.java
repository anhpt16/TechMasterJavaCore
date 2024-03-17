package services;

import entities.Bank;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BankService {
    public Bank inputInfo(){
        System.out.print("--Nhập tên ngân hàng: ");
        String name = new Scanner(System.in).nextLine();
        System.out.print("--Nhập lãi suất: ");
        double rate;
        do {
            try {
                rate = new Scanner(System.in).nextDouble();
                break;
            } catch(InputMismatchException e){
                e.printStackTrace();
                System.out.println("Nhập lại: ");
                continue;
            }
        } while(true);
        return new Bank(name, rate);
    }

    public void displayList(ArrayList<Bank> banks){
        try {
            for (Bank b : banks) {
                System.out.println(b);
            }
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public void addBank(ArrayList<Bank> banks){
        System.out.print("Nhập số lượng ngân hàng: ");
        int count;
        do {
            try{
                count = new Scanner(System.in).nextInt();
                break;
            } catch(InputMismatchException e){
                e.printStackTrace();
                System.out.print("Nhập lại: ");
                continue;
            }
        } while(true);
        for (int i = 0; i < count; i++) {
            System.out.println("Nhập thông tin cho ngân hàng " + (i + 1));
            try {
                banks.add(inputInfo());
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
