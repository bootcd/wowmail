package first;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


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
      
    
    public static void WriteDB(Account account) throws SQLException
    {
    	
    	String insertQ = "INSERT INTO 'account' ('name' , 'mailbox') VALUES ('"+ account.getName() + "','" + account.getmailBox() + "');" ;
           statmt.execute(insertQ);
          
          
           System.out.println("Таблица заполнена");
    }
    public static void CloseDB() throws ClassNotFoundException, SQLException
    {
     conn.close();
     statmt.close();
   //  resSet.close();
     
     System.out.println("Соединения закрыты");
    }
    
    
    
}