package com.codesnip.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codesnip.app.config.email.VerificationEmailService;

@RestController
public class VerificationEmailSenderController {

	@Autowired
	VerificationEmailService verificationEmailService;

	@PostMapping("/verifyaccount")
	public ResponseEntity<String> sendVerificationEmail(@RequestParam String email) {
		String status = verificationEmailService.sendSimpleMail(email);
		return new ResponseEntity<>(status, HttpStatus.OK);
	}
}
