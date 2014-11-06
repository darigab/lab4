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

public class DataB 
{
    public static void createTable(){
    Connection c = null;
    Statement stmt = null;
    try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:test.db");
      System.out.println("Opened database successfully");

      stmt = c.createStatement();
      String sql = "CREATE TABLE  " +
                   "(ID INT PRIMARY KEY     NOT NULL," +
                   " FISRT_NAME           TEXT    NOT NULL, " + 
                   " LAST_NAME           TEXT    NOT NULL, " + 
                  "FACULTY      TEXT    NOT NULL)"; 
      
    
      stmt.executeUpdate(sql);
    stmt.close();
    c.close();
  } catch ( Exception e ) {
    System.err.println( e.getClass().getName() + ": " + e.getMessage() );
    System.exit(0);
  }
  System.out.println("Table created successfully");
  }

  	   	
    
    private void insertStudents(){
    	Connection c = null;
        Statement stmt = null;
        try {
          Class.forName("org.sqlite.JDBC");
          c = DriverManager.getConnection("jdbc:sqlite:test.db");
          System.out.println("Opened database successfully");

          stmt = c.createStatement();
          String sql = "INSERT INTO Studs (ID,FIRST_NAME,LAST_NAME,FACULTY) " +
              "VALUES (1, 'Dariga', 'Baybulsinova', 'FIT' );"; 
 stmt.executeUpdate(sql);

 sql = "INSERT INTO Studs (ID,FIRST_NAME,LAST_NAME,FACULTY) " +
       "VALUES (2, 'Sveta',  'Kirillova', 'FOGI' );"; 
 stmt.executeUpdate(sql);

 sql = "INSERT INTO Studs (ID,FIRST_NAME,LAST_NAME,FACULTY) " +
       "VALUES (3, 'Alim', 'Amanov', 'KMA' );"; 
 stmt.executeUpdate(sql);

 stmt.executeUpdate(sql);
 ResultSet rs = stmt.executeQuery( "SELECT * FROM Studs;" );
 while ( rs.next() ) {
    int id = rs.getInt("id");
    String  firstName = rs.getString("FIRST_NAME");
    String  lastName = rs.getString("LAST_NAME");
    String  faculty = rs.getString("FACULTY");
    
    System.out.println( "ID = " + id );
    System.out.println( "FIRST_NAME = " + firstName );
    System.out.println( "LAST_NAME" + lastName );
    System.out.println( "FACULTY = " + faculty );
    
    
    System.out.println();
 }
 	  rs.close();
      stmt.close();
      c.close();
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      System.exit(0);
    }
    System.out.println("Table created successfully");
  
  	   	
    }
	}

