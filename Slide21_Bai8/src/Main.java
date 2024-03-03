import entities.Center;
import services.CenterService;
import views.Menu;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CenterService centerService = new CenterService();
        //Nhập thông tin cho trung tâm
        Center center = centerService.inputInfo(sc);
        //Hiển thị menu
        Menu menu = new Menu();
        menu.Menu(sc, center);
    }
}
