package com.billing.service.impl;


import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.billing.dao.UserRepository;
import com.billing.model.DailyCollection;
import com.billing.model.User;
import com.billing.request.UserRequest;
import com.billing.service.UserService;
import com.billing.service.util.ServiceRequestUtil;

@Service
public class UserServiceImpl implements UserService {
	
	private UserRepository userRespository;
	private ServiceRequestUtil util = new ServiceRequestUtil();
	
	public UserServiceImpl(UserRepository userRepository) {
		this.userRespository = userRepository;
    }

	@Transactional
	public void addUser(UserRequest request) {
		this.userRespository.save(util.getUser(request));
	}

	@Transactional
	public void updateUser(UserRequest request) {
		this.userRespository.save(util.getUser(request));
	}

	@Transactional
	public List<User> listUsers() {
		return this.userRespository.findAll();
	}

	@Transactional
	public User getUserById(Long id) {
		Optional<User> user = this.userRespository.findById(id);
		if(user != null) {
			return user.get();
		}
		return null;
	}
	
	@Transactional
	public void removeUser(Long id) {
		this.userRespository.deleteById(id);
	}

	@Override
	public User getUserByMobileNumber(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findByUserId(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findByUserName(String userName) {
		return null;
	}
}
