package main;

import java.io.UnsupportedEncodingException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import mailer.Account;
import mailer.Mail;
import mailer.conn;



public class Main {
	
	
static	void choseMenuNoAcc(){
		System.out.println("1) Create Mal Account \n2) Change some settings \n3) Send E-mail \n4) Exit");	
	}	

static	void choseMenuWithAcc(){
	System.out.println("1) Create Mal Account \n2) Change some settings \n3) Send E-mail \n4) Use existing account \n5) Exit");	
}




public static void main(String[] args) throws UnsupportedEncodingException, SQLException, ClassNotFoundException {

System.out.println("Hi there! This is WOWMail! The dumbest program in the world. It`s like a gayworm shit.");

Scanner scan = new Scanner(System.in);
Account account;
int chose=0;
while (chose != 5){
	conn.Conn();
	String insertQ = "SELECT name, mailbox from account;";
	ResultSet rs = mailer.conn.statmt.executeQuery(insertQ);
	conn.CloseDB();
/*	while(rs.next()){
		
		System.out.println(rs.getString("name"));
	}*/

	System.out.println("Chose what you want");
	
	if (!rs.next()){
	choseMenuNoAcc();
	}
	else{
		choseMenuWithAcc();
	}
    chose = scan.nextInt();	
   	switch(chose){
	case 1:
		
	Account.setPrefsWithUserDailog();
	System.out.println(Account.preferencies.get("mailbox"));
    System.out.println("Do you want to save this E-mail account?");
	System.out.println("1) yes  2) no");
	int saveChose = scan.nextInt();
	  if(saveChose==1){
	    	conn.Conn();         
		    conn.writeAccount(Account.preferencies);
	    	conn.CloseDB();
	    	break;
	  }

	case 3:
		account = Account.createAccObject(Account.preferencies);
		Mail mail = new Mail();
	    mail.setToFromText();
	    mail.compileAndSend(account);
	    break;
}

		}
System.exit(1);
	
}
}


