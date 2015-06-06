package mailer;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Account {
    String name;
    String mailBox;
    String password;
    String username;
    String smtpHost;
    String smtpPort;
    String smtpAuth;
    String smtpStartTlsEnable;
    String imapHost;
    String imapPort;
    String popHost ;
    String popPort ;
    public  static Map<String, String> preferencies = new HashMap<String, String>();
    
  //конструктор  
    
Account(Map<String, String> prefs){
		
	this.setName(prefs.get("name"));
	this.setMailBox(prefs.get("mailbox"));
	this.setPassword(prefs.get("password"));
	this.setUserName(prefs.get("username"));
	this.setsmtpHost(prefs.get("smtphost"));
	this.setsmtpPort(prefs.get("smtpport"));
	this.setsmtpHost(prefs.get("smtphost"));
	this.setSmtpAuth(prefs.get("smtpauth"));
	this.setSmtpStartTlsEnable(prefs.get("smtpstarttlsenable"));
	this.setimapHost(prefs.get("imaphost"));
	this.setimapPort(prefs.get("imapport"));
	this.setpopHost(prefs.get("pophost"));
	this.setpopPort(prefs.get("popport"));
			}

  // общий метод создания объекта класса Account

 public static Account createAccObject(Map<String, String> prefs){
	 return new Account(prefs); 
 }
    
   //блок сеттеров и геттеров полей класса
 
    void setName(String name){
        this.name=name;
    }
    
    String getName(){
        return this.name;
    }
    
    void setMailBox(String mailBox){
        this.mailBox=mailBox;
    }
    
    String getmailBox(){
        return this.mailBox;
    }
    
    void setPassword(String password){
        this.password=password;
    }
    
    String getPassword(){
        return this.password;
    }
    
    void setUserName(String username){
        this.username=username;
    }
    
    String getUserName(){
        return this.username;
    }
    
    
    void setsmtpHost(String smtpHost){
        this.smtpHost=smtpHost;
    }
    
    String getsmtpHost(){
        return this.smtpHost;
    }
    
    void setsmtpPort(String smtpPort){
        this.smtpPort=smtpPort;
    }
    
    String getsmtpPort(){
        return this.smtpPort;
    }
    
    void setSmtpStartTlsEnable(String smtpStartTlsEnable){
    	this.smtpStartTlsEnable=smtpStartTlsEnable;
    }
    
    public String getsmtpStartTlsEnable(){
    	return this.smtpStartTlsEnable;
    }
    
    void setSmtpAuth(String smtpAuth){
    	this.smtpAuth=smtpAuth;
    }
    
   public  String getSmtpAuth(){
    	return this.smtpAuth;
    }

    void setimapHost(String imapHost){
        this.imapHost=imapHost;
    }
    
    String getimapHost(){
        return this.imapHost;
    }
    
    void setimapPort(String imapPort){
        this.imapPort=imapPort;
    }
    
    String getimapPort(){
        return this.imapPort;
    }
    
    void setpopHost(String popHost){
        this.popHost=popHost;
    }
    
    String getpopHost(){
        return this.popHost;
    }
    
    void setpopPort(String popPort){
        this.popPort=popPort;
    }
    
    String getpopPort(){
        return this.popPort;
    }
   
    //метод, исполняющий диалог пользователя, в котором задается хэшмап для значений полей класса 
    
    public static void  setPrefsWithUserDailog(){
		Scanner scan = new Scanner(System.in);
        System.out.print("Insert name:");
        String name = scan.nextLine();
        preferencies.put("name", name);
              
        System.out.print("Inset mailbox:");
        String mailb = scan.nextLine();
        preferencies.put("mailbox", mailb);
        
        System.out.print("Inset password:");
        String pass = scan.nextLine();
        preferencies.put("password", pass);
        
        System.out.print("Inset username:");
        String usern = scan.nextLine();
        preferencies.put("username", usern);
        
        System.out.print("Inset SMTP host:");
        String smtph = scan.nextLine();
        preferencies.put("smtphost", smtph);
        
        System.out.print("Inset SMTP port:");
        String smtpp = scan.nextLine();
        preferencies.put("smtpport", smtpp);

        System.out.print("Use SMTP Auth? 1)yes 2)no");
        String smtpAuthChose = scan.nextLine();
        if (smtpAuthChose.equals("1")){
        	preferencies.put("smtpauth", "true");
        }
        else{
        	preferencies.put("smtpauth", "false");
        }
    
        System.out.print("Use SMTP StartTLS 1)yes 2)no");
        String startTLSChose = scan.nextLine();
        if (startTLSChose.equals("1")){
        	preferencies.put("smtpstarttlsenable", "true");
        }
        else{
        	preferencies.put("smtpstarttlsenable", "false");
        }
        
                
        System.out.println("1)IMAP 2)POP3:");
        String chose = scan.nextLine();
        if (chose.equals("1")){
            System.out.println("Insert your IMAP server:");
            String imaph = scan.nextLine();
            preferencies.put("imaphost", imaph);
            
            System.out.println("Insert port for IMAP:");
            String imapp = scan.nextLine();
            preferencies.put("imapport", imapp);
        }
        
        else {
            System.out.print("Insert your POP server:");
            String poph = scan.nextLine();
            preferencies.put("pophost", poph);
            System.out.print("Insert port for POP3:");
            String popp = scan.nextLine();
            preferencies.put("popport", popp);
            }
    }
    
    // Метод, позволяющий выбрать настройку аккаунта для изменения
 private void prefSwitcher(int chose){
	 Scanner scan = new Scanner(System.in);
		   switch(chose) {
		   case 1:
			   System.out.print("Change Account Name");
			   String name = scan.nextLine();
		       this.setName(name);
		       break;
		       
		   case 2:
			   
		        System.out.print("change mailbox:");
		        String mailBox = scan.nextLine();
		        this.setMailBox(mailBox);
		        break;
		   case 3:    
		        System.out.print("change password:");
		        String password = scan.nextLine();
		        this.setPassword(password);
		        break;
		   case 4:     
		        System.out.print("change username:");
		        String username = scan.nextLine();
		        this.setUserName(username);
		        break;
		   case 5:                   
		        System.out.print("change SMTP server:");
		        String smtpHost = scan.nextLine();
		        this.setsmtpHost(smtpHost);
		        break;
		   case 6:
		        System.out.print("change port for SMTP:");
		        String smtpPort = scan.nextLine();
		        this.setsmtpPort(smtpPort);
		        break;
		      			   
		   }
	   }
 
 	// Метод, позволяющий изменить настройки аккаунта, если аккаунт IMAP
 
 private void imapSwitcher(int chose){
	 Scanner scan = new Scanner(System.in);
	 switch(chose){
	 case 7:
	 System.out.println("Change your IMAP server:");
	 String imapHost = scan.nextLine();
     this.setimapHost(imapHost);
     break;
	 
	 case 8:
     System.out.println("Change port for IMAP:");
     String imapPort = scan.nextLine();
     this.setimapPort(imapPort);
     break;
	 }
 }
    
//Метод, позволяющий изменить настройки аккаунта, если аккаунт POP
 
  private void popSwitcher(int chose){

	 Scanner scan = new Scanner(System.in);
	 
	 switch(chose){
	 
	 case 7:
		 
	 System.out.print("Change your POP server:");
     String popHost = scan.nextLine();
     this.setpopHost(popHost);
     break;
     
	 case 8:
		 
     System.out.print("Change port for POP3:");
     String popPort = scan.nextLine();
     this.setpopPort(popPort);
     break;
	 }
 }

 // Общий метод изменения настроек аккаунта 
  
 public void change(){
	   
	   Scanner scan = new Scanner(System.in);
	   
       System.out.println("Chose preference to change:");
       System.out.print("1)Account Name; 2)Account mailbox  3)Account username 4)Account password; 5)SMTP server; 6)SMTP port");
       
       if (this.imapHost!=null & this.imapPort!=null){
           System.out.println("7) IMAP server; 8) IMAP port");
           int chasngeChose = scan.nextInt();
           prefSwitcher(chasngeChose);
           imapSwitcher(chasngeChose);
       }
       
       else {
           System.out.println("7) POP server; 8) POP port");
           int chasngeChose = scan.nextInt();
           prefSwitcher(chasngeChose);
           popSwitcher(chasngeChose);
       }
  
   }
    
} //class