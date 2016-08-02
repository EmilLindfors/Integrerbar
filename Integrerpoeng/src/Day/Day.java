package Day;

import java.time.LocalDate;

public abstract class Day {
	abstract boolean addUser(String user, String description, String hoursWorked);
	abstract void processPointsEarned();
	public abstract LocalDate getDate();
}
