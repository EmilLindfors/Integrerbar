package User;

import Badges.Badges;
import Points.Points;

public class RealUser implements User, Comparable<RealUser> {
	private Points points;
	private String name;
	private Badges badges;
	private Roles role;
	
	//constructors
	public RealUser(String n, String r, UserList userList){
		setName(n);
		setPoints(new Points(0,0));
		setRole(r);
	}
	public RealUser(String n, String r, int earnedPoints, int usedPoints, UserList userList){
		setName(n);
		setPoints(new Points(earnedPoints,usedPoints));
		setRole(r);
		
	}
	public void setRole(String s){
		String r = s.toLowerCase();
		switch(r){
		case "inactive":
			role = Roles.INACTIVE;
			break;
		case "volunteer":
			role = Roles.VOLUNTEER;
			break;
		case "supervisor":
			role = Roles.SUPERVISOR;
			break;
		case "board":
			role = Roles.BOARD;
			break;
		case "admin":
			role = Roles.ADMINISTRATION;
			break;
		default:
			role = Roles.INACTIVE;
			System.out.println("Could not find: "+r+". user role set to inactive");
			break;
		}
	}
	public String getRole(){
		return role.toString();
	}
	@Override
	public void addPoints(int pts){
		getPoints().earnPoints(pts);
	}
	
	public Points getPoints() {
		return points;
	}
	public void setPoints(Points pts) {
		this.points = pts;
	}
	@Override
	public String getName() {
		return name;
	}
	@Override
	public boolean isNil(){
		return false;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Badges getBadges() {
		return badges;
	}
	public void setBadges(Badges badges) {
		this.badges = badges;
	}
	@Override
	public int compareTo(RealUser u) {
		//Sorts in descending order, used for highscores
		return u.getPoints().getTotalPoints() - getPoints().getTotalPoints();
	}
	
	
}
