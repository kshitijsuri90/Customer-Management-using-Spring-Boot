package com.kshitij.cms.services;

import com.kshitij.cms.dao.CustomerDAO;
import com.kshitij.cms.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerService {
    @Autowired
    private CustomerDAO customerDAO;

    public Customer addCustomer(Customer customer) {
        return customerDAO.save(customer);
    }

    public List<Customer> getCustomerList() {
        return customerDAO.findAll();
    }

    public Customer getCustomer(int id) {
        return customerDAO.findById(id).get();
    }

    public Customer updateCustomer(int customerID, Customer customer) {
        customer.setCustomerID(customerID);
        return customerDAO.save(customer);
    }

    public void deleteCustomer(int customerID) {
        customerDAO.deleteById(customerID);
    }

}
