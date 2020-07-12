package com.kshitij.cms.services;

import com.kshitij.cms.model.Customer;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class CustomerService {
    private int customerIDCount = 1;
    private List<Customer> customerList = new CopyOnWriteArrayList<>();

    public Customer addCustomer(Customer customer) {
        customer.setCustomerID(customerIDCount);
        customerList.add(customer);
        customerIDCount++;
        return customer;
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public Customer getCustomer(int id) {
        return customerList.stream().
                filter(customer -> customer.getCustomerID() == id)
                .findFirst()
                .get();
    }

    public Customer updateCustomer(int customerID, Customer customer) {
        customerList.stream()
                .forEach(c -> {
                    if (c.getCustomerID() == customerID) {
                        c.setCustomerFirstName(customer.getCustomerFirstName());
                        c.setCustomerLastName(customer.getCustomerLastName());
                        c.setCustomerEmail(customer.getCustomerEmail());
                    }
                });
        return customerList.stream()
                .filter(c-> c.getCustomerID() == customerID)
                .findFirst()
                .get();
    }

    public void deleteCustomer(int customerID){
        customerList.stream()
                .forEach(c->{
                    if(c.getCustomerID()==customerID){
                        customerList.remove(c);
                    }
                });
    }

}
