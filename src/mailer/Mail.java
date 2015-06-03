package mailer;

import java.io.UnsupportedEncodingException;
import java.util.Properties;
import java.util.Scanner;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.Authenticator;


public class Mail {
	
	String to;
	String subject;
	String text ;

	void setTo(String to){
		this.to=to;
	}
	
	String getTo(){
		return this.to;
		}
	
	void setSubject(String subject){
		
	
		this.subject=subject;
	}
	
	String getSubject(){
		return this.subject;
		}
	
	void setText(String text){
		this.text=text;
	}
	
	String getText(){
		return this.text;
		}
	
	
	public void setToFromText(){
		Scanner scan = new Scanner(System.in);
		System.out.print("Insert recepient: ");
		String to = scan.nextLine();
		this.setTo(to);
		System.out.print("Type subject: ");
		String subject = scan.nextLine();
		this.setSubject(subject);
		System.out.print("Type text: ");
		String text = scan.nextLine();
		this.setText(text);
			}
	

	static Properties setProps(Account account){
		Properties props = new Properties();
		props.put("mail.smtp.auth", account.getSmtpAuth());
		props.put("mail.smtp.starttls.enable", account.getsmtpStartTlsEnable());
		props.put("mail.smtp.host", account.getsmtpHost());
		props.put("mail.smtp.port", account.getsmtpPort());
		return props;
	}
	
	
	
	public void compileAndSend(Account account) throws UnsupportedEncodingException{
		
		Session session = Session.getInstance(setProps(account), new Authenticator(){
			protected PasswordAuthentication getPasswordAuthentication() 
					{return new PasswordAuthentication(account.getUserName(), account.getPassword());}});
		
		
		try {
			Message message = new MimeMessage (session);
		
		message.setFrom(new InternetAddress(account.getmailBox(), account.getName()));
		message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
		message.setSubject(subject);
		message.setText(text);
		Transport.send(message);
	}
	
		catch (MessagingException e){
			throw new RuntimeException(e);
			
		}
	
	System.out.println("Your mail was send ");

}

	
}