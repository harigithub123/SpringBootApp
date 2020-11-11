package com.billing.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.billing.model.ERole;
import com.billing.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{
}
