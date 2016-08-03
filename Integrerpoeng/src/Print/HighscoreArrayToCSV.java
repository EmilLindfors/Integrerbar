package Print;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

import User.RealUser;

public class HighscoreArrayToCSV {
	
	ArrayList<RealUser> userList;
	
	public HighscoreArrayToCSV(ArrayList<RealUser> userList){
		this.userList = userList;
		Collections.sort(userList);
	}

	public ArrayList<String> formatAll(String[] fields) {
		
		ArrayList<String> formattedList = new ArrayList<String>();

			for (RealUser u : this.userList) {
				formattedList.add(u.getPoints().getTotalPoints() + "," + u.getName());

		} 
			
		return SwitchList(formattedList, ",");

	}
	
	public ArrayList<String> formatRole(String role) {
		
		ArrayList<String> formattedList = new ArrayList<String>();
		
		for (RealUser u : this.userList) {
			if (u.getRole().toString().equalsIgnoreCase(role)) {
				formattedList.add(u.getPoints().getTotalPoints() + "," + u.getName());
			}
		}

		return SwitchList(formattedList,",");	
	}
	
	public ArrayList<String> formatPeriod(LocalDate startDate, LocalDate endDate){
		
		ArrayList<String> formattedList = new ArrayList<String>();
		
		for(RealUser u: this.userList){
			int sumDuringPeriod = u.getPoints().getPointHistory().getPointsInPeriod(startDate, endDate);
			formattedList.add(sumDuringPeriod+","+u.getName());
		}
		

		return SwitchList(formattedList,",");
	}
	

	// switches a @param list with two substrings separated by @param splitChar
	private ArrayList<String> SwitchList(ArrayList<String> list, String splitChar) {
		ArrayList<String> switchedList = new ArrayList<String>();
		for (String s : list) {
			String[] format = s.split(",");
			switchedList.add(format[1] + splitChar + format[0]);
		}
		return switchedList;
	}

}
