package Print;

import java.time.LocalDate;
import java.util.ArrayList;

import User.RealUser;

public class PrintToConsole {

	
	public static void printUserArrayList(ArrayList<RealUser> list){
		
		String[] values = {"name","total earned points","total used points"};
		
		ArrayList<String> stringList = new UserArrayToCSV().formatToStringList(list, values);
		new FormatStringList().toConsoleFormat(stringList, "User List", values);
	}
	
	public static void printHighscoreForAll(ArrayList<RealUser> list){
		
		String[] values = {"name","total earned points"};
		
		ArrayList<String> stringList = new HighscoreArrayToCSV(list).formatAll(values);
		new FormatStringList().toConsoleFormat(stringList, "Highscore for All Users", values);
	}
	
	public static void printHighscoreForRole(ArrayList<RealUser> list, String role){
		
		String[] values = {"name","total earned points"};
		
		ArrayList<String> stringList = new HighscoreArrayToCSV(list).formatRole(role);
		new FormatStringList().toConsoleFormat(stringList, "Highscore for "+role, values);
		
		
	}
	
	public static void printHighscoreForPeriod(ArrayList<RealUser> list, LocalDate startDate, LocalDate endDate){
		
		String[] values = {"name","total earned points"};
		
		ArrayList<String> stringList = new HighscoreArrayToCSV(list).formatPeriod(startDate, endDate);
		new FormatStringList().toConsoleFormat(stringList, "Highscores "+startDate.toString()+" to "+endDate.toString(), values);
		
		
	}
	

}
