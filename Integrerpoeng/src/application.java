
import java.time.LocalDate;
import java.util.ArrayList;

import Day.DayList;

/*
 * The main class of the Integrerbar application
 * @author Emil Lindfors
 */

import Day.RealDay;
import InputValidation.ValidateInput;
import Organisations.Organisation;
import Organisations.TypeOfOrganisation;
import Points.UserPointTransactions;
import Print.CSVStringBuilder;
import Print.FormatStringList;
import Print.PrintToConsole;
import Print.UserArrayToCSV;
import Semester.Semester;
import User.RealUser;
import User.UserList;
import User.UserRoleEnums;
import User.UserSortEnums;
import User.UserReportBuilder;
import User.UserReportBuilder.ReportBuilder;

public class application {
	public static void main(String args[]){
		
		/**
		 * Creates one master UserList to keep track of all users. All Adding and removing is done to this list.
		 * Each semester has its own UserList object that is a copy of the masterList without those who quit before 
		 * and otherwise are inactive.
		 */
		UserList masterUserList = new UserList();
		
		//one master DayList to keep track of all the days
		DayList masterDayList = new DayList();
		
		/**
		 * might as fucking well just implement the ability to have many @see Orgatisation
		 */
		Organisation Integrerbar = new Organisation("Integrerbar", TypeOfOrganisation.MAIN, true, masterUserList);
		Organisation Realistutvalget = new Organisation("Realistutvalget", TypeOfOrganisation.PARTNERS, false, masterUserList);
		Organisation LFFH = new Organisation("Linjeforeningen for Fiskehelse og Havbruk", TypeOfOrganisation.PARTNERS, false, masterUserList);
		
		//create a semester either spring or fall + year, should keep track of the days of that period
		Semester H2016 = new Semester("fall 2016");
		
		
		//class to enable transations of userpoints	
		UserPointTransactions userPoints = new UserPointTransactions(masterUserList);
		

		
		//create users by console and import and add to the list in semester
		H2016.importUsers("C:/Users/Emil/git/Integrerbar/Integrerpoeng/src/users.csv");
		H2016.addUser("Test","supervisor",100, 30);
		
		//do some transactions
		H2016.addPointsToUserNow(30,"Emil Lindfors", "For some reason");
		H2016.usePointsFromUserAtDate(20, "Emil Lindfors", LocalDate.of(2016, 2, 20), "Happy birthday!");
		H2016.addPointsToUserAtDate(200, "test", LocalDate.of(2016, 9, 20), "Semester highscore!");
		H2016.addPointsToUserAtDate(20, "Emil Lindfors", LocalDate.of(2016, 10, 20), "Some day");
		
		//show all transactions for a user, and the Highscore
		H2016.showPointHistory("Emil Lindfors");
		
		//creates a new day where the bar has been open
		RealDay day = new RealDay("Åpningsfest","2015-09-17", "19-00", H2016.getUserList());
		RealDay day2 = new RealDay("Testdag","2015-11-27", "16-03", H2016.getUserList());
		day.addUser("test", "blabla", "20-24");
		day2.addUser("test", "supervisor", "16-03");

		//deletes all old points??? should be called by supervisor at end of day.
			day.processPointsEarned();
			day2.processPointsEarned();

		System.out.println(H2016.getUserList().getUser("test"));
		
		
		//new print, takes a user list, with or without header, and sorted by a sort enum
		ArrayList<String> list = UserArrayToCSV.withTotalandUsedPoints(H2016.getUserList(), true, UserSortEnums.USED_POINTS);
		ArrayList<String> list2 = UserArrayToCSV.withRole(H2016.getUserList(), true, UserSortEnums.ROLE);
		FormatStringList.toConsoleFormat(list, "Test ");
		FormatStringList.toConsoleFormat(list2, "Roles");
		
		System.out.println(ValidateInput.validateDate("1987-2-20"));
		


	}
}
