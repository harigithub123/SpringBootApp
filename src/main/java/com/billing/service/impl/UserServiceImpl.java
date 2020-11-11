package com.billing.service.impl;


import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import com.billing.dao.UserRepository;
import com.billing.dto.UserDTO;
import com.billing.dto.UserRoleAuthorityDTO;
import com.billing.model.User;
import com.billing.model.UserRoleAuthority;
import com.billing.security.Token;
import com.billing.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepository;

	@Override
	public UserDTO saveUser(UserDTO user) {
		// TODO Auto-generated method stub
		
		User userObj=new User();
		userObj.setUserName(user.getUserName());
		//userObj.setIsActiveFlag(user.getIsActiveFlag());
		userObj.setPassword(user.getPassword());
		//userObj.setRole(user.getRole());
		userRepository.saveAndFlush(userObj);
		//user.setUserId(userObj.getUserId());
		return user;
	}

	@Override
	public Token getUserByUserName(String userName) {
		
		UserRoleAuthority userRoleObj = userRepository.getUserRoleAuthorityByUserName(userName);
		Token tokenObj = new Token();
		UserRoleAuthorityDTO userRoleAuthoriDTO = new UserRoleAuthorityDTO();
		Set<UserRoleAuthorityDTO> userRoleSetAuth = new HashSet<>();
		if (userRoleObj != null) {
			tokenObj.setUserId(Integer.parseInt(userRoleObj.getUser().getId()+""));
			tokenObj.setUsername(userRoleObj.getUser().getUserName());
			/*tokenObj.setAccountExpired(false);
			tokenObj.setAccountLocked(false);
			tokenObj.setCredentialsExpired(false);
			tokenObj.setAccountDisabled(false);*/
			tokenObj.setUserRoleAuthorityId(userRoleObj.getUserRoleAuthorityId());
			tokenObj.setRoleId(userRoleObj.getRole().getRoleId());
			tokenObj.setRole(userRoleObj.getRole().getRole());
			
			for (GrantedAuthority auth : userRoleObj.getUser().getAuthorities()) {
				userRoleAuthoriDTO.setAuthority(auth.getAuthority());
				userRoleSetAuth.add(userRoleAuthoriDTO);
			}
			tokenObj.setAuthorities(userRoleSetAuth);
			return tokenObj;
		}
		return null;
	
	}

	@Override
	public boolean isUserExist(UserDTO user) {
		// TODO Auto-generated method stub
		return false;
	}
}
