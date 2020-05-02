
package com.billing.service.impl;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.billing.dao.DailyCollectionRepository;
import com.billing.model.DailyCollection;
import com.billing.request.DailyCollectionRequest;
import com.billing.response.DailyCollectionResonse;
import com.billing.service.DailyCollectionService;
import com.billing.service.util.ServiceRequestUtil;

@Service
public class DailyCollectionServiceImpl implements DailyCollectionService {
	
	private DailyCollectionRepository dailyCollectionRespository;
	
	public DailyCollectionServiceImpl(DailyCollectionRepository personRepository) {
		this.dailyCollectionRespository = personRepository;
	}

	@Transactional
	public void addDailyCollection(DailyCollectionRequest request) {
		this.dailyCollectionRespository.save(ServiceRequestUtil.getDailyCollection(request));
	}

	@Transactional
	public void updateDailyCollection(DailyCollectionRequest request) {
		this.dailyCollectionRespository.save(ServiceRequestUtil.getDailyCollection(request));
	}

	@Transactional
	public List<DailyCollectionResonse> listCollections() {
		List<DailyCollection> persons = this.dailyCollectionRespository.findAll();
		return getPersonResponse(persons);
	}

	@Transactional
	public DailyCollectionResonse getCollectionById(Long id) {
		Optional<DailyCollection> person = this.dailyCollectionRespository.findById(id);
		if(person != null) {
			return getPersonResponse(person.get());
		}
		return null;
	}

	@Transactional
	public void removeCollection(Long id) {
		this.dailyCollectionRespository.deleteById(id);
	}
	
	public List<DailyCollectionResonse> getPersonResponse(List<DailyCollection> persons) {
		List<DailyCollectionResonse> list = new ArrayList<DailyCollectionResonse>();
		for(DailyCollection p : persons) {
			list.add(getPersonResponse(p));
		}
		return list;
	}
	
	public DailyCollectionResonse getPersonResponse(DailyCollection p) {
		DailyCollectionResonse res = new DailyCollectionResonse();
		res.setId(p.getId());
		res.setCash(p.getCash());
		res.setCredit(p.getCredit());
		res.setOnline(p.getOnline());
		res.setTransactionDate(p.getTransactionDate());
		return res;
	}
	
}
