package Semester;

import java.time.LocalDate;

import Day.Day;
import Day.DayList;
import Points.UserPointTransactions;
import User.ImportUser;
import User.RealUser;
import User.UserList;

/*
 * Main container and keeps track of users, etc.
 */
public class Semester {
	
	//start and end of semester (approximately - can change)
	private LocalDate startDate;
	private LocalDate endDate;
	
	
	//create a new userList to store all the users and user points
	private final UserList userList;
	private final UserPointTransactions userPoints;
	
	//amount of days users should work suring this semester
	private final DayList listOfDays;
	private int minDaysWork;
	
	public Semester(String s){
		String[] string = s.split(" ");
		if(!string[1].startsWith("20")&&string[0].length()!=4){
			System.out.println("wrong year format: YYYY");
		} else{
		
			if(string[0].equalsIgnoreCase("fall")){
				
				startDate = LocalDate.of(Integer.parseInt(string[1]), 8, 10);
				endDate = LocalDate.of(Integer.parseInt(string[1]), 12, 20);
				this.minDaysWork = 4;
			} else if(string[0].equalsIgnoreCase("spring")){
				startDate = LocalDate.of(Integer.parseInt(string[1]), 1, 1);
				endDate = LocalDate.of(Integer.parseInt(string[1]), 6, 20);
				this.minDaysWork = 5;
			} else {
				System.out.println("wrong semster format: fall/spring YYYY");
			}
			
		}
		this.userList = new UserList();
		this.userPoints = new UserPointTransactions(userList);
		this.listOfDays = new DayList();

	}
	//users
	public void importUsers(String location){
		new ImportUser(location, this.userList);
	}
	public void addUser(String name, String role, int earned, int spent){
		userList.addUsers(new RealUser(name, role, earned, spent, this.userList));
	}
	public UserList getUserList(){
		return this.userList;
	}
	
	//points
	public void addPointsToUserNow(int amount, String s, String description){
		userPoints.earnPointsNow(amount, userList.getUser(s), description);
	}
	public void addPointsToUserAtDate(int amount, String s, LocalDate date, String description){
		userPoints.earnPointsAtDate(amount, userList.getUser(s),date, description);
	}
	public void usePointsFromUserNow(int amount, String s, String description){
		userPoints.usePointsNow(amount, userList.getUser(s), description);
	}
	public void usePointsFromUserAtDate(int amount, String s, LocalDate date, String description){
		userPoints.usePointsAtDate(amount, userList.getUser(s),date, description);
	}
	public void showPointHistory(String s){
		userList.showPointHistory(s);
	}
	
	//highscores
	public void showTotalHighscore(){
		userList.showHighscore();
	}
	public void showHighscoreForRole(String role){
		userList.showHighscoreForRole(role);
	}
	public void showSemesterHighscore(){
		userList.showHighscoreForPeriod(startDate, endDate);
	}
	
	//days
	public void addDay(Day d){
		//check if the day is actually in this semester
		if(d.getDate().isAfter(startDate)&& d.getDate().isBefore(endDate)){
			this.listOfDays.addDay(d);
		} else {
			System.out.println("Date of this day is not in this semester");
		}
	}
	


}
