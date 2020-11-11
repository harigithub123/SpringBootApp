package com.billing.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.billing.model.User;
import com.billing.model.UserRoleAuthority;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	com.billing.model.User getUserByUserName(String userName);
	Boolean existsByUserName(String userName);
	Boolean existsByEmailId(String emailId);
	@Query("Select userRoleAuthority from User user,UserRoleAuthority userRoleAuthority where user.id=userRoleAuthority.user.id and user.userName=?1 ")
	public UserRoleAuthority getUserRoleAuthorityByUserName(String userName);
}
