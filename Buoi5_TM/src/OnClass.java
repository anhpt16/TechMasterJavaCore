import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Scanner;

public class OnClass {
    public static void main(String[] args) {
//        Student stu = new Student();
//        Season season = Season.Spring;
//        System.out.println(season);
//        stu.setName("Anh");
//        System.out.println(stu);
        Scanner sc = new Scanner(System.in);

//        System.out.println("Nhập id: ");
//        int id = Integer.parseInt(sc.nextLine());
//        System.out.println("Nhập tên: ");
//        String name = sc.nextLine();
//        System.out.println("Nhập tuổi: ");
//        int age = Integer.parseInt(sc.nextLine());
//        System.out.println("Nhập thu nhập: ");
//        BigDecimal salary = new BigDecimal(Double.parseDouble(sc.nextLine()));
//
//        Person person1 = new Person(id, name, age, salary);
//
//        System.out.println(person1);

//        System.out.println("Nhập id sản phẩm: ");
//        int id = Integer.parseInt(sc.nextLine());
//        System.out.println("Nhập tên sản phẩm");
//        String name = sc.nextLine();
//        System.out.println("Nhập giá sản phẩm");
//        BigDecimal price = new BigDecimal(sc.nextLine());
//
//        Product product1 = new Product(id, name, price);
//        System.out.println(product1);

        System.out.println("Nhập id: ");
        int id = Integer.parseInt(sc.nextLine());
        System.out.println("Nhập tên: ");
        String name = sc.nextLine();
        System.out.println("Nhập địa chỉ: ");
        String address = sc.nextLine();
        System.out.println("Nhập tuổi: ");
        int age = Integer.parseInt(sc.nextLine());
        System.out.println("Nhập số năm kinh nghiệm: ");
        double experience = Double.parseDouble(sc.nextLine());
        System.out.println("Nhập nơi làm việc: ");
        String placeWork = sc.nextLine();

        Employee employee1 = new Employee(id, name, address, age, experience, placeWork);

        System.out.println(employee1);
    }
}
