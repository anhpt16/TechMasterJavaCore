import com.sun.security.jgss.GSSUtil;

import java.util.Scanner;

public class OnClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choose;
        do {
            System.out.println("0. Thoát");
            System.out.println("1. Phương trình bậc nhất");
            System.out.println("2. Phương trình bậc hai");
            System.out.println("3. Tiền điện");
            System.out.println("-- CHỌN (0-3): ");
            choose = Integer.parseInt(sc.nextLine());
            //Các biến sử dụng trong case
            double a;
            double b;
            double c;
            String next;
            switch (choose){
                case 0:
                    //
                    System.exit(0);
                case 1:
                    do{
                        System.out.println("a*x + b = 0");
                        System.out.println("Nhập vào a: ");
                        a = Integer.parseInt(sc.nextLine());
                        System.out.println("Nhập vào b: ");
                        b = Integer.parseInt(sc.nextLine());
                        if (a == 0 && b == 0) {
                            System.out.println("Vô số nghiệm");
                        } else if (b != 0) {
                            System.out.println("Vô nghiệm");
                        } else
                            System.out.println("x = " + (-b / a));
                        System.out.println("Tiếp tục (y/n) ?");
                        next = sc.nextLine();
                    }while(next.equals("y"));
                    break;
                case 2:
                    do {
                        System.out.println("a*x^2 + b*x + c = 0");
                        System.out.println("Nhập vào a: ");
                        a = Double.parseDouble(sc.nextLine());
                        System.out.println("Nhập vào b: ");
                        b = Double.parseDouble(sc.nextLine());
                        System.out.println("Nhập vào c: ");
                        c = Double.parseDouble(sc.nextLine());
                        if (a == 0) {
                            if (b == 0 && c == 0) {
                                System.out.println("Phương trình vô số nghiệm");
                            } else if (b != 0) {
                                System.out.println("Phương trình vô nghiệm");
                            } else
                                System.out.println("x = " + (-c / b));
                        } else {
                            double delta = b * b - 4 * a * c;
                            if (delta < 0) {
                                System.out.println("Phương trình vô nghiệm");
                            } else if (delta == 0) {
                                System.out.println("x = " + (-b / a));
                            } else {
                                System.out.println("Phương trình có 2 nghiệm phân biệt: ");
                                System.out.println("x1 = " + (-b - Math.sqrt(delta / (2 * a))));
                                System.out.println("x2 = " + (-b + Math.sqrt(delta / (2 * a))));
                            }
                        }
                        System.out.println("Tiếp tục (y/n) ?");
                        next = sc.nextLine();
                    } while(next.equals("y"));
                    break;
                case 3:
                    do{
                        System.out.println("Nhập vào số điện: ");
                        long count = Long.parseLong(sc.nextLine());
                        if(count > 0 && count <= 50){
                            System.out.println("Tiền điện: " + (count*1000));
                        }
                        else if(count <= 0){
                            System.out.println("Sai");
                        }
                        else{
                            System.out.println("Tiền điện: " + ((50*1000) + (count-50)*1200));
                        }
                        System.out.println("Tiếp tục (y/n) ?");
                        next = sc.nextLine();
                    } while(next.equals("y"));
                    break;
                default:
                    System.out.println("Điền sai !!!");
            }
        } while (choose != 0);

    }

}
