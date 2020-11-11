package com.billing.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.billing.dto.destinations.DomesticDestinationDTO;
import com.billing.dto.destinations.SearchDestinationDTO;
import com.billing.model.destinations.DomesticDestination;

@Service
public interface DomesticDestinationService {

	public DomesticDestinationDTO addDomesticDestination(DomesticDestinationDTO p);
	public DomesticDestinationDTO updateDomesticDestination(DomesticDestinationDTO p);
	public List<DomesticDestinationDTO> listDomesticDestinations(SearchDestinationDTO searchDTO);
	public DomesticDestinationDTO getDomesticDestinationById(Long id);
	public void removeDomesticDestination(Long id);
}
