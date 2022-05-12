package com.phoebussoftware.technicalTest.DTO;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.phoebussoftware.technicalTest.model.AccountEntity;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountDTO {
  Long accountId;
  Integer accountNumber;
  //CustomerEntity customer;
  public static AccountDTO from(AccountEntity account){
	  AccountDTO accountDTO = new AccountDTO();
      accountDTO.setAccountId(account.getAccountId());
      accountDTO.setAccountNumber(account.getAccountNumber());
     // accountDTO.setCustomer(account.getCustomerAccount());
      return accountDTO;
  }
}


