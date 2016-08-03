package Print;

import java.time.LocalDate;
import java.util.ArrayList;

import User.RealUser;
import User.UserSortEnums;
import User.UserList;

public class PrintToConsole {

	
	public static void printUserArrayList(UserList userList){
		
		String[] values = {"name","total earned points","total used points"};
		
		ArrayList<String> stringList = UserArrayToCSV.AllFields(userList, true, UserSortEnums.ROLE);
		new FormatStringList().toConsoleFormat(stringList, "User List");
	}
	
	public static void printHighscoreForAll(ArrayList<RealUser> list){
		
		String[] values = {"name","total earned points"};
		
		ArrayList<String> stringList = new HighscoreArrayToCSV(list).formatAll(values);
		new FormatStringList().toConsoleFormat(stringList, "Highscore for All Users");
	}
	
	public static void printHighscoreForRole(ArrayList<RealUser> list, String role){
		
		String[] values = {"name","total earned points"};
		
		ArrayList<String> stringList = new HighscoreArrayToCSV(list).formatRole(role);
		new FormatStringList().toConsoleFormat(stringList, "Highscore for "+role);
		
		
	}
	
	public static void printHighscoreForPeriod(ArrayList<RealUser> list, LocalDate startDate, LocalDate endDate){
		
		String[] values = {"name","total earned points"};
		
		ArrayList<String> stringList = new HighscoreArrayToCSV(list).formatPeriod(startDate, endDate);
		new FormatStringList().toConsoleFormat(stringList, "Highscores "+startDate.toString()+" to "+endDate.toString());
		
		
	}
	

}
