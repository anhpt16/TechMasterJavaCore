import java.util.Scanner;

public class Homework4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập n: ");
        int n = Integer.parseInt(sc.nextLine());
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println("a[" + i + "] = ");
            a[i] = Integer.parseInt(sc.nextLine());
        }
        System.out.println("Mảng vừa nhập: ");
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
        //Thêm một phần tử vào mảng
        System.out.println("Nhập phần tử muốn thêm: ");
        int b = Integer.parseInt(sc.nextLine());
        int[] aplus = new int[n + 1];
        for (int i = 0; i < n; i++) {
            aplus[i] = a[i];
        }
        aplus[n] = b;
        System.out.println("Mảng sau khi thêm: ");
        for (int i = 0; i <= n; i++) {
            System.out.print(aplus[i] + " ");
        }
        System.out.println();
        //Đổi chỗ phần tử thứ 2 và 3
        System.out.println("Đổi chỗ phần tử 2 và 3");
        int temp = aplus[1];
        aplus[1] = aplus[2];
        aplus[2] = temp;
        for (int i = 0; i <= n; i++) {
            System.out.print(aplus[i] + " ");
        }
        System.out.println();
        //Sắp xếp mảng _ buble sort
        for (int i = 0; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if(aplus[i] > aplus[j]){
                    int tempx = aplus[i];
                    aplus[i] = aplus[j];
                    aplus[j] = tempx;
                }
            }
        }
        System.out.println("Mảng sắp xếp từ nhỏ đến lớn: ");
        for (int i = 0; i <= n; i++) {
            System.out.print(aplus[i] + " ");
        }
    }
}
