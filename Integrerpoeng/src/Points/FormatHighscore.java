package Points;

import java.util.ArrayList;
import java.util.Collections;

import User.RealUser;

public class FormatHighscore  {
	
	public void toConsoleFormat(ArrayList<String> list, String type){
		
		//********** create header ***************
		int WidthOfOutput = 50;
		int headerCharCount = 13 + type.length();
		String header = "";
		for(int i=0;i<(WidthOfOutput-headerCharCount)/2;i++){
			header +="*";
		}
			header += "Highscores - "+type;
			
		for(int i=0;i<(WidthOfOutput-headerCharCount)/2;i++){
			header +="*";
		}
		System.out.println(header);
		
		//*********** print the list itself ********
		for(String s: list){
			String[] format = s.split(",");
			System.out.printf("%-30s %s\n",format[0],format[1]);
		}
		
		//******create the footer **********************
		String footer = "";
		for(int i=0;i<header.length();i++){
			footer +="*";
		}
		System.out.println(footer);

	}

}
