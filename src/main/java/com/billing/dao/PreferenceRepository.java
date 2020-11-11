package com.billing.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.billing.model.masterdata.Preference;
import com.billing.model.masterdata.PreferenceId;

@Repository
public interface PreferenceRepository  extends JpaRepository<Preference, PreferenceId> {
		List<Preference> findByColumnSize(double size);
	}