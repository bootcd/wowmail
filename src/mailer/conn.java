package mailer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;




public class conn {
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
           System.out.println("База Подключена!");
       }
      
    
    public static void writeAccount(Map <String, String> prefs) throws SQLException
    {
   
    	String insertQ = "INSERT INTO 'account' ('name' , 'mailbox' , 'password' , 'smtphost' , "
    			+ "'smtpport' , 'imaphost' , 'imapport' , 'pophost' , 'popport' , 'smtpauth' , 'smtpstarttlsenable')"
    			+ "VALUES ('"+ prefs.get("name") + "','" + prefs.get("mailbox") + "','" + prefs.get("password") + "','"
    			+ prefs.get("smtphost") + "','" + prefs.get("smtpport") +"','" + prefs.get("imaphost") + "','" 
    			+ prefs.get("imapport") + "','" + prefs.get("pophost") + "','" + prefs.get("popport") + "','" 
    			+ prefs.get("smtpauth") + "','" + prefs.get("smtpstarttlsenable") +"');" ;
           statmt.execute(insertQ);
          
          
           System.out.println("Аккаунт сохранен!");
    }
    public static void CloseDB() throws ClassNotFoundException, SQLException
    {
     conn.close();
     statmt.close();
     //resSet.close();
     
     System.out.println("Соединения закрыты");
    }
    
    
    
}