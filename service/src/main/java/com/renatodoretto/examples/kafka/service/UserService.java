package com.renatodoretto.examples.kafka.service;

import com.renatodoretto.examples.kafka.core.model.User;

public interface UserService {

	void consume(String message);
	
	boolean saveUser(User user);
}
