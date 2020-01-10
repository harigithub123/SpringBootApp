package com.billing.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.billing.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findByPhoneNumber(String phoneNumber);
}
