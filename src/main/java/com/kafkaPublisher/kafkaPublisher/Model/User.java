package com.kafkaPublisher.kafkaPublisher.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * class User
 * 
 * @author dines
 * @created date 22/12
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

	/**
	 * id of the user
	 */
	private int id;
	
	/**
	 * name of the user
	 */
	private String name;
	
	/**
	 * email of the user
	 */
	private String email;
	
	/**
	 * mobile no of the user
	 */
	private String mobile;
	
}
