package com.example.file.dto;

import com.example.file.entity.User;

import lombok.Data;

@Data
public class UserDTO {
   
	private String id;
	private String name;
	private String gender;
	private String email;
	private String phone;
	private String hobbiesTravel;
	private String hobbiesMovie;
	
	public static UserDTO convertTo(User user) {
		UserDTO userDto = new UserDTO();
		userDto.setId(user.getId());
		userDto.setEmail(user.getEmail());
		userDto.setGender(user.getGender());
		userDto.setName(user.getName());
		userDto.setPhone(user.getPhone());
		userDto.setHobbiesMovie(user.getHobbiesMovie());
		userDto.setHobbiesTravel(user.getHobbiesTravel());
		return userDto;
	}
}
