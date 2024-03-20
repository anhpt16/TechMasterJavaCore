import entities.Bill;
import entities.Customer;
import entities.Ministration;
import views.Menu;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Customer> customers = new ArrayList<>();
        ArrayList<Ministration> ministrations = new ArrayList<>();
        ArrayList<Bill> bills = new ArrayList<>();

        Menu menu = new Menu();

        menu.startMenu(customers, ministrations, bills);
    }
}
