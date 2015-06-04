package mailer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import mailer.Account.*;

public class Dbworks {
    public static Connection conn;
    public static Statement statmt;
    public static ResultSet resSet;
    
     // --------ПОДКЛЮЧЕНИЕ К БАЗЕ ДАННЫХ--------
    public static void Conn() throws ClassNotFoundException, SQLException 
       {
           conn = null;
           Class.forName("org.sqlite.JDBC");
           conn = DriverManager.getConnection("jdbc:sqlite:account.s3db");
           statmt = conn.createStatement();
           
       }
      
    // --------ЗАПИСЬ СВОЙСТВ АККАУНТА В БАЗУ ДАННЫХ--------
    public static void writeAccPrefs(Map <String, String> prefs) throws SQLException
    {
   
    	String insertQ = "INSERT INTO 'account' ('name' , 'mailbox' , 'password' , 'smtphost' , "
    			+ "'smtpport' , 'imaphost' , 'imapport' , 'pophost' , 'popport' , 'smtpauth' , 'smtpstarttlsenable')"
    			+ "VALUES ('"+ prefs.get("name") + "','" + prefs.get("mailbox") + "','" + prefs.get("password") + "','" 
    			+ prefs.get("username")+ "','"+ prefs.get("smtphost") + "','" + prefs.get("smtpport") +"','" + prefs.get("imaphost") + "','" 
    			+ prefs.get("imapport") + "','" + prefs.get("pophost") + "','" + prefs.get("popport") + "','" 
    			+ prefs.get("smtpauth") + "','" + prefs.get("smtpstarttlsenable") +"');" ;
           statmt.execute(insertQ);
          
          
           System.out.println("Аккаунт сохранен!");
    }
    
    // --------ИЗВЛЕЧЕНИЕ СВОЙСТВ АККАУНТА ИЗ БАЗЫ ДАННЫХ--------
     public static void  getAccPrefs(String accMailBox) throws SQLException{
    	 
    	 String selectQ = "SELECT * FROM account WHERE mailbox = '" + accMailBox  + "';";
    	 resSet = statmt.executeQuery(selectQ);
 
  Account.preferencies.put( "name", resSet.getString("name"));
  Account.preferencies.put( "mailbox", resSet.getString("mailbox"));
  Account.preferencies.put( "password", resSet.getString("password"));
  Account.preferencies.put( "username", resSet.getString("username"));
  Account.preferencies.put( "smtphost", resSet.getString("smtphost"));
  Account.preferencies.put( "smtpport", resSet.getString("smtpport"));
  Account.preferencies.put( "imaphost", resSet.getString("imaphost"));
  Account.preferencies.put( "imapport", resSet.getString("imapport"));
  Account.preferencies.put( "pophost", resSet.getString("pophost"));
  Account.preferencies.put( "popport", resSet.getString("popport"));
  Account.preferencies.put( "smtpauth", resSet.getString("smtpauth"));
  Account.preferencies.put( "smtpstarttlsenable", resSet.getString("smtpstarttlsenable"));
    }   
    
    
    
    
    
    
    
    
    
    
    
    
    
    public static void CloseDB() throws ClassNotFoundException, SQLException
    {
     conn.close();
     statmt.close();
     //resSet.close();
      }
    
    
    
}