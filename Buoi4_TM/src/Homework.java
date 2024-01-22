import java.util.Scanner;

public class Homework {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào họ và tên: ");
        String name = sc.nextLine();
        String[] nameSep = name.split(" ");
        for (int i = 0; i < nameSep.length; i++) {
            nameSep[i] = nameSep[i].substring(0, 1).toUpperCase() + nameSep[i].substring(1);
        }
        System.out.println("Chuỗi sau khi chuẩn hóa: ");
        for (int i = 0; i < nameSep.length; i++) {
            System.out.print(nameSep[i] + " ");
        }
    }
}
