package com.nsc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class SendMail {

	@Autowired
	private JavaMailSender emailSender;

	public void sendMail(String toEmail, String subject, String msg, String fromEmail) {
		if(fromEmail== null || fromEmail.isEmpty())
		{
			fromEmail = "thirstyxthursday@gmail.com";
			
		}
		if(toEmail == null || toEmail.isEmpty())
		{
			toEmail = "Edwardk110@gmail.com";
		}
		
		
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(toEmail);
		message.setSubject(subject);
		message.setText(msg);
		message.setFrom(fromEmail);

		emailSender.send(message);

	}

	public void getMail(String fromEmail, String subject, String msg) {
		SimpleMailMessage message = new SimpleMailMessage();
		if(fromEmail== null || fromEmail.isEmpty())
		{
			fromEmail = "thirstyxthursday@gmail.com";
			
		}
		
		
		message.setFrom(fromEmail);
		message.setSubject(subject);
		message.setText(msg);
		message.setTo("thirstyxthursday@gmail.com");

		emailSender.send(message);

	}

	/* public void sendMail(String toEmail, String subject, String msg, String senderEmail) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(toEmail);
		message.setSubject(subject);
		message.setText(msg);
		message.setFrom(senderEmail);

		emailSender.send(message);

	} */
	
}
