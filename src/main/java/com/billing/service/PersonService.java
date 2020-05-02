package com.billing.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.billing.model.Person;
import com.billing.request.PersonRequestResponse;

@Service
public interface PersonService {

	public void addPerson(PersonRequestResponse p);
	public void updatePerson(PersonRequestResponse p);
	public List<PersonRequestResponse> listPersons();
	public PersonRequestResponse getPersonById(Long id);
	public void removePerson(Long id);
}
