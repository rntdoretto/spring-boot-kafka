package com.renatodoretto.examples.kafka.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.renatodoretto.examples.kafka.core.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	@Transactional(readOnly = true)
	User findByName(String name);
	
	@Transactional(readOnly = true)
	User findByDept(String dept);

}
