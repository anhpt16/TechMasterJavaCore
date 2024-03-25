package services;

import entities.Customer;
import iservices.ICustomerService;

import java.util.ArrayList;

public class CustomerService implements ICustomerService {
    private static CustomerService instance;
    private CustomerService(){};
    public static CustomerService getInstance(){
        if (instance == null)
            instance = new CustomerService();
        return instance;
    }

    private final ArrayList<Customer> customers = new ArrayList<>();


    @Override
    public Customer inputInfo() {

        return null;
    }

    @Override
    public void addCustomer() {

    }

    @Override
    public Customer findCustomerById(String id) {
        return null;
    }
}
