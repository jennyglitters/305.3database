package com.jen.dao;

import com.jen.models.customer;

import java.util.List;

public interface CustomerDAO {
    customer getCustomerById(int id);
    boolean addCustomer(customer c);
    boolean removeCustomerById(int id);
    List<customer> getAllCustomers();
    void saveCustomer(List<customer> CustomerList);
    boolean updateCustomer(customer c);

}


