package IServices;

import entities.Bill;
import entities.Customer;
import entities.Ministration;

import java.util.ArrayList;

public interface IBillService {
    Bill inputInfo(ArrayList<Customer> customers, ArrayList<Ministration> ministrations, ArrayList<Bill> bills);

}
