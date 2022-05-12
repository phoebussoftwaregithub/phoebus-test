package com.phoebussoftware.technicalTest.model;

import java.util.Date;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.phoebussoftware.technicalTest.DTO.CustomerDTO;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "CUSTOMER")
public class CustomerEntity  {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "CustomerId")
  Long customerId;
  @Column(nullable = false)
  String foreName;
  @Column(nullable = false)
  String surName;
  @Column(nullable = false)
  Date dateOfBirth;
  
  @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
  @JoinColumn(name = "customerId")
  private Set<AccountEntity> accountEntities ;
  
  public static CustomerEntity from(CustomerDTO customerDTO){
	  CustomerEntity customer = new CustomerEntity();
      customer.setForeName(customerDTO.getForeName());
      customer.setSurName(customerDTO.getSurName());
      customer.setDateOfBirth(customerDTO.getDateOfBirth());
      customer.setAccountEntities(customerDTO.getAccountDTOS().stream().map(AccountEntity::from).collect(Collectors.toSet()));
      return customer;
  }
  
  @Override
  public String toString() {
      return "Customer [CustomeId = " +customerId+", forName:"+foreName+", surName:"+surName+", dateOfBiirth :"+dateOfBirth+" ]";
  }
  
}
