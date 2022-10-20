package com.thomascruzana.codesnip.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.thomascruzana.codesnip.dto.UserDto;
import com.thomascruzana.codesnip.service.UserService;

// Controller class for user registration
@RestController
public class RegisterController {

	@Autowired
	private Environment environment;

	@Autowired
	private UserService userService;

	// endpoint for registering user details
	@PostMapping("/register")
	public ResponseEntity<?> registerUser(@RequestBody UserDto userDto) {
		UserDto newUserDto = null;
		ResponseEntity<?> response = null;
		try {
			newUserDto = userService.createUser(userDto);

			if (newUserDto != null) {
				response = new ResponseEntity<>(environment.getProperty("success.registration"), HttpStatus.CREATED);
				// log
			}
		} catch (Exception ex) {
			response = new ResponseEntity<>(environment.getProperty("error.generic"), HttpStatus.INTERNAL_SERVER_ERROR);
			// log
		}

		return response;

	}

}
