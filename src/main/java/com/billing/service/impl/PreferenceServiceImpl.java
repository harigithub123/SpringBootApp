package com.billing.service.impl;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.billing.dao.PreferenceRepository;
import com.billing.dto.masterdata.PreferenceDTO;
import com.billing.model.masterdata.Preference;
import com.billing.model.masterdata.PreferenceId;
import com.billing.service.PreferenceService;

@Service
public class PreferenceServiceImpl implements PreferenceService {
	
	private PreferenceRepository preferenceRespository;
	@Autowired ModelMapper mapper;
	
	public PreferenceServiceImpl(PreferenceRepository preferenceRepository) {
		this.preferenceRespository = preferenceRepository;
	}

	@Override
	public PreferenceDTO addPreference(PreferenceDTO request) {
		Preference pref = this.preferenceRespository.save(mapper.map(request, Preference.class));
		return mapper.map(pref, PreferenceDTO.class);
	}

	@Override
	public PreferenceDTO updatePreference(PreferenceDTO request) {
		Preference pref = this.preferenceRespository.save(mapper.map(request, Preference.class));
		return mapper.map(pref, PreferenceDTO.class);
	}

	@Override
	public List<PreferenceDTO> listPreferences() {
		List<Preference> list = this.preferenceRespository.findAll();
		return list.stream()
				  .map(object -> mapper.map(object, PreferenceDTO.class))
				  .collect(Collectors.toList());
	}

	@Override
	public PreferenceDTO getPreferenceById(PreferenceId id) {
		Optional<Preference> preference = this.preferenceRespository.findById(id);
		if(preference != null) {
			mapper.map(preference.get(), PreferenceDTO.class);
		}
		return null;
	}

	@Override
	public void removePreference(PreferenceId id) {
		this.preferenceRespository.deleteById(id);
		
	}

}
