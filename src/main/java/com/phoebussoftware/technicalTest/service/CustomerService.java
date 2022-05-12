package com.phoebussoftware.technicalTest.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phoebussoftware.technicalTest.model.CustomerEntity;
import com.phoebussoftware.technicalTest.exception.CustomerNotFoundException;
import com.phoebussoftware.technicalTest.repository.CustomerRepository;

@Service
public class CustomerService  {
	
	
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository cartRepository) {
        this.customerRepository = cartRepository;
    }

    public CustomerEntity createCustomer(CustomerEntity customer){
        return customerRepository.save(customer);
    }
    
    public CustomerEntity getCustomer(Long id){
        return customerRepository.findById(id).orElseThrow(() ->
                new CustomerNotFoundException(id));
    }

    

	

	

}
