package Points;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import Print.FormatStringList;
import User.RealUser;
import User.UserList;

public class PointHighscore {
	
	private ArrayList<RealUser> userList;
	private FormatStringList format;

	//adds a userlist and sorts it by descending order, as well ass adds a formatter for the output
	public PointHighscore(UserList userList) {
		this.userList = userList.getList();
		Collections.sort(this.userList);
		this.format = new FormatStringList();
	}
	
	
	public void showPointHighscoreForAll(){
		ArrayList<String> list = new ArrayList<String>();
		for (RealUser u : this.userList) {
			list.add(u.getPoints().getTotalPoints()+","+u.getName());
		}

		SwitchList(list,",");
		format.toConsoleFormat(list, "All Users", new String[]{"name","total earned points"});	
	}
	
	public void showPointHighscoreForRole(String role){
		Collections.sort(userList);
		
		ArrayList<String> list = new ArrayList<String>();
		for (RealUser u : this.userList) {
			if (u.getRole().toString().equalsIgnoreCase(role)) {
				list.add(u.getName()+","+ u.getPoints().getTotalPoints());
			}
		}

		SwitchList(list,",");
		format.toConsoleFormat(list, role, new String[]{"name","total earned points"});
	}
	
	public void showHighscoreForPeriod(LocalDate startDate, LocalDate endDate){
		
		ArrayList<String> list = new ArrayList<String>();
		for(RealUser u: this.userList){
			int sumDuringPeriod = u.getPoints().getPointHistory().getPointsInPeriod(startDate, endDate);
			list.add(u.getName()+","+sumDuringPeriod);
		}
		

		SwitchList(list,",");
		format.toConsoleFormat(list, startDate.toString()+" to "+endDate.toString(), new String[]{"name","total earned points"});
		
		
	}
	
	//switches a @param list with two substrings separated by @param splitChar
	private ArrayList<String> SwitchList(ArrayList<String> list, String splitChar){
		ArrayList<String> switchedList = new ArrayList<String>();
			for (String s : list) {
				String[] format = s.split(",");
				switchedList.add(format[1]+splitChar+format[0]);
			}
		return switchedList;
	}

}
