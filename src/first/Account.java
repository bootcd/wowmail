package first;


import java.util.Scanner;


class Account {
    String name;
    String mailBox;
    String password;
    String username;
    String smtpHost;
    String smtpPort;
    boolean smtpAuth;
    boolean smtpStartTlsEnable;
    String imapHost;
    String imapPort;
    String popHost;
    String popPort;
    
    
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
    
    void setSsmtpStartTlsEnable(boolean smtpStartTlsEnable){
    	this.smtpStartTlsEnable=smtpStartTlsEnable;
    }
    
    boolean getsmtpStartTlsEnable(){
    	return this.smtpStartTlsEnable;
    }
    
    void setSmtpAuth(boolean smtpAuth){
    	this.smtpAuth=smtpAuth;
    }
    
    boolean getSmtpAuth(){
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
    
    void add() {
        
        Scanner scan = new Scanner(System.in);
        System.out.print("Insert name:");
        String name = scan.nextLine();
        this.setName(name);
        
        System.out.print("Inset mailbox:");
        String mailBox = scan.nextLine();
        this.setMailBox(mailBox);
        
        System.out.print("Insert password:");
        String password = scan.nextLine();
        this.setPassword(password);
        
        System.out.print("Insert username:");
        String username = scan.nextLine();
        this.setUserName(username);
                      
        System.out.print("Insert SMTP server:");
        String smtpHost = scan.nextLine();
        this.setsmtpHost(smtpHost);
        
        System.out.print("Insert port for SMTP:");
        String smtpPort = scan.nextLine();
        this.setsmtpPort(smtpPort);
        
        System.out.print("Use SMTP Auth? 1)yes 2)no");
        String smtpAuthChose = scan.nextLine();
        if (smtpAuthChose.equals("1")){
        	this.smtpAuth=true;
        }
        else{
        	this.smtpAuth=false;
        }
        
        System.out.print("Use SMTP StartTLS 1)yes 2)no");
        String startTLSChose = scan.nextLine();
        if (startTLSChose.equals("1")){
        	this.smtpStartTlsEnable=true;
        }
        else{
        	this.smtpStartTlsEnable=false;
        }
        
        
        
        System.out.println("1)IMAP 2)POP3:");
        String chose = scan.nextLine();
        if (chose.equals("1")){
            System.out.println("Insert your IMAP server:");
            String imapHost = scan.nextLine();
            this.setimapHost(imapHost);
            
            System.out.println("Insert port for IMAP:");
           String imapPort = scan.nextLine();
            this.setimapPort(imapPort);
        }
        
        else {
            System.out.print("Insert your POP server:");
            String popHost = scan.nextLine();
            this.setpopHost(popHost);
            System.out.print("Insert port for POP3:");
            String popPort = scan.nextLine();
            this.setpopPort(popPort);
        }
    }
    
   void change(){
	   Scanner scan = new Scanner(System.in);
	   String chasngeChose = scan.nextLine();
       System.out.println("Chose preference to change:");
       System.out.print("1)Account Name; 2)Account mailbox 3)Account password; 4)SMTP server; 5)SMTP port");
       if (this.imapHost!=null & this.imapPort!=null){
           System.out.println("6) IMAP server; 7) IMAP port");
           
       }
       else {
           System.out.println("6) POP server; 7) POP port");
       }
       
       
       
   }
  
  void showPreferences(){
   System.out.println(this.name);
     System.out.println(this.mailBox);
     System.out.println(this.password);
     System.out.println(this.smtpHost);
     System.out.println(this.smtpPort);
     if (this.imapHost!=null & this.imapPort!=null) {
     System.out.println("Imap Host= " + this.imapHost);
     System.out.println("Imap Port= " + this.imapPort);
     }
     else 
     System.out.println(this.popHost);
     System.out.println(this.popPort);   
  }
  
    
}


