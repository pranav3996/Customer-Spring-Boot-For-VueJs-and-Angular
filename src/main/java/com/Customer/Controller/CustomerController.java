package com.Customer.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Customer.DTO.CustomerDTO;
import com.Customer.DTO.CustomerSaveDTO;
import com.Customer.DTO.CustomerUpdateDTO;
import com.Customer.Entity.Customer;
import com.Customer.Service.CustomerService;

@RestController
@CrossOrigin
@RequestMapping("api/v1/customer")

public class CustomerController
{
    @Autowired
    private CustomerService customerService;
 
    @PostMapping(path = "/save")
 
    public Customer saveCustomer(@RequestBody CustomerSaveDTO customerSaveDTO)
    {
    	System.err.println("Inside save");
        Customer customer = customerService.addCustomer(customerSaveDTO);
//        System.err.println("Saved with id : "+id);
        return customer;
    }
 
    @GetMapping(path = "/getAllCustomer")
    public List<CustomerDTO> getAllCustomer()
    {
       List<CustomerDTO>allCustomers = customerService.getAllCustomer();
       return allCustomers;
    }
    @GetMapping("/getCustomer/{id}")
    public Optional<Customer> getCustomerById(@PathVariable int id) {
        return customerService.getCustomerById(id);
                
    }

    @PutMapping("/{customerId}")
    public Customer updateCustomer(
            @PathVariable int customerId,
            @RequestBody CustomerUpdateDTO customerUpdateDTO) {

        Customer updatedCustomer = customerService.updateCustomer(customerId, customerUpdateDTO);

        if (updatedCustomer != null) {
            return updatedCustomer;
        }
		return null;
    }
    
    @DeleteMapping(path = "/deletecustomer/{id}")
    public String deleteCustomer(@PathVariable(value = "id") int id)
    {
        boolean deletecustomer = customerService.deleteCustomer(id);
        return "deleted";
    }
 
}