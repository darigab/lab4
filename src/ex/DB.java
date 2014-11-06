package ex;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.URI;
import java.sql.*;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

public class DB
{
  public static void main( String args[] ) throws IOException 
  {
	  HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
		server.createContext("/", new MyHandler());
		server.setExecutor(null); // creates a default executor
		server.start();
	  
    Connection c = null;
    Statement stmt = null;
    try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:test.db");
      System.out.println("Opened database successfully");

      stmt = c.createStatement();
     /*String sql = "CREATE TABLE St2" +
              "(ID integer primary key  autoincrement not null ,"
	      		+ " FIRST_NAME varchar(15) not null,"
	      		+ " LAST_NAME varchar(15) not null,"
	      		+ "FACULTY varchar(10) not null)"; 
 
 stmt.executeUpdate(sql);
stmt.close();
c.close();*/

    } catch ( Exception e ) {
    	 System.err.println( e.getClass().getName() + ": " + e.getMessage() );
    	 System.exit(0);
    	}
    	System.out.println("Table created successfully");
  }

//insertStudents();

	   	
public static void insertUser(String firstName, String lastName,String faculty){
	
	Connection c = null;
	Statement stmt = null;
	try{
	      Class.forName("org.sqlite.JDBC");
	      c = DriverManager.getConnection("jdbc:sqlite:test.db");
	      System.out.println("Opened database successfully");

	      stmt = c.createStatement();
		String sql = "insert into St2 (first_name, last_name, faculty) values ('"+firstName+"', '"
		                                   +lastName+"','"+faculty+"'); ";
		
	   stmt.execute(sql);
		
	}catch ( Exception e ) {
   	 System.err.println( e.getClass().getName() + ": " + e.getMessage() );
   	 System.exit(0);
   	}
   	System.out.println("Records made successfully");
} 
}

