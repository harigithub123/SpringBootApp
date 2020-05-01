package com.billing.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.billing.model.DailyCollection;
import com.billing.request.DailyCollectionRequest;
import com.billing.response.DailyCollectionResonse;

@Service
public interface DailyCollectionService {
	public void addPerson(DailyCollectionRequest p);
	public void updatePerson(DailyCollectionRequest p);
	public List<DailyCollectionResonse> listPersons();
	public DailyCollectionResonse getPersonById(Long id);
	public void removePerson(Long id);
}
