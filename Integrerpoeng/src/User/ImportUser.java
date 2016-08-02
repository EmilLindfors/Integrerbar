package User;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ImportUser {

	public ImportUser(String file, UserList userList){
	
		String line = "";
		
		// The following code uses a try-with-resources statement to open
		// a file and then automatically close it when the try block is left.
		
		 try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			
			 while ((line = br.readLine()) != null) {

	                // use comma as separator
	                String[] user = line.split(",");
	                //creating a new user
	                RealUser usr = new RealUser(user[0],user[1], Integer.parseInt(user[2]), Integer.parseInt(user[3]), userList);
	                //adding the user to the list of all users
	                userList.addUsers(usr);
	                System.out.println("Imported user: "+user[0]+ " with role: "+user[1]+" and starting with: "+user[2]+" "+user[3]+" points.");

	            }
		} catch (IOException e) {
            e.printStackTrace();
            }
		
	}
}
