package com.billing.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.billing.dto.masterdata.PreferenceDTO;
import com.billing.model.masterdata.Preference;
import com.billing.model.masterdata.PreferenceId;

@Service
public interface PreferenceService {

	public PreferenceDTO addPreference(PreferenceDTO p);
	public PreferenceDTO updatePreference(PreferenceDTO p);
	public List<PreferenceDTO> listPreferences();
	public PreferenceDTO getPreferenceById(PreferenceId id);
	public void removePreference(PreferenceId id);
}
