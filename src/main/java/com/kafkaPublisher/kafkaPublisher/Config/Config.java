package com.kafkaPublisher.kafkaPublisher.Config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

/**
 * class Config
 * 
 * @author dines
 * @created date 22/12
 * @description used to create singleton bean for this module
 *
 */
@Configuration
public class Config {
	
	/**
	 * function producerFactory
	 * 
	 * @return ProducerFactory<String, Object> bean
	 */
	@Bean
	public ProducerFactory<String, Object> producerFactory() {
		Map<String,Object> config = new HashMap<String,Object>();
		config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
		return new DefaultKafkaProducerFactory<String, Object>(config);
	}
	
	/**
	 * function kafkaTemplate
	 * 
	 * @return KafkaTemplate<String, Object>
	 */
	@Bean
	public KafkaTemplate<String, Object> kafkaTemplate() {
		return new KafkaTemplate<>(producerFactory());
	}

}
