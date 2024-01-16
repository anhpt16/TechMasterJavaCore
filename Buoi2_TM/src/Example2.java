import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Example2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        System.out.println("Nhập số thực: ");
//        double i = Double.parseDouble(sc.nextLine());
//        System.out.println(i);
        System.out.println("Nhập ngày: ");
        int dateInp = Integer.parseInt(sc.nextLine());
        System.out.println("Nhập tháng: ");
        int monthInp = Integer.parseInt(sc.nextLine());
        System.out.println("Nhập năm: ");
        int yearInp = Integer.parseInt(sc.nextLine());
        String dateCheck = dateInp + "/" + monthInp + "/" + yearInp;
        String dateInput = "16/12/2002";
        LocalDateTime ldt = LocalDateTime.now();
        LocalDate date = LocalDate.parse(dateCheck, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        System.out.println(date);
    }
}
