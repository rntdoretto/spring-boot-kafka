package com.renatodoretto.examples.kafka.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.renatodoretto.examples.kafka.core.model.User;
import com.renatodoretto.examples.kafka.core.repository.UserRepository;
import com.renatodoretto.examples.kafka.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public void consume(String message) {
		log.info(message);
	}

	@Override
	public boolean saveUser(User user) {
		log.info(user.toString());
		userRepository.save(user);
		userRepository.findAll().forEach(x -> log.info(x.toString()));
		return true;
	}

}
