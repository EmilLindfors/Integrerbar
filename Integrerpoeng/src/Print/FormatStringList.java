package Print;

import java.util.ArrayList;
import java.util.Collections;

import User.RealUser;

public class FormatStringList  {
	
	/*
	 * Takes an arrayList<String> and formats and prints to console
	 * @param list ArayList<String> with one or more columns
	 * @param headerName the name to be added to the header
	 * @param columnNames name of the columns, should match the string list 
	 */
	
	public static void toConsoleFormat(ArrayList<String> list, String headerName){
		
		
		//********** create header ***************
		
		//width is taken depending on how many columns, aka list item length
		int WidthOfOutput = list.get(0).split(",").length*25;
		int headerCharCount = headerName.length();
		String header = "";
		for(int i=0;i<(WidthOfOutput-headerCharCount)/2;i++){
			header +="*";
		}
			header += headerName;
			
		for(int i=0;i<(WidthOfOutput-headerCharCount)/2;i++){
			header +="*";
		}
		System.out.println(header+"\n");
		
		//*********** print the list itself ********
		for(String s: list){
			String[] format = s.split(",");
			
				for(String str: format){
					System.out.printf("%-30s", str);
				}
				System.out.print("\n");
		}
		
		//******create the footer **********************
		String footer = "";
		for(int i=0;i<header.length();i++){
			footer +="*";
		}
		System.out.println(footer);

	}

}
