
import java.time.LocalDate;

import Day.RealDay;
import Semester.Semester;

public class application {
	public static void main(String args[]){
		
		//create a semester either spring or fall + year
		Semester H2016 = new Semester("fall 2016");
		
		//create users by console and import and add to the list in semester
		H2016.importUsers("C:/Users/Emil/workspace/Integrerpoeng/src/users.csv");
		H2016.addUser("Test","supervisor",100, 30);
		
		//do some transactions
		H2016.addPointsToUserNow(30,"Emil Lindfors", "For some reason");
		H2016.usePointsFromUserAtDate(20, "Emil Lindfors", LocalDate.of(2016, 2, 20), "Happy birthday!");
		H2016.addPointsToUserAtDate(200, "test", LocalDate.of(2016, 9, 20), "Semester highscore!");
		H2016.addPointsToUserAtDate(20, "Emil Lindfors", LocalDate.of(2016, 10, 20), "Some day");
		
		//show all transactions for a user, and the Highscore
		H2016.showPointHistory("Emil Lindfors");
		H2016.showTotalHighscore();
		
		//creates a new day where the bar has been open
		RealDay day = new RealDay("Åpningsfest","2015-09-17", "19-00", H2016.getUserList());
		RealDay day2 = new RealDay("Testdag","2015-11-27", "16-03", H2016.getUserList());
		day.addUser("test", "blabla", "20-24");
		day2.addUser("test", "supervisor", "16-03");

		//deletes all old points??? should be called by supervisor at end of day.
			day.processPointsEarned();
			day2.processPointsEarned();

		H2016.showPointHistory("test");
		H2016.showHighscoreForRole("volunteer");
		H2016.showHighscoreForRole("board");
		H2016.showSemesterHighscore();
	}
}
