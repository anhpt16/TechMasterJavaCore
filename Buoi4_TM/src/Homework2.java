import java.util.Scanner;

public class Homework2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập n: ");
        int n = Integer.parseInt(sc.nextLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Nhập a[" + i + "]: ");
            arr[i] = Integer.parseInt(sc.nextLine());
        }
        System.out.println("Mảng vừa nhập là: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        System.out.println("Các phần tử chẵn tăng lên 1 phần tử: ");
        for (int i = 0; i < n; i++) {
            if(arr[i] % 2 == 0){
                arr[i]++;
            }
            System.out.print(arr[i] + " ");
        }

    }
}
