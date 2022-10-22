package com.codesnip.app.config.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import com.codesnip.app.config.email.constants.EmailVerificationDetails;

@Component
public class VerificationEmailServiceImpl implements VerificationEmailService {

	@Autowired
	private JavaMailSender javaMailSender;

	@Value("${spring.mail.username}")
	private String sender;

	@Override
	public String sendSimpleMail(String email) {
		try {

			// Create email details template
			EmailDetails emailDetails = new EmailDetails();

			// Creating a simple mail message
			SimpleMailMessage mailMessage = new SimpleMailMessage();

			// initialize message subject & body
			emailDetails.setRecipient(email);
			emailDetails.setSubject(EmailVerificationDetails.EMAIL_SUBJECT);
			emailDetails.setMsgBody(EmailVerificationDetails.EMAIL_BODY);

			// Setting up necessary details
			mailMessage.setFrom(sender);
			mailMessage.setTo(emailDetails.getRecipient());
			mailMessage.setSubject(emailDetails.getSubject());
			mailMessage.setText(emailDetails.getMsgBody());

			// Sending the mail
			javaMailSender.send(mailMessage);
			return "Mail Sent Successfully";
		}

		// Catch block to handle the exceptions
		catch (Exception e) {
			return "Error while Sending Mail";
		}
	}
}
