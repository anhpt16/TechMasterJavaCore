import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập tên: ");
        String name = sc.nextLine();
        System.out.println("Nhập tuổi: ");
        int age = sc.nextInt();
        sc.nextLine();
        System.out.println("Nhập địa chỉ: ");
        String address = sc.nextLine();
        System.out.println("Nhập email: ");
        String email = sc.nextLine();
        System.out.println(
                "Tên: " + name + "\n"+
                "Địa chỉ: " + address + "\n"+
                "Email: " + email + "\n"+
                "Tuổi: " + age
        );
    }
}
