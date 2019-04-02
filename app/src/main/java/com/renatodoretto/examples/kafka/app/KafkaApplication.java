package com.renatodoretto.examples.kafka.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EntityScan(basePackages = {"com.renatodoretto.examples.kafka.core.model"})
@EnableJpaRepositories(basePackages = {"com.renatodoretto.examples.kafka.core.repository"})
@SpringBootApplication(scanBasePackages = {"com.renatodoretto.examples.kafka"})
public class KafkaApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaApplication.class, args);
	}

}
