package com.billing.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.billing.model.Item;

@Repository
public interface ItemRepository  extends JpaRepository<Item, Long> {
}
