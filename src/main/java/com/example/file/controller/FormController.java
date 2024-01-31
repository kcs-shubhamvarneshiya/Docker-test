package com.example.file.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FormController {

	@GetMapping("/")
	public String generateForm() throws Exception {
		return "Hello semicolon..";
	}
}
