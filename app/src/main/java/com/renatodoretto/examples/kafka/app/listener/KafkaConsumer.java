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
import com.renatodoretto.examples.kafka.services.UserService;

@Service
public class KafkaConsumer {

	@Autowired
	private UserService userService;
	
	@Autowired
	private ModelMapper modelMapper;

	@KafkaListener(groupId = "group_id", containerFactory = "kafkaListenerContainerFactory", topicPartitions = @TopicPartition(topic = "Kafka_Example", partitionOffsets = {
			@PartitionOffset(partition = "0", initialOffset = "0") }))
	public void listenToPartition(@Payload String message, @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition) {
		// System.out.println("Consumed message: " + message + " from partition: " +
		// partition);
		userService.consume(message);
	}

	@KafkaListener(groupId = "group_json", containerFactory = "userKafkaListenerContainerFactory", topicPartitions = @TopicPartition(topic = "Kafka_Example_JSON", partitionOffsets = {
			@PartitionOffset(partition = "0", initialOffset = "0") }))
	public void consume(UserDTO userDTO) {
		User user = this.convertToModel(userDTO);
		userService.saveUser(user);
	}
	
	private User convertToModel(UserDTO userDTO) {
		return modelMapper.map(userDTO, User.class);
	}
}
