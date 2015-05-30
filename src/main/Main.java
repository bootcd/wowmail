package main;

import java.io.UnsupportedEncodingException;
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

Account account =  new Account();


//String fff = String.valueOf(Account.existTest());
//System.out.println(fff);

int chose=0;
while (chose != 5){
	System.out.println("Chose what you want");
	Main.choseMenuNoAcc();
    chose = scan.nextInt();	
	switch(chose){
	case 1:
		
	    account.add();
	    account.showPreferences();
	    System.out.println("Do you want to save this E-mail account?");
	    System.out.println("1) yes  2) no");
	    int saveChose = scan.nextInt();
	    if(saveChose==1){
	    	conn.Conn();         
		    conn.writeAccount(account);
	    	
	    }
	    
	     break;
	
	case 2:
		 account.change();
		 break;
	case 3:
		Mail mail = new Mail();
	     mail.setToFromText();
	     mail.compileAndSend(account);
	     break;
}
	        
	
	     
		}
System.exit(1);
	}
}


