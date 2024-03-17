import entities.Bank;
import entities.BookSaving;
import entities.Customer;
import views.Menu;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();

        ArrayList<Customer> customers = new ArrayList<>();
        ArrayList<Bank> banks = new ArrayList<>();
        ArrayList<BookSaving> bookSavings = new ArrayList<>();

        menu.startMenu(customers, banks, bookSavings);
    }
}
