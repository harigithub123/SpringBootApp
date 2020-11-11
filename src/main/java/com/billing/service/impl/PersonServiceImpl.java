package com.billing.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.billing.dao.PersonRepository;
import com.billing.dto.PersonRequestResponse;
import com.billing.model.Person;
import com.billing.service.PersonService;
import com.billing.service.util.ServiceRequestUtil;

@Service
public class PersonServiceImpl implements PersonService {
	
	private PersonRepository personRespository;
	
	public PersonServiceImpl(PersonRepository personRepository) {
		this.personRespository = personRepository;
	}

	@Override
	public void addPerson(PersonRequestResponse request) {
		this.personRespository.save(ServiceRequestUtil.getPerson(request));
	}

	@Override
	public void updatePerson(PersonRequestResponse request) {
		this.personRespository.save(ServiceRequestUtil.getPerson(request));
	}

	@Override
	public List<PersonRequestResponse> listPersons() {
		return getPersonResponse(this.personRespository.findAll());
	}

	@Override
	public PersonRequestResponse getPersonById(Long id) {
		Optional<Person> person = this.personRespository.findById(id);
		if(person != null) {
			return getPersonResponse(person.get());
		}
		return null;
	}

	@Override
	public void removePerson(Long id) {
		this.personRespository.deleteById(id);
		
	}
	
	public List<PersonRequestResponse> getPersonResponse(List<Person> list) {
		List<PersonRequestResponse> res = new ArrayList<PersonRequestResponse>();
		for(Person p : list) {
			res.add(getPersonResponse(p));
		}
		return res;
	}
	
	public PersonRequestResponse getPersonResponse(Person p) {
		PersonRequestResponse res = new PersonRequestResponse();
		res.setId(p.getId());
		res.setMobileNumber(p.getMobileNumber());
		res.setName(p.getName());
		return res;
	}

}
