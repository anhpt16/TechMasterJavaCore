import java.util.Scanner;

public class OnClass3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

//        int n;
//        System.out.println("Nhập số lượng phần tử: ");
//        n = Integer.parseInt(sc.nextLine());
//        int a[] = new int[n];
//        for (int i = 0; i < n; i++) {
//            System.out.println("Nhập vào phần tử " + (i + 1) + " :");
//            a[i] = Integer.parseInt(sc.nextLine());
//        }
//        System.out.println("Các phần tử nhập vào là: ");
//        for (int i = 0; i < n ; i++) {
//            System.out.print(a[i] + " ");
//        }
//        System.out.println("");
//        for (int i = 0; i < n ; i++){
//            if(a[i] % 2 == 0){
//                a[i]++;
//            }
//        }
//        System.out.println("Tăng các phần tử chẵn lên 1 đơn vị: ");
//        for (int i = 0; i < n ; i++){
//            System.out.print(a[i] + " ");
//        }
        //Mảng 2 chiều
        int sum = 0;
        System.out.println("Nhập vào số dòng: ");
        int row = Integer.parseInt(sc.nextLine());
        System.out.println("Nhập vào số cột");
        int col = Integer.parseInt(sc.nextLine());
        int[][] arr = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.println("Nhập a[" + i + "][" + j + "]: ");
                arr[i][j] = Integer.parseInt(sc.nextLine());
                sum += arr[i][j];
            }
        }
        System.out.println("Tổng = " + sum);
    }
}
