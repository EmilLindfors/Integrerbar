package Semester;

import java.time.LocalDate;

import Day.Day;
import Day.DayList;
import Points.PointHighscore;
import Points.UserPointTransactions;
import User.ImportUser;
import User.RealUser;
import User.UserList;

/*
 * Main container and keeps track of most things during a semester.
 * Contains lots of methods to access @see User.RealUser, @see Days.RealDay, @see Points.Points etc.
 */
public class Semester {
	
	//****************** instance variables ****************************

	// start and end of semester (approximately - can change)
	private LocalDate startDate;
	private LocalDate endDate;

	// create a new userList to store all the users and user points
	private final UserList userList;
	private final UserPointTransactions userPoints;
	
	//highscore calculations
	private final PointHighscore highscore;

	// amount of days users should work during this semester
	private final DayList listOfDays;
	// amount of days users should work during this semester
	private int minDaysWork;
	
	//******************** Constructors ***********************************
	
	/*
	 * @param s String supplied to the class to decide year and if spring or fall. Format: "fall/spring YYYY"
	 */
	public Semester(String s) {
		String[] string = s.split(" ");
		if (!string[1].startsWith("20") && string[0].length() != 4) {
			System.out.println("wrong year format: YYYY");
		} else {

			if (string[0].equalsIgnoreCase("fall")) {

				startDate = LocalDate.of(Integer.parseInt(string[1]), 8, 10);
				endDate = LocalDate.of(Integer.parseInt(string[1]), 12, 20);
				this.minDaysWork = 4;
			} else if (string[0].equalsIgnoreCase("spring")) {
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
		this.highscore = new PointHighscore(userList);

	}

	// *********************user methods********************************
	
	/*
	 * Imports users from
	 * @param location Exact location to the csv file to be imported
	 * @see User.ImportUser
	 */
	public void importUsers(String location) {
		new ImportUser(location, this.userList);
	}
	
	/*
	 * Adds new RealUsers through the @see User.UserList#addUsers method
	 * 
	 * @param name - String name of user @See User.User
	 * @param role - String role of user @see User.Roles
	 * @param earned - int of the total points earned at creation of user
	 * @param spent - int of the total points spent at creation of user
	 * 
	 */
	public void addUser(String name, String role, int earned, int spent) {
		userList.addUsers(new RealUser(name, role, earned, spent, this.userList));
	}
	
	/*
	 * @return a UserList object
	 */
	public UserList getUserList() {
		return this.userList;
	}
	

	// ************************ point methods *************************************
	
	/*
	 * Add points to users at the date of today though the same method in @see Points.UserPointTransactions#earnPointsNow
	 * @param amount - int of the amount to add to the user
	 * @param s - String with the name of the user
	 * @param description - String stored to show the description of the transaction
	 */
	public void addPointsToUserNow(int amount, String s, String description) {
		userPoints.earnPointsNow(amount, userList.getUser(s), description);
	}
	
	/*
	 * Add points to users at a certain date though the same method in @see Points.UserPointTransactions#earnPointsAtDate
	 * @param amount - int of the amount to add to the user
	 * @param date - LocalDate of when the transaction occurred
	 * @param s - String with the name of the user
	 * @param description - String stored to show the description of the transaction
	 */
	public void addPointsToUserAtDate(int amount, String s, LocalDate date, String description) {
		userPoints.earnPointsAtDate(amount, userList.getUser(s), date, description);
	}

	/*
	 * Use points from users at the date of today though the same method in @see Points.UserPointTransactions#usePointsNow
	 * @param amount - int of the amount to subtract from the user
	 * @param s - String with the name of the user
	 * @param description - String stored to show the description of the transaction
	 */
	public void usePointsFromUserNow(int amount, String s, String description) {
		userPoints.usePointsNow(amount, userList.getUser(s), description);
	}
	
	/*
	 * Use points from users at a certain date though the same method in @see Points.UserPointTransactions#usePointsAtDate
	 * @param amount - int of the amount to subtract from the user
	 * @param date - LocalDate of when the transaction occurred
	 * @param s - String with the name of the user
	 * @param description - String stored to show the description of the transaction
	 */
	public void usePointsFromUserAtDate(int amount, String s, LocalDate date, String description) {
		userPoints.usePointsAtDate(amount, userList.getUser(s), date, description);
	}
	
	/*
	 * Show the history of transactions for a user
	 * @param s String with the name of the user requested
	 */
	public void showPointHistory(String s) {
		userList.showPointHistory(s);
	}

	// ************************ highscore methods *****************************
	
	/* 
	 * Show the highscore for all users in UserList though the @see Points.PointHighscore
	 */
	public void showTotalHighscore() {
		highscore.showPointHighscoreForAll();
	}
	
	/* 
	 * Show the highscore of all users of a certain @see User.Roles though the @see Points.PointHighscore
	 * @param role String of the role the users have
	 */
	public void showHighscoreForRole(String role) {
		highscore.showPointHighscoreForRole(role);
	}
	
	/* 
	 * Show the highscore of all users for transactions that have occurred between the dates of this semester 
	 * Uses @see Points.PointHighscore with @see Semester.Semester#startDate and Semester.Semester#endDate
	 */
	public void showSemesterHighscore() {
		highscore.showHighscoreForPeriod(startDate, endDate);
	}

	//***************************** day methods **********************************
	
	/*
	 * Adds a day to the Day.DayList object for this semester which holds all days
	 * @param d is the @see Day.day object to add to the semester if its between
	 * @see Semester.Semester#startDate and Semester.Semester#endDate
	 * else it will print a warning to console
	 */
	public void addDay(Day d) {
		// check if the day is actually in this semester
		if (d.getDate().isAfter(startDate) && d.getDate().isBefore(endDate)) {
			this.listOfDays.addDay(d);
		} else {
			System.out.println("Date of this day is not in this semester");
		}
	}

}
