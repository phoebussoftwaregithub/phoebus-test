package com.phoebussoftware.technicalTest.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phoebussoftware.technicalTest.model.AccountEntity;
import com.phoebussoftware.technicalTest.exception.AccountNotFoundException;
import com.phoebussoftware.technicalTest.repository.AccountRepository;

@Service
public class AccountService implements AccountserviceInterface {

   private final AccountRepository accountRepository;


    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public AccountEntity createAccount(AccountEntity account){
        return accountRepository.save(account);
    }
    public AccountEntity getAccount(Long id){
        return accountRepository.findById(id).orElseThrow(() ->
                new AccountNotFoundException(id));
    }

    
}
