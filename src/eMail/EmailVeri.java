package eMail;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailVeri {
	public boolean sendMail(String email, int number) {

		String to = email;
		String from = "campusconnect@albany.edu";
		String host = "localhost";

		Properties properties = System.getProperties();
		properties.setProperty("mail.smtp.host", host);
		Session session = Session.getDefaultInstance(properties);

		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(
					to));
			message.setSubject("Email verification for CampusConnect");
			message.setContent(
					"<div class='container'><div class='navbar-header'>",
					"text/html");
			message.setContent(
					"<a class='navbar-brand page-scroll' href='#page-top'>",
					"text/html");
			message.setContent("<span class='light'>Campus</span>Connect</a>",
					"text/html");
			message.setContent("</div>", "text/html");

			message.setContent("Hello,<br>", "text/html");
			message.setContent(
					"Here is your link to complete your registration.",
					"text/html");

			message.setContent(
					"<a href='http://localhost:8080/CampusConnect/VerifyEMail?email="
							+ email + "&code=" + number + "'>click here</a>",
					"text/html");

			// Send message
			Transport.send(message);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
