package com.renatodoretto.examples.kafka.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.renatodoretto.examples.kafka.core.dto.UserDTO;

@RestController
@RequestMapping("kafka")
public class UserController {
	
	@Autowired
	KafkaTemplate<String, UserDTO> kafkaTemplate;
	private static final String TOPIC = "Kafka_Example_JSON";
	
	@GetMapping(path = "/publish/{name}")
	public String post(@PathVariable("name") final String name) {
		
		kafkaTemplate.send(TOPIC, new UserDTO(name, "Technology"));
		
		return "Published successfully";
	}

}
