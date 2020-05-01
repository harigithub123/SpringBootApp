package com.billing.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.billing.model.Login;
import com.billing.model.OrderInfoDetails;

@Repository
public interface LoginRepository extends JpaRepository<Login, Long>, LoginRepositoryCustom {
	public Optional<Login> findByMobileNumber(String mobileNumber);
}
