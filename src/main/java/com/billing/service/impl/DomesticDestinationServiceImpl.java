package com.billing.service.impl;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.billing.dao.DomesticDestinationRepository;
import com.billing.dto.destinations.DomesticDestinationDTO;
import com.billing.dto.destinations.SearchDestinationDTO;
import com.billing.model.destinations.DomesticDestination;
import com.billing.service.DomesticDestinationService;

@Service
public class DomesticDestinationServiceImpl implements DomesticDestinationService {
	
	private DomesticDestinationRepository DomesticDestinationRespository;
	
	@Autowired ModelMapper mapper;
	
	public DomesticDestinationServiceImpl(DomesticDestinationRepository DomesticDestinationRepository) {
		this.DomesticDestinationRespository = DomesticDestinationRepository;
    }

	@Transactional
	public DomesticDestinationDTO addDomesticDestination(DomesticDestinationDTO request) {
		DomesticDestination saved = this.DomesticDestinationRespository.save(mapper.map(request, DomesticDestination.class));
		return mapper.map(saved, DomesticDestinationDTO.class);
	}

	@Transactional
	public DomesticDestinationDTO updateDomesticDestination(DomesticDestinationDTO request) {
		DomesticDestination saved =  this.DomesticDestinationRespository.save(mapper.map(request, DomesticDestination.class));
		return mapper.map(saved, DomesticDestinationDTO.class);
	}

	@Transactional
	public List<DomesticDestinationDTO> listDomesticDestinations(SearchDestinationDTO searchDTO) {
		List<DomesticDestination> list = this.DomesticDestinationRespository.findByPinCodeOrDestinationOrZone(searchDTO.getPinCode(), searchDTO.getDestination(), searchDTO.getZone());
		return list.stream()
				  .map(object -> mapper.map(object, DomesticDestinationDTO.class))
				  .collect(Collectors.toList());
	}

	@Transactional
	public DomesticDestinationDTO getDomesticDestinationById(Long id) {
		Optional<DomesticDestination> DomesticDestination = this.DomesticDestinationRespository.findById(id);
		if(DomesticDestination != null) {
			return mapper.map(DomesticDestination.get(), DomesticDestinationDTO.class);
		}
		return null;
	}
	
	@Transactional
	public void removeDomesticDestination(Long id) {
		this.DomesticDestinationRespository.deleteById(id);
	}
}
