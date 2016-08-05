package User;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import com.opencsv.CSVReader;

public class ImportUser {
	
	public ImportUser(String file){
	
		InputStream in = this.getClass().getClassLoader().getResourceAsStream(file);
	    
	    try {
	        CSVReader reader = new CSVReader(new InputStreamReader(in), ',');
	        
	        List<String[]> rows = reader.readAll();
	        for (int x=0; x < rows.size(); x ++) {
	            
	            String[] columns = rows.get(x);
	            for (int y=0; y < columns.length; y++) {
	                System.out.println(y);
	            }
	        }
	        
	    } catch (FileNotFoundException e) {

	    } catch (IOException e) {

	    }
		
	}
}
