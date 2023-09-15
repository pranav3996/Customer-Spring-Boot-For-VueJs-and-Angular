package com.Customer.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Customer.DTO.CustomerSaveDTO;
import com.Customer.DTO.CustomerUpdateDTO;
import com.Customer.Entity.Customer;
import com.Customer.Repo.CustomerRepo;
import com.Customer.DTO.CustomerDTO;

@Service
public class CustomerServiceIMPL implements CustomerService
{
    @Autowired
    private CustomerRepo customerRepo;
 
    @Override
    public Customer addCustomer(CustomerSaveDTO customerSaveDTO)
    {
    	System.err.println("Inside sercice"+customerSaveDTO);
        Customer customer = new Customer(
 
                customerSaveDTO.getCustomername(),
                customerSaveDTO.getCustomeraddress(),
                customerSaveDTO.getMobile()
        );
        customerRepo.save(customer);
//        return customer.getCustomername();
        System.err.println(customer);
        return customer;
    }
 
    @Override
    public List<CustomerDTO> getAllCustomer() {
       List<Customer> getCustomers = customerRepo.findAll();
       List<CustomerDTO> customerDTOList = new ArrayList<>();
       for(Customer a:getCustomers)
       {
           CustomerDTO customerDTO = new CustomerDTO(
 
                   a.getCustomerid(),
                   a.getCustomername(),
                   a.getCustomeraddress(),
                   a.getMobile()
           );
           customerDTOList.add(customerDTO);
       }
 
       return  customerDTOList;
    }
    
    @Override
	public Optional<Customer> getCustomerById(int id) {
		// TODO Auto-generated method stub
		return customerRepo.findById(id);
	}
 

    public Customer updateCustomer(int customerId, CustomerUpdateDTO customerUpdateDTO) {
        // Check if the customer exists
        if (customerRepo.existsById(customerId)) {
            Customer customer = customerRepo.getById(customerId);

            // Update customer information
            customer.setCustomername(customerUpdateDTO.getCustomername());
            customer.setCustomeraddress(customerUpdateDTO.getCustomeraddress());
            customer.setMobile(customerUpdateDTO.getMobile());

            // Save the updated customer
            return customerRepo.save(customer);
        } else {
            // Customer does not exist
            return null;
        }
    }

    @Override
    public boolean deleteCustomer(int id) {
 
        if(customerRepo.existsById(id))
        {
            customerRepo.deleteById(id);
        }
        else
        {
            System.out.println("customer id not found");
        }
 
        return true;
    }

	
}