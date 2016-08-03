package Print;

import java.util.ArrayList;
import java.util.Comparator;
import User.RealUser;
import User.UserList;
import User.UserReportBuilder;
import User.UserReportBuilder.ReportBuilder;

public class UserArrayToCSV {
	
	/*
	 * Takes a userList and prints formatted lists, either with headers or without
	 */

	public static ArrayList<String> AllFields(UserList list, boolean addHeader) {

		ArrayList<String> formattedList = new ArrayList<String>();
		ArrayList<RealUser> usr = list.getList();
		
		if(addHeader){
			formattedList.add("Name,Total Points,Used Points,Role");
		}
		
		for(RealUser u : usr){

			UserReportBuilder report = new ReportBuilder(list.getUser(u.getName())).withTotalPoints().withUsedPoints().withRole().build();
			formattedList.add((String) report.toString());	
		}
		
		return formattedList;

	}
	
	public static ArrayList<String> withTotalandUsedPoints(UserList list, boolean addHeader) {

		ArrayList<String> formattedList = new ArrayList<String>();
		ArrayList<RealUser> usr = list.getList();
		
		if(addHeader){
			formattedList.add("name,Total Points,Used Points");
		}
		
		for(RealUser u : usr){
			UserReportBuilder report = new ReportBuilder(list.getUser(u.getName())).withTotalPoints().withUsedPoints().build();
			formattedList.add((String) report.toString());	
		}
		
		return formattedList;

	}
	
	public static ArrayList<String> withTotalPoints(UserList list, boolean addHeader) {

		ArrayList<String> formattedList = new ArrayList<String>();
		ArrayList<RealUser> usr = list.getList();
		
		if(addHeader){
			formattedList.add("Name,Total Points");
		}
		
		for(RealUser u : usr){
			UserReportBuilder report = new ReportBuilder(list.getUser(u.getName())).withTotalPoints().build();
			formattedList.add((String) report.toString());	
		}
		
		return formattedList;

	}
	
	public static ArrayList<String> withUsedPoints(UserList list, boolean addHeader) {

		ArrayList<String> formattedList = new ArrayList<String>();
		ArrayList<RealUser> usr = list.getList();
		
		if(addHeader){
			formattedList.add("Name,Used Points");
		}
		
		for(RealUser u : usr){
			UserReportBuilder report = new ReportBuilder(list.getUser(u.getName())).withUsedPoints().build();
			formattedList.add((String) report.toString());	
		}
		
		return formattedList;

	}
	
	public static ArrayList<String> withRole(UserList list, boolean addHeader) {

		ArrayList<String> formattedList = new ArrayList<String>();
		ArrayList<RealUser> usr = list.getList();
		
		if(addHeader){
			formattedList.add("Name,Role");
		}
		
		for(RealUser u : usr){
			UserReportBuilder report = new ReportBuilder(list.getUser(u.getName())).withRole().build();
			formattedList.add((String) report.toString());	
		}
		
		return formattedList;

	}

}
