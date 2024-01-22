import java.util.Scanner;

public class OnClass {
    public static void main(String[] args) {
        //Chia 0 --> n
        Scanner sc = new Scanner(System.in);
//        System.out.println("Nhập: ");
//        int n = Integer.parseInt(sc.nextLine());
//        int mur = 1;
//        for (int i = 2; i <= n; i++) {
//            mur *= i;
//        }
//        System.out.println("Tích = " + mur);
        //Tổng chẵn 0 --> n
//        int sum = 0;
//        for (int i = 2; i <= n; i++) {
//            if(i % 2 == 0){
//                sum += i;
//            }
//        }
//        System.out.println("Tổng chẵn: " + sum);
        //do_while_sum
            //Cách 1: while(next.equalsIgnoreCase("y"))
            //Cách 2: break;
            //Cách 3: do_while
        int i;
        int sum = 0;
        String next;
        do{
            System.out.println("Nhập: ");
            i = Integer.parseInt(sc.nextLine());
            sum += i;
            System.out.println("Có nhập tiếp không (y/n) ?");
            next = sc.nextLine();
        } while(next.equalsIgnoreCase("y"));
        System.out.println("Tổng: " + sum);
    }
}
