/**
 * 
 */
package com.example.file.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

/**
 * @author keertik.patel
 *
 */
@Data
@Document(collection = "user")
public class User {

	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
	private String name;
	private String gender;
	private String email;
	private String phone;
	private String hobbiesTravel;
	private String hobbiesMovie;
}
