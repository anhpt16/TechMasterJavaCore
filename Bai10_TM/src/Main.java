import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int a,b;
        boolean temp;
        do {
            temp = true;
            try {
                System.out.print("Nhập a: ");
                a = Integer.parseInt(new Scanner(System.in).nextLine());
                temp = true;
            } catch (Exception e) {
                temp = false;
            }
        } while(temp == false);

    }
}
