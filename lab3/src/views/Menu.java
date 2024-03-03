package views;

import java.util.Scanner;

public class Menu {
    public void menuWorker(Scanner sc){

        int choose = 0;
        do {
            System.out.println("========== Worker Management ==========");
            System.out.println("1. Add Worker");
            System.out.println("2. Up salary");
            System.out.println("3. Down salary");
            System.out.println("4. Display Infomation salary");
            System.out.println("5. Exit");

            System.out.print("Nhập lựa chọn: ");
            choose = Integer.parseInt(sc.nextLine());
            System.out.println("========================================");

            switch (choose){

            }
        } while (choose != 5);
    }
}
