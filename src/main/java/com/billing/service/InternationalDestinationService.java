package com.billing.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.billing.dto.destinations.InternationalDestinationDTO;
import com.billing.model.destinations.InternationalDestination;

@Service
public interface InternationalDestinationService {

	public InternationalDestinationDTO addInternationalDestination(InternationalDestinationDTO p);
	public InternationalDestinationDTO updateInternationalDestination(InternationalDestinationDTO p);
	public List<InternationalDestinationDTO> listInternationalDestinations();
	public InternationalDestinationDTO getInternationalDestinationById(Long id);
	public void removeInternationalDestination(Long id);
}
