package com.billing.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.billing.model.DailyCollection;
import com.billing.request.DailyCollectionRequest;
import com.billing.response.DailyCollectionResonse;

@Service
public interface DailyCollectionService {
	public void addDailyCollection(DailyCollectionRequest p);
	public void updateDailyCollection(DailyCollectionRequest p);
	public List<DailyCollectionResonse> listCollections();
	public DailyCollectionResonse getCollectionById(Long id);
	public void removeCollection(Long id);
}
