package com.kafkaPublisher.kafkaPublisher.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kafkaPublisher.kafkaPublisher.Model.User;

/**
 * class kafkaPublisher
 * 
 * 
 * @author dines
 * @created date 22/12
 * @description used to map the endpoints and publis the messages into stream
 *
 */
@RestController
@RequestMapping("publish")
public class kafkaPublisher {
	
	/**
	 * bean of KafkaTemplate
	 */
	private final KafkaTemplate<String, Object> kafkaTemplate;
	
	
	/**
	 * topic1 name of the kafka
	 */
	@Value("${kafka.topic1}")
	private String empDetails;
	
	/**
	 * topic2 name of the kafka
	 */
	@Value("${kafka.topic2}")
	private String UserDetails;
	
	
	/**
	 * Parameterized Constructor
	 * 
	 * @param kafkaTemplate
	 * @Description used for Dependency Injection
	 */
	@Autowired
	public kafkaPublisher(KafkaTemplate<String, Object> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}
	
	/**
	 * function publishMessage
	 * 
	 * @param name
	 * @return confirmation message has been published
	 */
	@GetMapping("/{name}")
    public void publishMessage(@PathVariable String name)	{
		kafkaTemplate.send(empDetails, "Hi"+" "+ name + " This is From Kafka Stream");
	}
	
	/**
	 * function PublishMessage
	 * 
	 * @param none
	 * @return User Details message has been published
	 */
	@GetMapping("/json")
    public void publishMessage()	{
		User myUSer = new User(1,"testUser","abc@gmail.com","1234567898");
		kafkaTemplate.send(UserDetails, myUSer);
	}
	

}
