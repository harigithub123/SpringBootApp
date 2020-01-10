package com.billing.service.impl;


import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.billing.dao.UserRepository;
import com.billing.model.User;
import com.billing.request.UserRequest;

@Service
public class UserServiceImpl {
	
	private UserRepository userRespository;
	
	   public UserServiceImpl(UserRepository userRepository) {
	        this.userRespository = userRepository;
	    }

	@Transactional
	public void addUser(UserRequest request) {
		this.userRespository.save(getUser(request));
	}

	@Transactional
	public void updateUser(UserRequest request) {
		this.userRespository.save(getUser(request));
	}

	@Transactional
	public List<User> listUsers() {
		return this.userRespository.findAll();
	}

	@Transactional
	public Optional<User> getUserById(Long id) {
		return this.userRespository.findById(id);
	}
	
	@Transactional
	public Optional<User> getUserByPhoneNumber(String mobileNumber) {
		return this.userRespository.findByPhoneNumber(mobileNumber);
	}

	@Transactional
	public void removeUser(Long id) {
		this.userRespository.deleteById(id);
	}
	
	public User getUser(UserRequest request) {
		User user = new User();
		user.setDob(request.getDob());
		user.setEmailId(request.getEmailId());
		user.setName(request.getName());
		user.setPhoneNumber(request.getMobileNumber());
		user.setUserId(request.getUserId());
		user.setUserType(request.getUserType());
		return user;
	}

}
