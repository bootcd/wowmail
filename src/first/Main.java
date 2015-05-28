package first;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
	
	
static	void choseMenu(){
		System.out.println("1) Create Mal Account \n2) Change some settings \n3) Send E-mail \n4) Exit");	
	}	
	
public static void main(String[] args) throws UnsupportedEncodingException, SQLException, ClassNotFoundException {
	
	
	
System.out.println("Hi there! This is WOWMail! The dumbest program in the world. It`s like a gayworm shit.");




Account account =  new Account();

Scanner scan = new Scanner(System.in);

int chose=0;
while (chose != 4){
	System.out.println("Chose what you want");
	Main.choseMenu();
    chose = scan.nextInt();	
	switch(chose){
	case 1:
		
	    account.add();
	    conn.Conn();         
	    conn.WriteDB(account);
	    account.showPreferences();
	    
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


