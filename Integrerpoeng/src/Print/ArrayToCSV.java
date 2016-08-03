package Print;

import java.util.ArrayList;

/*
 * Interface to transform lists of objects to CSV format
 */
public interface ArrayToCSV {
	
	/*
	 * Format an array of ojects into a String list
	 * @param list List of obejcts to format
	 * @param list of fields to take into account
	 */
	
	abstract ArrayList<String> formatToStringList(ArrayList<? extends Object> list, String[] fields);

}
