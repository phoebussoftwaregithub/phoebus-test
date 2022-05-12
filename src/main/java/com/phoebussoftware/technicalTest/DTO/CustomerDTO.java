package com.phoebussoftware.technicalTest.DTO;



import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.phoebussoftware.technicalTest.model.CustomerEntity;
import java.util.stream.Collectors;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerDTO {
	 Long customerId;
	 String foreName;
	 String surName;
	 Date dateOfBirth;
	 Set<AccountDTO> accountDTOS = new HashSet<AccountDTO>();
	 public static CustomerDTO from(CustomerEntity customer){
		 CustomerDTO customerDTO = new CustomerDTO();
	        customerDTO.setCustomerId(customer.getCustomerId());
	        customerDTO.setForeName(customer.getForeName());
	        customerDTO.setSurName(customer.getSurName());
	        customerDTO.setDateOfBirth(customer.getDateOfBirth());
	        customerDTO.setAccountDTOS(customer.getAccountEntities().stream().map(AccountDTO::from).collect(Collectors.toSet()));
	        return customerDTO;
	    }
}
