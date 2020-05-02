package com.billing.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.billing.model.Customer;
import com.billing.model.Person;

@Repository
public interface PersonRepository  extends JpaRepository<Person, Long> {

	}

