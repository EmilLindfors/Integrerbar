package User;

import Points.Points;

public interface User {
	
	public abstract String getName();
	public abstract void addPoints(int n);
	public abstract Points getPoints();
	public abstract String getRole();

}
