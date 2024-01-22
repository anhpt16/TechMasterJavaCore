import java.util.Scanner;

public class Homework5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào số dòng ma trận A: ");
        int rowA = Integer.parseInt(sc.nextLine());
        System.out.println("Nhập vào số cột ma trận A: ");
        int colA = Integer.parseInt(sc.nextLine());
        System.out.println("Nhập vào số dòng ma trận B: ");
        int rowB = Integer.parseInt(sc.nextLine());
        System.out.println("Nhập vào số cột ma trận B: ");
        int colB = Integer.parseInt(sc.nextLine());
        if(rowA != rowB || colA != colB || rowA == 0 || colA == 0){
            System.out.println("Không thể thực hiện !!!");
        }
        else{
            int[][] a = new int[rowA][colA];
            int[][] b = new int[rowB][colB];
            System.out.println("Nhập ma trận A: ");
            for (int i = 0; i < rowA; i++) {
                for (int j = 0; j < colA; j++) {
                    System.out.print("a[" + i + "][" + j + "] = ");
                    a[i][j] = Integer.parseInt(sc.nextLine());
                }
            }
            System.out.println("Nhập ma trận B: ");
            for (int i = 0; i < rowB; i++) {
                for (int j = 0; j < colB; j++) {
                    System.out.print("b[" + i + "][" + j + "] = ");
                    b[i][j] = Integer.parseInt(sc.nextLine());
                }
            }
            System.out.println("Tổng 2 ma trận: ");
            int[][] sum = new int[rowA][colA];
            for (int i = 0; i < rowA; i++) {
                for (int j = 0; j < colA; j++) {
                    sum[i][j] = a[i][j] + b[i][j];
                    System.out.print(sum[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
