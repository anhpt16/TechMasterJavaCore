import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Homework {
    public static void main(String[] args) {
        //Input
        Scanner sc = new Scanner(System.in);
        System.out.println("Mời bạn nhập tên hàng nhập kho: ");
        String name = sc.nextLine();
        System.out.println("Mời bạn nhập ngày tháng năm sinh (yyyy/MM/dd): ");
        String dateInp = sc.nextLine();
        LocalDate date = LocalDate.parse(dateInp, DateTimeFormatter.ofPattern("yyyy/MM/dd"));
        System.out.println("Mời bạn nhập thời gian nhập hàng (yyyy/MM/dd HH:mm:ss): ");
        String dateTimeInp = sc.nextLine();
        LocalDateTime dateTime = LocalDateTime.parse(dateTimeInp, DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"));
        System.out.println("Mời bạn nhập thời gian (HH:mm:ss): ");
        String timeInp = sc.nextLine();
        LocalTime time = LocalTime.parse(timeInp, DateTimeFormatter.ofPattern("HH:mm:ss"));
        //Output
        System.out.println("Tên hàng nhập kho: " + name);
        System.out.println("Ngày tháng năm sinh: " + date);
        System.out.println("Thời gian nhập hàng: " + dateTime);
        System.out.println("Thời gian: " + time);
    }

}
