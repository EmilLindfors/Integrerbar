package Print;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import User.RealUser;
import User.UserSortEnums;
import User.UserList;
import User.UserReportBuilder;
import User.UserReportBuilder.ReportBuilder;

public class UserArrayToCSV {
	
	/*
	 * Takes a userList and prints formatted lists, either with headers or without
	 * Used points need to be reversed because total points is already set as standard sort by reversed order
	 */

	public static ArrayList<String> AllFields(UserList list, boolean addHeader, UserSortEnums sorter) {

		ArrayList<String> formattedList = new ArrayList<String>();
		ArrayList<RealUser> usr = list.getList();
		
		if(addHeader){
			formattedList.add("Name,Total Points,Used Points,Role");
		}
		
		if(sorter.equals(sorter.NAME)){
			usr.sort(Comparator.comparing(RealUser::getName));
		} else if(sorter.equals(sorter.USED_POINTS)){
			usr.sort(Comparator.comparing(RealUser::getUsedPoints).reversed().reversed());
		} else if(sorter.equals(sorter.ROLE)) {
			usr.sort(Comparator.comparing(RealUser::getRole));
		} else {
			Collections.sort(usr);
		}
		
		for(RealUser u : usr){

			UserReportBuilder report = new ReportBuilder(list.getUser(u.getName())).withTotalPoints().withUsedPoints().withRole().build();
			formattedList.add((String) report.toString());	
		}
		
		return formattedList;

	}
	
	public static ArrayList<String> withTotalandUsedPoints(UserList list, boolean addHeader, UserSortEnums sorter) {

		ArrayList<String> formattedList = new ArrayList<String>();
		ArrayList<RealUser> usr = list.getList();
		
		if(addHeader){
			formattedList.add("name,Total Points,Used Points");
		}
		
		if(sorter.equals(sorter.NAME)){
			usr.sort(Comparator.comparing(RealUser::getName));
		} else if(sorter.equals(sorter.USED_POINTS)){
			usr.sort(Comparator.comparing(RealUser::getUsedPoints).reversed());
		} else {
		Collections.sort(usr);
		}
		for(RealUser u : usr){
			UserReportBuilder report = new ReportBuilder(list.getUser(u.getName())).withTotalPoints().withUsedPoints().build();
			formattedList.add((String) report.toString());	
		}
		
		return formattedList;

	}
	
	//get list with name and total points with/without header and sorted by either name or totalPoints
	public static ArrayList<String> withTotalPoints(UserList list, boolean addHeader,UserSortEnums sorter) {

		ArrayList<String> formattedList = new ArrayList<String>();
		ArrayList<RealUser> usr = list.getList();
		
		if(addHeader){
			formattedList.add("Name,Total Points");
		}
		if(sorter.equals(sorter.NAME)){
		usr.sort(Comparator.comparing(RealUser::getName));
		} else {
			Collections.sort(usr);
		}
		
		for(RealUser u : usr){
			UserReportBuilder report = new ReportBuilder(list.getUser(u.getName())).withTotalPoints().build();
			formattedList.add((String) report.toString());	
		}
		
		return formattedList;

	}
	
	//get list with name and used points with/without header and sorted by either name or usedPoints
	public static ArrayList<String> withUsedPoints(UserList list, boolean addHeader, UserSortEnums sorter) {

		ArrayList<String> formattedList = new ArrayList<String>();
		ArrayList<RealUser> usr = list.getList();
		
		if(addHeader){
			formattedList.add("Name,Used Points");
		}
		if(sorter.equals(sorter.NAME)){
			usr.sort(Comparator.comparing(RealUser::getName));
		} else {
			usr.sort(Comparator.comparing(RealUser::getUsedPoints));
		}
		
		for(RealUser u : usr){
			UserReportBuilder report = new ReportBuilder(list.getUser(u.getName())).withUsedPoints().build();
			formattedList.add((String) report.toString());	
		}
		
		return formattedList;

	}
	
	//get list with name and role with/without header and sorted by either name or role
	public static ArrayList<String> withRole(UserList list, boolean addHeader, UserSortEnums sorter) {

		ArrayList<String> formattedList = new ArrayList<String>();
		ArrayList<RealUser> usr = list.getList();
		
		if(addHeader){
			formattedList.add("Name,Role");
		}
		
		if(sorter.equals(sorter.NAME)){
			usr.sort(Comparator.comparing(RealUser::getName));
		} else {
			usr.sort(Comparator.comparing(RealUser::getRole));
		}

		
		for(RealUser u : usr){
			UserReportBuilder report = new ReportBuilder(list.getUser(u.getName())).withRole().build();
			formattedList.add((String) report.toString());	
		}
		
		return formattedList;

	}

}
