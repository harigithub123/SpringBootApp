package com.billing.service.impl;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.billing.dao.InternationalDestinationRepository;
import com.billing.dto.destinations.InternationalDestinationDTO;
import com.billing.model.destinations.InternationalDestination;
import com.billing.service.InternationalDestinationService;

@Service
public class InternationalDestinationServiceImpl implements InternationalDestinationService {
	
	private InternationalDestinationRepository internationalDestinationRespository;
	@Autowired ModelMapper mapper;
	
	public InternationalDestinationServiceImpl(InternationalDestinationRepository InternationalDestinationRepository) {
		this.internationalDestinationRespository = InternationalDestinationRepository;
    }

	@Transactional
	public InternationalDestinationDTO addInternationalDestination(InternationalDestinationDTO request) {
		InternationalDestination saved = this.internationalDestinationRespository.save(mapper.map(request, InternationalDestination.class));
		return mapper.map(saved, InternationalDestinationDTO.class);
	}

	@Transactional
	public InternationalDestinationDTO updateInternationalDestination(InternationalDestinationDTO request) {
		InternationalDestination updated = this.internationalDestinationRespository.save(mapper.map(request, InternationalDestination.class));
		return mapper.map(updated, InternationalDestinationDTO.class);
	}

	@Transactional
	public List<InternationalDestinationDTO> listInternationalDestinations() {
		List<InternationalDestination> list =  this.internationalDestinationRespository.findAll();
		return list.stream()
				  .map(object -> mapper.map(object, InternationalDestinationDTO.class))
				  .collect(Collectors.toList());
	}

	@Transactional
	public InternationalDestinationDTO getInternationalDestinationById(Long id) {
		Optional<InternationalDestination> InternationalDestination = this.internationalDestinationRespository.findById(id);
		if(InternationalDestination != null) {
			return mapper.map(InternationalDestination.get(), InternationalDestinationDTO.class);
		}
		return null;
	}
	
	@Transactional
	public void removeInternationalDestination(Long id) {
		this.internationalDestinationRespository.deleteById(id);
	}
}
