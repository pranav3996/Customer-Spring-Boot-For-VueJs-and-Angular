package com.Customer.Service;

import java.util.List;
import java.util.Optional;

import com.Customer.DTO.CustomerDTO;
import com.Customer.DTO.CustomerSaveDTO;
import com.Customer.DTO.CustomerUpdateDTO;
import com.Customer.Entity.Customer;


public interface CustomerService {
   Customer addCustomer(CustomerSaveDTO customerSaveDTO);

   List<CustomerDTO> getAllCustomer();
   
   public Optional<Customer> getCustomerById(int id);
   
 //  Customer updateCustomers(CustomerUpdateDTO customerUpdateDTO);
   public Customer updateCustomer(int customerId, CustomerUpdateDTO customerUpdateDTO);

   boolean deleteCustomer(int id);
}