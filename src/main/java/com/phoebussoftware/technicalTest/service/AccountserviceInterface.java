package com.phoebussoftware.technicalTest.service;

import com.phoebussoftware.technicalTest.model.AccountEntity;

public interface AccountserviceInterface {
	public AccountEntity createAccount(AccountEntity account);
	public AccountEntity getAccount(Long id);

}
