package Print;

import java.util.ArrayList;
import java.util.Collections;

import User.RealUser;

public class FormatStringList  {
	
	public void toConsoleFormat(ArrayList<String> list, String type, String[] values){
		
		//********** create header ***************
		
		//width is taken depending on how many columns, aka list item length
		int WidthOfOutput = values.length*25;
		int headerCharCount = type.length();
		String header = "";
		for(int i=0;i<(WidthOfOutput-headerCharCount)/2;i++){
			header +="*";
		}
			header += type;
			
		for(int i=0;i<(WidthOfOutput-headerCharCount)/2;i++){
			header +="*";
		}
		System.out.println(header+"\n");
		
		for(String val:values){
			System.out.printf("%-25s", val);
		}
		System.out.print("\n");
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
