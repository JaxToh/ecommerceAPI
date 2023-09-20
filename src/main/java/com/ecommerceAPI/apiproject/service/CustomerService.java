package com.ecommerceAPI.apiproject.service;

import java.util.List;
import com.ecommerceAPI.apiproject.entity.Customer;
// import sg.edu.ntu.simplecrm.entity.Interaction;

public interface CustomerService {
  Customer createCustomer(Customer customer);

  Customer getCustomer(Long id);

  List<Customer> getAllCustomers();

  Customer updateCustomer(Long id, Customer customer);

  void deleteCustomer(Long id);

  List<Customer> searchCustomers(String firstName);

}
