package com.phoebussoftware.technicalTest.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.phoebussoftware.technicalTest.DTO.CustomerDTO;
import com.phoebussoftware.technicalTest.model.CustomerEntity;
import com.phoebussoftware.technicalTest.service.CustomerService;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	
	@Autowired
	private CustomerService cutomerservice;


  @GetMapping("/{customerId}")
  public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable Long customerId) {
	  CustomerEntity customer = cutomerservice.getCustomer(customerId);
	  return new ResponseEntity<>(CustomerDTO.from(customer), HttpStatus.OK);
  }


	 @PostMapping("/createCustomer")
	 public ResponseEntity<CustomerDTO> createCustomer(@RequestBody CustomerDTO customerDTO){
	     CustomerEntity customer = cutomerservice.createCustomer(CustomerEntity.from(customerDTO));
	     return new ResponseEntity<>(CustomerDTO.from(customer), HttpStatus.OK);
	 }


}
