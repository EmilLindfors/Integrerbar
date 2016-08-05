package TimePeriod;

import java.time.LocalDate;

import Day.Day;
import Day.DayList;
import Points.UserPointTransactions;
import User.ImportUser;
import User.RealUser;
import User.UserList;

/*
 * Main container and keeps track of most things during a semester.
 * Contains lots of methods to access @see User.RealUser, @see Days.RealDay, @see Points.Points etc.
 */
public class TimePeriod {
	
	//****************** instance variables ****************************
	private String name;
	// start and end of the period
	private LocalDate startDate;
	private LocalDate endDate;

	// goal during time period
	private Goal goal;
	
	//******************** Constructors ***********************************
	
	/*
	 * @param s String supplied to the class to decide year and if spring or fall. Format: "fall/spring YYYY"
	 */
	public TimePeriod(String s, LocalDate start, LocalDate end) {
		this.name = s;
		this.startDate = start;
		this.endDate = end;

	}


}
