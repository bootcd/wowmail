package mailer;

import java.io.UnsupportedEncodingException;
import java.util.Properties;
import java.util.Scanner;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.sun.mail.smtp.SMTPTransport;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;

import mailer.Attachment;

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
	
	
	
	public Message Compile(Account account) throws UnsupportedEncodingException{
		
		Session session = Session.getInstance(setProps(account), new Authenticator(){
			protected PasswordAuthentication getPasswordAuthentication() 
					{return new PasswordAuthentication(account.getUserName(), account.getPassword());}});
		
		
		try {
			Message message = new MimeMessage (session);
			message.setFrom(new InternetAddress(account.getmailBox(), account.getName()));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
			message.setSubject(subject);
			message.setText(text);
			Scanner input = new Scanner(System.in);
			
			System.out.println("Want attach? Chose Yes or NO");
			System.out.println("1)Yes 2)NO");
			int chose = input.nextInt();
			
			if (chose==1) {
				
				BodyPart messageBodyPart = new MimeBodyPart();
				messageBodyPart.setText(text);
				Multipart multipart = new MimeMultipart();
				multipart.addBodyPart(messageBodyPart);
			
			
			while (chose!=2){
				messageBodyPart = new MimeBodyPart();
				Attachment attachment = new Attachment();
				System.out.print("Insert path to file");
				Scanner pathInput = new Scanner(System.in);
				String pathName = pathInput.nextLine();
				attachment.setPath(pathName);
				
				DataSource source = new FileDataSource(attachment.getPathName());
				messageBodyPart.setDataHandler(new DataHandler(source));
				messageBodyPart.setFileName(attachment.getPathName());
				multipart.addBodyPart(messageBodyPart);
				System.out.println("Want more attachment");
				System.out.println("1)Yes 2)NO");
				chose=input.nextInt();}
			    message.setContent(multipart);
				return message;
				
			}
			return message;
			
		}

	
		catch (MessagingException e){
			throw new RuntimeException(e);
			
		}

}
	public void Send(Message message) throws MessagingException{
		Transport.send(message);
		System.out.println("Your mail was send ");
		}

	
}