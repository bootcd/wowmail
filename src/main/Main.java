package main;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import mailer.Account;
import mailer.Dbworks;
import mailer.Mail;



public class Main {
	
	static ResultSet rs;
	static String mailboxes[] = new String[100];
	static int accChose;
	static Scanner scan = new Scanner(System.in);
	static boolean accountExists;
	
	static boolean accountExists() throws ClassNotFoundException, SQLException{
		mailer.Dbworks.Conn();
		String countQ="SELECT COUNT(*) FROM account;";
		ResultSet rs = mailer.Dbworks.statmt.executeQuery(countQ);
		if (rs.getInt(1) >0){
		//System.out.println(rs.getInt(1));
		mailer.Dbworks.CloseDB();
		return true;
		}
		else{
			mailer.Dbworks.CloseDB();
			return false;
		}
	}
	
	static	void choseMenuNoAcc(){
		
			System.out.println("1) Read E-mail \n2) Write E-mail \n3) Properties \n4) Exit");	
		}


	static	void propertiesMenu(){
		
		System.out.println("1) Add E-mail account;\n2) Chose E-mail account \n3) Change account preferences \n4) Exit to previous menu");	
	   }

	static ResultSet dbQuertForAccounts() throws ClassNotFoundException, SQLException{
		
		mailer.Dbworks.Conn();
		String insertQ = "SELECT name, mailbox from account;";
		ResultSet rs = mailer.Dbworks.statmt.executeQuery(insertQ);
		System.out.println("Your accounts:");
		//Dbworks.CloseDB();
		return rs;
	   }

	static String[] setMailboxesArray(ResultSet rs) throws SQLException, ClassNotFoundException{
		
		int counter=0;
		//mailer.Dbworks.Conn();
		while(rs.next()){
			counter++;
			System.out.print(counter + ") ");
			System.out.print(rs.getString("mailbox") + " - ");
			mailboxes[counter]=rs.getString("mailbox") ;
			System.out.println(rs.getString("name"));
				}
		return mailboxes;
			} 
	
	static int setAccChoseWithDialog(String[] mailboxes){
		
		System.out.println("Chose account to use:");
		int accChose=scan.nextInt();
		System.out.println("You chose account with E-mail: " + mailboxes[accChose]);
		return accChose;
		
		
		
	}
	
	
// --------------------------- ТОЧКА ВХОДА В ПРОГРАММУ-----------------------------------------------------------------------------------
	
public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {


	System.out.println("Hi there! This is WOWMail! The dumbest program in the world. It`s like a gayworm shit.");
	
	accountExists = accountExists();
	if (!accountExists){
		System.out.println("You don`t have account. Please, add it with 'Properties' menu.");
	}
	else {
	
	// Выбор почтового аккаунта для работы с помощью диалогов.
	
	accChose = setAccChoseWithDialog(setMailboxesArray(dbQuertForAccounts()));
	
	//Извлечение из базы данных аккаунтов  настроек для выбранного аккаунта.
	
	Dbworks.getAccPrefs(mailboxes[accChose ]);
	}
	
	int chose=0;
	while (chose != 4){

	System.out.println("Chose what you want");

	choseMenuNoAcc();
    chose = scan.nextInt();	
   	switch(chose){
	case 1:

		System.out.println("You reading your E-mail");
		break;
		
	case 2: 
		if (!accountExists){
			System.out.println("You don`t have account. Please, add it with 'Properties' menu.");
		}
		else{
	Account account = Account.createAccObject(Account.preferencies);
	Mail mail = new Mail();
    mail.setToFromText();
    mail.compileAndSend(account);
    	}
		break;
		
	case 3:
		
		propertiesMenu();
		int PropertiesChose=0;
		PropertiesChose = scan.nextInt();
		while (PropertiesChose!= 4){
		switch(PropertiesChose)	{
		
			case 1: 
				
				Account.setPrefsWithUserDailog();
				System.out.println("Do you want to save this E-mail account?");
				System.out.println("1) yes  2) no");
				int saveChose = scan.nextInt();
				  if(saveChose==1){
				    	Dbworks.Conn();         
					    Dbworks.writeAccPrefs(Account.preferencies);
				    	Dbworks.CloseDB();
     				  	}
				  PropertiesChose=4;
				  break;
					  
			case 2:
				accountExists = accountExists();
				if (!accountExists){
					System.out.println("You don`t have account. Please, add it with 'Properties' menu.");
				}
				else {

				
				accChose = setAccChoseWithDialog(setMailboxesArray(dbQuertForAccounts()));
				
				
				Dbworks.getAccPrefs(mailboxes[accChose ]);
				}
				PropertiesChose=4;
				break;
			
			case 3:
				
				System.out.println("Under consruction");
				PropertiesChose=4;
				break;
				
			case 4:
				
				break;	
				
		}
		
		}
		

   	}

		}
	System.exit(1);
	
	}
} //class


