package com.phoebussoftware.technicalTest.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.phoebussoftware.technicalTest.model.AccountEntity;

@Repository
public interface AccountRepository extends CrudRepository<AccountEntity,Long> {
	

}
