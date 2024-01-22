import java.util.Scanner;

public class Homework3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập n: ");
        int n = Integer.parseInt(sc.nextLine());
        if (n <= 0) {
            System.out.println("n không hợp lệ !!!");
        } else {
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                System.out.println("a[" + i + "] = ");
                a[i] = Integer.parseInt(sc.nextLine());
            }
            int max = a[0];
            int min = a[0];
            for (int i = 1; i < n; i++) {
                if (a[i] > max) {
                    max = a[i];
                }
                if (a[i] < min) {
                    min = a[i];
                }
            }
            System.out.println("Max: " + max + "\tMin: " + min);
        }
    }
}
