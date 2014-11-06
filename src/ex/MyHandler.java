package ex;

import java.io.*;
import java.net.URI;
import java.util.Vector;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class MyHandler implements HttpHandler {
		
	public void handle(HttpExchange t) throws IOException {
		URI uri = t.getRequestURI();
    	String path = uri.toString();
        String response = new String();    
               
        
        String templ = Read.readFromFile("fas.txt");
        response=templ.replace("%content%", "");
        
        if(path.equals("/updating")){
     	   Vector<String> data = Read.readUserInput(t);
     	   Select.updateUser(data.get(1), data.get(3), data.get(5), data.get(7));
     	   response = templ.replace("%content%",Table.viewForUpdating(data.get(1),data.get(3),data.get(5),data.get(7)));
     	  
	    }else if(path.equals("/update.html")){
	    	String newContent = Read.readFromFile("update.html");
	    	response = templ.replace("%content%", newContent+"\n");
     
	    }    else if(path.equals("/registration.html")){
        	   String newContent = Read.readFromFile("registration.html");
     	   response = templ.replace("%content%", newContent);
     	   
        }
        else if(path.equals("/registration")){
        	Vector<String> data = Read.readUserInput(t);
      	   DB.insertUser(data.get(1), data.get(3),data.get(5));
        }
        else if(path.equals("/delete.html")){
        	String newContent = Read.readFromFile("delete.html");
        	response = templ.replace("%content%", newContent+"\n");
        }	
        else if(path.equals("/deleting")){
     	   Vector<String> data = Read.readUserInput(t);
     	   Select.deleteUser(data.get(1));
     	   response = templ.replace("%content%",Table.viewForDeleting(data.get(1)));
       }
        else if(path.equals("/findId.html")){
        	String newContent = Read.readFromFile("findId.html");
        	response = templ.replace("%content%", newContent+"\n");
        }
        /*else if(path.equals("/findId")){
      	   Vector<String> data = Read.readUserInput(t);
      	   Select.findById(data.get(1));
      	   response = templ.replace("%content%",Table.viewStudentById(data.get(1)));
        }
        */
        else if(path.equals("/list.html")){
        	
        		response = templ.replace("%content%", Table.listOfStudents());
        		
       
      
        
       }else if(path.equals("/reg")){
        	String newContent = Read.readFromFile("reg.txt");
        	response = templ.replace("%content%", newContent+"\n");
        }
        else if(path.equals("/news")){
        	String text=Read.readFromFile("news1.txt");
        	response=templ.replace("%content%", text+"\n");
        	
        }
        
               
        else if(path.equals("/fas")){
        	response=templ.replace("%content%", "Main Page "+"\n");
        }
        
        else if(!path.equals("/")) {
    		path=path.substring(1);
    		String sub=Read.readFromFile(path);
    		response=templ.replace("%content%", "Null");
        }
        else if(path.equals("/")){
        	response=templ.replace("%content%","Main Page ");
        }
                      
                  
		Headers header = t.getResponseHeaders();	//adding header
		header.add("Content-Type", "text/html; charset=ANSI");
        t.sendResponseHeaders(200, response.length());
        OutputStream os = t.getResponseBody();
        os.write(response.getBytes());
        os.close();
	}	
}