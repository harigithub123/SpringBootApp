package com.billing.service;

import org.springframework.stereotype.Service;

import com.billing.dto.UserDTO;
import com.billing.security.Token;


@Service
public interface UserService {
	Token getUserByUserName(String userName);
	UserDTO saveUser(UserDTO user);
	boolean isUserExist(UserDTO user);
	
}
