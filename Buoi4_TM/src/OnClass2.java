import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OnClass2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String next;
        //Thông tin
        List<student> lst = new ArrayList<student>();
        String name;
        String address;
        int age;
        do{
            System.out.println("Nhập vào tên: ");
            name = sc.nextLine();
            System.out.println("Nhập vào địa chỉ: ");
            address = sc.nextLine();
            System.out.println("Nhập vào tuổi: ");
            age = Integer.parseInt(sc.nextLine());
//            System.out.println("Tên: " + name);
//            System.out.println("Địa chỉ: " + address);
//            System.out.println("Tuổi: " + age);
            student stu = new student(name, address, age);
            lst.add(stu);
            System.out.println("Có nhập tiếp không (y/n)?");
            next = sc.nextLine();
        }while (next.equalsIgnoreCase("y"));
        for(student i : lst){
            System.out.println("Tên: " + i.getName() + "    Địa chỉ: " + i.getAddress() + "    Tuổi: " + i.getAge());
        }
    }
}
