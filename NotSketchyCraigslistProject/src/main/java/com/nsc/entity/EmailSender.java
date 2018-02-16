package com.nsc.entity;

public class EmailSender {

	private String fromEmail;
	private String subject;
	private String message;
	private String toEmail;
	
	
	public String getFromEmail() {
		return fromEmail;
	}
	public void setFromEmail(String fromEmail) {
		this.fromEmail = fromEmail;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getToEmail() {
		return toEmail;
	}
	public void setToEmail(String toEmail) {
		this.toEmail = toEmail;
	}
	@Override
	public String toString() {
		return "EmailSender [fromEmail=" + fromEmail + ", subject=" + subject + ", message=" + message + ", toEmail="
				+ toEmail + "]";
	}

	
	
}
