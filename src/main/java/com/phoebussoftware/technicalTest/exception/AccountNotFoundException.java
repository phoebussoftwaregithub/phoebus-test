package com.phoebussoftware.technicalTest.exception;

import java.text.MessageFormat;

public class AccountNotFoundException extends RuntimeException {
	
	public AccountNotFoundException(final Long id) {
		super(MessageFormat.format("Could not find customer with id: {0}", id));
	}

}
