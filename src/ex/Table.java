package ex;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

public class Table {

		public static String setStudents(User user) throws IOException{
			String response=null;
			response = Read.readFromFile("dat.html");
			response = response.replace("user.getId()", user.getId()+"");
			response = response.replace("user.getFirstName()", user.getFirstName()+"");
			response = response.replace("user.getLastName()", user.getLastName()+"");
			response = response.replace("user.getFaculty()", user.getFaculty()+"");
			return response;
		}
		
		public static String viewForUpdating(String id, String firstName, String lastName,String faculty) throws IOException{
			String response = null;
			response = Read.readFromFile("dat.html");
			response = response.replace("user.getId()", id);
			response = response.replace("user.getFirstName()", firstName);
			response = response.replace("user.getLastName()", lastName);
			response = response.replace("user.getFaculty()", faculty);
			//Select.updateUser(id, firstName, lastName, faculty);
			System.out.println("Updated");		
			return response;
			
		}
		public static String viewForDeleting(String id) throws IOException{
			String response = null;
			response = Read.readFromFile("deleting.html");
			response = response.replace("user.getId()", id);
			
			return response;
			
		}
		
		/*public static String viewStudentById(String id) throws IOException{
			String response = null;
			response = Read.readFromFile("studentByID.html");
			Vector<User> user = Select.findById(id);
			int id1=Read.convertToInt(id);
			
			response = response.replace("user.getId()", id);
			response+=setStudents(user.get(id1));
			
			return response;
			
		}*/
		
		public static String listOfStudents() throws IOException{
			int count = Select.findStudents().size();
			ArrayList<User> users = Select.findStudents();
			String response = "";
			
			for(int i=0; i<count; ++i){
				response += setStudents(users.get(i));
			}
			
			return response;
		}
}
