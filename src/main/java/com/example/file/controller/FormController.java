package com.example.file.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.file.dto.UserDTO;
import com.example.file.service.PdfService;
import com.example.file.service.UserService;

import jakarta.servlet.http.HttpServletResponse;

@RestController
public class FormController {

	@Autowired
	private PdfService pdfService;

	@Autowired
	private UserService userService;

	@GetMapping("/")
	public void generateForm(HttpServletResponse response) throws Exception {
		
		File pdfFile = pdfService.createDocument();

		// Set the response content type
		response.setContentType(MediaType.APPLICATION_PDF_VALUE);

		// Set the Content-Disposition header to open in browser
		response.setHeader("Content-Disposition", "inline");

		// Read the PDF file into a byte array
		byte[] pdfBytes = Files.readAllBytes(pdfFile.toPath());

		// Write the byte array to the response body
		response.getOutputStream().write(pdfBytes);
		response.getOutputStream().flush();
	}

	@PostMapping("/saveData")
	public ResponseEntity<?> processFormData(@RequestBody String data) {
		UserDTO user = userService.createUser(data);
		return ResponseEntity.ok().body(user);

	}
	
	@GetMapping("/javascript")
	 public void sendJavaScript(HttpServletResponse response) throws IOException {
        response.setContentType("application/javascript");

        // JavaScript code
        String javascriptCode = "<script> console.log('Hello, JavaScript!'); </script>";

        // Write JavaScript code to the response
        PrintWriter writer = response.getWriter();
        writer.write(javascriptCode);
        writer.flush();
    }

}
