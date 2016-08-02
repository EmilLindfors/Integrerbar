package User;

import Points.Points;

/*
 * Null user, does not return anything
 */

public class NullUser implements User {

	@Override
	public boolean isNil() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public String getName() {
		System.out.println("Did not find user by that name");
		return "null user";
	}

	@Override
	public void addPoints(int n) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Points getPoints() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public String getRole() {
		// TODO Auto-generated method stub
		return null;
	}

}
