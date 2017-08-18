package com.controller;

import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;

public class SendMail {
	
	 public void sendEmail(String host, String port,
	            final String user, final String pass, String toAddress,
	            String Subject, String message) throws AddressException,
	            MessagingException {
		 final Logger mailLog =Logger.getLogger(SendMail.class);
		 mailLog.info("Setting up properties");
	      Properties properties = new Properties();
	        properties.put("mail.smtp.host", host);
	        properties.put("mail.smtp.port", port);
	        properties.put("mail.smtp.auth", "true");
	        properties.put("mail.smtp.starttls.enable", "true");
	        properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
	        Authenticator auth = new Authenticator() {
	            public PasswordAuthentication getPasswordAuthentication() {
	            	mailLog.info("Authenticating User "+user+" at Host "+host);
	                return new PasswordAuthentication(user, pass);
	            }
	        };
	        Session session = Session.getInstance(properties, auth);
	        Message msg = new MimeMessage(session);
	        
	        msg.setFrom(new InternetAddress(user));
	        InternetAddress[] toAddresses = { new InternetAddress(toAddress) };
	        msg.setRecipients(Message.RecipientType.TO, toAddresses);
	        msg.setSubject(Subject);
	       
	        msg.setText(message);
	 
	        // sends the e-mail
	        Transport.send(msg);
	        mailLog.info("Sending message to " +toAddress);
	 }
}
