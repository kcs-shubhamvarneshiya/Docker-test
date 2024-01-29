/**
 * 
 */
package com.example.file.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.file.dto.UserDTO;
import com.example.file.entity.Fields;
import com.example.file.entity.User;
import com.example.file.repository.UserRepository;
import com.example.file.service.UserService;
import com.example.file.utils.FdfUtility;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author keertik.patel
 *
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDTO createUser(String data) {
		ObjectMapper objectMapper = new ObjectMapper();
		Fields userObj = null;
		String json = FdfUtility.parseFDFToJSON(data);
		try {
			userObj = objectMapper.readValue(json, Fields.class);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		User saveUser = userObj.getFields().get(0);
		 userRepository.save(saveUser);
		return UserDTO.convertTo(new User());
	}

}
