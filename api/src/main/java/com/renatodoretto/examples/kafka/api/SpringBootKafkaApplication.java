package com.renatodoretto.examples.kafka.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = {"com.renatodoretto.springbootkafka.core.model"})
@EnableJpaRepositories(basePackages = {"com.renatodoretto.springbootkafka.core.repository"})
@SpringBootApplication(scanBasePackages = {"com.renatodoretto.springbootkafka"})
public class SpringBootKafkaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootKafkaApplication.class, args);
	}

}
