package com.phoebussoftware.technicalTest.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.phoebussoftware.technicalTest.model.CustomerEntity;

@Repository
public interface CustomerRepository extends CrudRepository<CustomerEntity,Long>{

}
