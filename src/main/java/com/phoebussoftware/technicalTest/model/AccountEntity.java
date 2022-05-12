package com.phoebussoftware.technicalTest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.phoebussoftware.technicalTest.DTO.AccountDTO;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ACCOUNT")
public class AccountEntity  {
  @Id 
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long accountId;
  @Column(nullable = false)
  @NotNull
  Integer accountNumber;
  
  @ManyToOne
  private CustomerEntity customerAccount;
  
  
  public static AccountEntity from(AccountDTO accountDTO){
	  AccountEntity account = new AccountEntity();
	  account.setAccountNumber(accountDTO.getAccountNumber());
	  //account.setCustomerAccount(accountDTO.getCustomer());
      return account;
  }
  

}
