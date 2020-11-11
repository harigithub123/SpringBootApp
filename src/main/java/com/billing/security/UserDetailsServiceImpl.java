package com.billing.security;

import static java.util.Collections.emptyList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.billing.dao.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private UserRepository userRestRepository;

	public UserDetailsServiceImpl(UserRepository userRestRepository) {
		this.userRestRepository = userRestRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		com.billing.model.User user = userRestRepository.getUserByUserName(userName);
		if (user == null) {
			throw new UsernameNotFoundException(userName);
		}	
		return new User(user.getUserName(), user.getPassword(), emptyList());
	}
}
