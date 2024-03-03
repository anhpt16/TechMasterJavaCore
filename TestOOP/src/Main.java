import entities.User;
import views.MenuStart;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Khởi tạo một một danh sách lưu trữ các user để sử dụng trong toàn bộ chương trình
        ArrayList<User> users = new ArrayList<>();

        MenuStart menuStart = new MenuStart();
        //Chạy menu bắt đầu
        menuStart.menuStart(sc, null);
    }
}
