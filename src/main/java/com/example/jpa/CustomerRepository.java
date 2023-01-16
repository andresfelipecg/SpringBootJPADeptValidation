package com.example.jpa;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer>
{
	
}