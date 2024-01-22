import java.util.Scanner;

public class OnClass2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String mathUse;
        String choose;
        do {
            System.out.println("Nhập vào a: ");
            double a = Double.parseDouble(sc.nextLine());
            System.out.println("Nhập vào b: ");
            double b = Double.parseDouble(sc.nextLine());
            System.out.println("Nhập vào phép toán: ");
            mathUse = sc.nextLine();
            switch (mathUse) {
                case "+":
                    System.out.println(a + " + " + b + " = " + (a + b));
                    break;
                case "-":
                    System.out.println(a + " - " + b + " = " + (a - b));
                    break;
                case "*":
                    System.out.println(a + " * " + b + " = " + (a * b));
                    break;
                case "/":
                    if(b == 0){
                        System.out.println("Không thể chia cho 0 !!!");
                    }
                    else
                        System.out.println(a + " : " + b + " = " + (a / b));
                    break;
                case "%":
                    if(b == 0){
                        System.out.println("Không thể chia cho 0 !!!");
                    }
                    else
                        System.out.println(a + " % " + b + " = " + (a % b));
                    break;
                default:
                    System.out.println("Phép toán sai!!!");
            }
            System.out.println("Tiếp tục (y/n)?");
            choose = sc.nextLine();
        } while (choose.equals("y"));

    }
}
