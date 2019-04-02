package com.renatodoretto.examples.kafka.app.listener;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.PartitionOffset;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import com.renatodoretto.examples.kafka.core.dto.UserDTO;
import com.renatodoretto.examples.kafka.core.model.User;
import com.renatodoretto.examples.kafka.service.UserService;

@Service
public class KafkaConsumer {

	@Autowired
	private UserService userService;

	@KafkaListener(groupId = "group_id", containerFactory = "kafkaListenerContainerFactory", topicPartitions = @TopicPartition(topic = "Kafka_Example", partitionOffsets = {
			@PartitionOffset(partition = "0", initialOffset = "0") }))
	public void listenToPartition(@Payload String message, @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition) {
		userService.consume("1 - " + message);
	}

	@KafkaListener(topics = "Kafka_Example_JSON", groupId = "group_json", containerFactory = "userKafkaListenerContainerFactory")
	public void consume(UserDTO userDTO) {
		User user = this.convertToModel(userDTO);
		userService.saveUser(user);
	}
	
	private User convertToModel(UserDTO userDTO) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(userDTO, User.class);
	}
}
