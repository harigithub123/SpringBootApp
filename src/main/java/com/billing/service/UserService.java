package com.billing.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.billing.model.User;
import com.billing.request.UserRequest;


@Service
public interface UserService {
	public void addUser(UserRequest p);
	public void updateUser(UserRequest p);
	public List<User> listUsers();
	public User getUserById(int id);
	public User getUserByMobileNumber(int id);
	public void removeUser(int id);
	
}
