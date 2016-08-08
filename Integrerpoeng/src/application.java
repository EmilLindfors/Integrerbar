
import java.util.ArrayList;

import Day.DayList;

/*
 * The main class of the Integrerbar application
 * @author Emil Lindfors
 */

import Day.RealDay;
import Organisations.Organisation;
import Organisations.OrganisationRoleEnums;
import Organisations.OrganisationSetup;
import Organisations.TypeOfOrganisation;
import Print.FormatStringList;
import Print.UserArrayToCSV;
import System.UserOperations;
import User.RealUser;
import User.UserList;
import User.UserSortEnums;

public class application {
	public static void main(String args[]){
		
		/**
		 * Creates one master UserList to keep track of all users. All Adding and removing is done to this list.
		 * Each semester has its own UserList object that is a copy of the masterList without those who quit before 
		 * and otherwise are inactive.
		 */
		OrganisationSetup OS = OrganisationSetup.getInstance();
		OS.addPossibleRoles(OrganisationRoleEnums.ROLE1);
		OS.addPossibleRoles(OrganisationRoleEnums.ROLE2);
		OS.addPossibleRoles(OrganisationRoleEnums.ROLE7);
		Organisation integrerbar = new Organisation("Integrerbar", "Studentbar på MatNat", TypeOfOrganisation.MAIN);
		Organisation lffh = new Organisation("Linjeforeningen for Fiskehelse og Havbruk", "Fagutvalg ved MatNat", TypeOfOrganisation.PARTNERS);
		
		//creating a user in CSV format
		String user = ("Emil Lindfors,1987.02.20,Integrerbar,leder");
		String user2 = ("Emil Lindfors,1987.02.20,LFFH,leder");
		
		String user3 = ("Sondre Vestad,1901.01.01,Integrerbar, nestleder");
		String user4 = ("Øystein Follo,1901.01.02,Integrerbar,styremedlem");
		String user5 = ("Test,1901.01.02,Integrerbar,medlem");
		String user6 = ("Test2,1901.01.02,Integrerbar,medlem");
		
		String user7 = ("Vegar Heen,1988.06.30,LFFH,nestleder");
		
		
		//using the add user interface
		UserOperations addUser;
		
		addUser = integrerbar;
		addUser.addUser(user);
		addUser.addUser(user3);
		addUser.addUser(user4);
		addUser.addUser(user5);
		addUser.addUser(user6);
		
		addUser = lffh;
		addUser.addUser(user2);
		addUser.addUser(user7);
		
		//get the users of the organisations and printing them
		ArrayList<String> ibList = integrerbar.getList("board");
		ArrayList<String> ibAllList = integrerbar.getList("all");
		FormatStringList.toConsoleFormat(ibList, "Board of Integrerbar");
		FormatStringList.toConsoleFormat(ibAllList, "All members of Integrerbar");
		
		ArrayList<String> lffhAllList = lffh.getList("all");
		FormatStringList.toConsoleFormat(lffhAllList, "All members of Linjeforeningen for Fiskehelse og Havbruk");
		

		

		
		//creates a new day where the bar has been open
		//RealDay day = new RealDay("Åpningsfest","2015-09-17", "19-00");
		//RealDay day2 = new RealDay("Testdag","2015-11-27", "16-03");
		//day.addUser("test", "blabla", "20-24");
		//day2.addUser("test", "supervisor", "16-03");

		//deletes all old points??? should be called by supervisor at end of day.
		//day.processPointsEarned();


		//System.out.println(masterUserList.getUser("test"));
		
		
		//new print, takes a user list, with or without header, and sorted by a sort enum
		//ArrayList<String> list = UserArrayToCSV.withTotalandUsedPoints(masterUserList, true, UserSortEnums.USED_POINTS);
		//ArrayList<String> list2 = UserArrayToCSV.withRole(masterUserList, true, UserSortEnums.ROLE);

		
		RealUser emil = new RealUser("Emil", "Bord", 1000,500,"Integrerbar", OrganisationRoleEnums.ROLE1, "2015-01-04", "2016-01-20");
		System.out.println(emil);
		



	}
}
