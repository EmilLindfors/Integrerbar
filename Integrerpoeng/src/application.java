
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
import Shift.ImportShift;
import Shift.Shift;
import System.Import;
import TimePeriod.TimePeriod;
import User.ImportUser;
import User.OrganisationRoleEnums;
import User.RealUser;
import User.User;
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
		

		
		//creates a new day where the bar has been open
		RealDay day = new RealDay("Åpningsfest","2015-09-17", "19-00", masterUserList);
		RealDay day2 = new RealDay("Testdag","2015-11-27", "16-03", masterUserList);
		day.addUser("test", "blabla", "20-24");
		day2.addUser("test", "supervisor", "16-03");

		//deletes all old points??? should be called by supervisor at end of day.
			day.processPointsEarned();
			day2.processPointsEarned();

		System.out.println(masterUserList.getUser("test"));
		
		
		//new print, takes a user list, with or without header, and sorted by a sort enum
		ArrayList<String> list = UserArrayToCSV.withTotalandUsedPoints(masterUserList, true, UserSortEnums.USED_POINTS);
		ArrayList<String> list2 = UserArrayToCSV.withRole(masterUserList, true, UserSortEnums.ROLE);
		FormatStringList.toConsoleFormat(list, "Test ");
		FormatStringList.toConsoleFormat(list2, "Roles");
		
		RealUser emil = new RealUser("Emil", "Bord", 1000,500,"Integrerbar", OrganisationRoleEnums.LEADER, "2015-01-04", "2016-01-20");
		System.out.println(emil);
		
		ImportShift shiftImport = new ImportShift();
		
		ImportUser imp = new ImportUser("C:/Users/Emil/git/Integrerbar/Integrerpoeng/src/dager.csv");

		//ArrayList<String> importedList = shiftImport.ImportFile("C:/Users/Emil/git/Integrerbar/Integrerpoeng/src/dager.csv");
		//ArrayList<Shift>  list5 = shiftImport.turnListToShiftObjects(importedList);
		//FormatStringList.toConsoleFormat(importedList, "Day imports");


	}
}
