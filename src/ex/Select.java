package ex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

public class Select {
	public static ArrayList<User> findStudents() {
		
		ArrayList<User> users = new ArrayList<>();
		int id;
		String lastName,firstName,faculty;
		Connection c = null;
	    Statement stmt = null;
	    try {
	      Class.forName("org.sqlite.JDBC");
	      c = DriverManager.getConnection("jdbc:sqlite:test.db");
	      c.setAutoCommit(false);
	      System.out.println("Opened database successfully");

	      stmt = c.createStatement();
	      ResultSet rs = stmt.executeQuery( "SELECT * FROM St2;" );
	      while ( rs.next() ) {
	    	 User user = new User();
	         id = rs.getInt("ID");
	         firstName = rs.getString("FIRST_NAME");
	         lastName = rs.getString("LAST_NAME");
	         faculty  = rs.getString("FACULTY");
	         System.out.println( "ID = " + id );
	         System.out.println( "FIRST_NAME = " + firstName );
	         System.out.println( "LAST_NAME = " + lastName );
	         System.out.println( "FACULTY = " + faculty );
	         
	         user.setId(id);
	         user.setFirstName(firstName);
	         user.setLastName(lastName);
	         user.setFaculty(faculty);
	                  
	         users.add(user);         
	               
	         System.out.println();
	      }
	      rs.close();
	      stmt.close();
	      c.close();
	    } catch ( Exception e ) {
	      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	      System.exit(0);
	    }
	    System.out.println("Operation done successfully");
	    return users;
	  }
	
	
	public static void updateUser(String id, String firstName,String lastName,String faculty){
		Connection c = null;
	    Statement stmt = null;
	    try {
	      Class.forName("org.sqlite.JDBC");
	      c = DriverManager.getConnection("jdbc:sqlite:test.db");
	      System.out.println("Opened database successfully");

	      stmt = c.createStatement();
	      String sql = "update St2 set first_name = '"+ firstName+"' , last_name = '"+lastName+"', faculty = '"
	      +faculty+"' where id = '"+id+"' ";

	      stmt.execute(sql);

	      stmt.close();
	      c.close();
	    } catch ( Exception e ) {
	      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	      System.exit(0);
	    }
	    System.out.println("Operation done successfully");
	  }

	/*public static Vector<User> findById(String id){
		Vector<User> users = new Vector<>();
		Connection c = null;
	    Statement stmt = null;
	    String lastName,firstName,faculty;
	    try {
	      Class.forName("org.sqlite.JDBC");
	      c = DriverManager.getConnection("jdbc:sqlite:test.db");
	      stmt = c.createStatement();
		
	      ResultSet rs = stmt.executeQuery( "SELECT * FROM St2 where id='"+id+"';" );
	      while ( rs.next() ) {
	    	 User user = new User();
	         //id = rs.getString("ID");
	         firstName = rs.getString("FIRST_NAME");
	         lastName = rs.getString("LAST_NAME");
	         faculty  = rs.getString("FACULTY");
	        
	         user.setFirstName(firstName);
	         user.setLastName(lastName);
	         user.setFaculty(faculty);
	                  
	         users.add(user);         
	               
	      }
	      rs.close();
	      stmt.close();
	      c.close();
	    } catch ( Exception e ) {
	      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	      System.exit(0);
	    }
	    System.out.println("Operation done successfully");
	    return users;
	  }
	      
	
	*/
	public static void deleteUser(String id){
		Connection c = null;
	    Statement stmt = null;
	    try {
	      Class.forName("org.sqlite.JDBC");
	      c = DriverManager.getConnection("jdbc:sqlite:test.db");
	      System.out.println("Opened database successfully");

	      stmt = c.createStatement();
		
		String sql = "delete from St2  where id = '"+id+"'";
		
		   stmt.execute(sql);

		      stmt.close();
		      c.close();
		    } catch ( Exception e ) {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		      System.exit(0);
		    }
		    System.out.println("Operation done successfully");
		  }

	    }
	

	



