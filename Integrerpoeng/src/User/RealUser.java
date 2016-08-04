package User;

import java.time.LocalDate;

import Badges.Badges;
import Points.Points;

public class RealUser implements User, Comparable<RealUser> {
	
	//stores an obejct whith the users badges
	private final Points points;
	
	//stores an obejct whith the users badges
	private final Badges badges;
	
	//Full name of the user
	private String fullName;
	
	//enum list of possible roles the user can have
	private UserRoleEnums role;
	
	//lists of organisations
	private final ListOfPartOfOrganisations orgs;
	
	//**************** Constructors ******************************
	
	// with 0 points
	public RealUser(String n, String r, UserList userList){
		setName(n);
		this.orgs = new ListOfPartOfOrganisations();
		this.points = new Points(0,0);
		this.badges = new Badges();
		setRole(r);
	}
	
	// with an intial amount of points for total points and used points
	public RealUser(String n, String r, int earnedPoints, int usedPoints, UserList userList){
		setName(n);
		this.orgs = new ListOfPartOfOrganisations();
		this.points = new Points(earnedPoints,usedPoints);
		this.badges = new Badges();
		setRole(r);	
	}
	// with an intial amount of points for total points and used points and start date
	public RealUser(String n, String r, int earnedPoints, int usedPoints, UserList userList, String Organisation, String startDate){
		setName(n);
		this.orgs = new ListOfPartOfOrganisations();
		this.points = new Points(earnedPoints,usedPoints);
		this.badges = new Badges();
		setRole(r);	
	}
	
	//******************* Setters ******************************
	
	//sets the role of the user from a string
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
	
	public void setName(String name) {
		this.fullName = name;
	}

	public void addPoints(int pts){
		getPoints().earnPoints(pts);
	}
	
	//*************** getters**********************************
	
	public String getRole(){
		return role.toString();
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
	public String getName() {
		return fullName;
	}
	public Badges getBadges() {
		return badges;
	}
	
	//*************** other methods ****************************
	
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
