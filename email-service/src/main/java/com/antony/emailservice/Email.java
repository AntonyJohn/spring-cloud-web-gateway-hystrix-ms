package com.antony.emailservice;

import java.io.Serializable;

public class Email implements Serializable{

	private int id;
	private String emailSubject;
	private String emilaMessage;
	private String emailFrom;
	private String emailTo;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmailSubject() {
		return emailSubject;
	}
	public void setEmailSubject(String emailSubject) {
		this.emailSubject = emailSubject;
	}
	public String getEmilaMessage() {
		return emilaMessage;
	}
	public void setEmilaMessage(String emilaMessage) {
		this.emilaMessage = emilaMessage;
	}
	public String getEmailFrom() {
		return emailFrom;
	}
	public void setEmailFrom(String emailFrom) {
		this.emailFrom = emailFrom;
	}
	public String getEmailTo() {
		return emailTo;
	}
	public void setEmailTo(String emailTo) {
		this.emailTo = emailTo;
	}
		
}
