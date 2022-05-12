package com.phoebussoftware.technicalTest.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.phoebussoftware.technicalTest.DTO.AccountDTO;
import com.phoebussoftware.technicalTest.model.AccountEntity;
import com.phoebussoftware.technicalTest.service.AccountService;

@RestController
@RequestMapping("/account")
public class AccountController {

  @Autowired
  AccountService accountService;
  
  @GetMapping("/{accountId}")
  public ResponseEntity<AccountDTO> getAccountById(@PathVariable Long accountId) {
	  AccountEntity account = accountService.getAccount(accountId);
	  return new ResponseEntity<>(AccountDTO.from(account), HttpStatus.OK);
  }
  
  
  @PostMapping
  public ResponseEntity<AccountDTO> addItem(@RequestBody final AccountDTO accountDTO){
      AccountEntity account = accountService.createAccount(AccountEntity.from(accountDTO));
      return new ResponseEntity<>(AccountDTO.from(account), HttpStatus.OK);
  }
  
}


