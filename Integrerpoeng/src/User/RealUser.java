package User;

import Badges.Badges;
import Points.Points;

public class RealUser implements User, Comparable<RealUser> {
	private final Points points;
	private final Badges badges;
	private String name;
	private UserRoleEnums role;
	
	//constructors
	public RealUser(String n, String r, UserList userList){
		setName(n);
		this.points = new Points(0,0);
		this.badges = new Badges();
		setRole(r);
	}
	public RealUser(String n, String r, int earnedPoints, int usedPoints, UserList userList){
		setName(n);
		this.points = new Points(earnedPoints,usedPoints);
		this.badges = new Badges();
		setRole(r);
		
	}
	public void setRole(String s){
		String r = s.toLowerCase();
		switch(r){
		case "inactive":
			role = UserRoleEnums.INACTIVE;
			break;
		case "volunteer":
			role = UserRoleEnums.VOLUNTEER;
			break;
		case "supervisor":
			role = UserRoleEnums.SUPERVISOR;
			break;
		case "board":
			role = UserRoleEnums.BOARD;
			break;
		case "admin":
			role = UserRoleEnums.ADMINISTRATION;
			break;
		default:
			role = UserRoleEnums.INACTIVE;
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
	public int getTotalPoints() {
		return points.getTotalPoints();
	}
	public int getUsedPoints() {
		return points.getUsedPoints();
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
	@Override
	public int compareTo(RealUser u) {
		//Sorts in descending order, used for highscores
		return u.getPoints().getTotalPoints() - getPoints().getTotalPoints();
	}
	@Override
	public String toString(){
		return "Name: "+this.getName()+","+this.getPoints().toString()+",Role:"+this.getRole().toString();
	}
	
	
}
