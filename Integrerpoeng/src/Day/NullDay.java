package Day;

import java.time.LocalDate;

public class NullDay extends Day {

	@Override
	boolean addUser(String user, String description, String hoursWorked) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	void processPointsEarned() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public
	LocalDate getDate() {
		// TODO Auto-generated method stub
		return null;
	}

}
