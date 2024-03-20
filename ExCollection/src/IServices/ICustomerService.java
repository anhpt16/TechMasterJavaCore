package IServices;

import entities.Customer;

import java.util.ArrayList;

public interface ICustomerService {
    Customer inputInfo();
    void displayList(ArrayList<Customer> customers);
    void addCustomer(ArrayList<Customer> customers);
    Customer findCustomerById(ArrayList<Customer> customers, int id);
}
