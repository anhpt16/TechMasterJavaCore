package iservices;

import entities.Customer;

public interface ICustomerService {
    Customer inputInfo();
    void addCustomer();
    Customer findCustomerById(String id);

}
