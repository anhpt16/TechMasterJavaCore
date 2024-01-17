import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Homework2dot1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào ngày giờ (yyyy/MM/dd HH:mm:ss): ");
        String dateTimeInp = sc.nextLine();
        LocalDateTime dateTime = LocalDateTime.parse(dateTimeInp, DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"));
        System.out.println("Ngày giờ nhập vào: " + dateTime);
        LocalDateTime dateTimeNow = LocalDateTime.now();
        System.out.println("Thời gian hiện tại là: " + dateTimeNow);
        System.out.println("Thời gian 3 ngày sau (so với ngày hiện tại): " + dateTimeNow.plusDays(3));
        System.out.println("Thời gian 3 ngày sau (so với ngày nhập vào): " + dateTime.plusDays(3));
    }
}
