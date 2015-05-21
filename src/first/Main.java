package first;

import java.io.UnsupportedEncodingException;

public class Main {
	
public static void main(String[] args) throws UnsupportedEncodingException {
		
	

	   
	        
	     Account account =  new Account();
	    
	   account.add();
	     account.change();
	     Mail mail = new Mail();
	     mail.setToFromText();
	     mail.compileAndSend(account);
		}
	}


