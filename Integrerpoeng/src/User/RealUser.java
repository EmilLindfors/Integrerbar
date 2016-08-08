package User;

import java.time.LocalDate;

import Badges.Badges;
import Organisations.OrganisationRoleEnums;
import Points.Points;

public class RealUser implements User, Comparable<RealUser> {
	
	//stores an obejct whith the users badges
	private final Points points;
	
	//stores an obejct whith the users badges
	private final Badges badges;
	
	//These need to be remodeled
	private String fullName;
	private String birthDate;
	private String org;
	private String roleInOrg;
	
	
	//enum list of possible roles the user can have
	private UserRoleEnums role;
	
	//lists of organisations
	private final ListOfPartOfOrganisations orgs;
	
	//**************** Constructors ******************************
	
	/**
	 *  RealUser with 0 points
	 * @param n name of the user
	 * @param r String with role of user @see UserRoleEnums
	 */
	public RealUser(String n, String r){
		setName(n);
		this.orgs = new ListOfPartOfOrganisations();
		this.points = new Points(0,0);
		this.badges = new Badges();
		setRole(r);
	}
	//constructor used by the add user interface
	public RealUser(String name, String birth, String org, String roleInOrg){
		this.fullName = name;
		this.birthDate = birth;
		this.org = org;
		this.roleInOrg = roleInOrg;
		this.orgs = new ListOfPartOfOrganisations();
		this.points = new Points(0,0);
		this.badges = new Badges();
		
	}
	
	/**
	 * RealUser with a starting amount of points
	 * @param n String name of user
	 * @param r String role of user
	 * @param earnedPoints int total earned points
	 * @param usedPoints int total used points
	 */
	public RealUser(String n, String r, int earnedPoints, int usedPoints){
		setName(n);
		this.orgs = new ListOfPartOfOrganisations();
		this.points = new Points(earnedPoints,usedPoints);
		this.badges = new Badges();
		setRole(r);	
	}

	/**
	 * RealUser with starting amount of points and an organisation
	 * @param n String name of user
	 * @param r String role of user
	 * @param earnedPoints int total earned points
	 * @param usedPoints int total used points
	 * @param organisation name of the organisation
	 * @param orgRole @see OrganisationRoleEnums
	 * @param startDate string YYYY-MM-DD
	 * @param endDate string YYYY-MM-DD
	 */
	public RealUser(String n, String r, int earnedPoints, int usedPoints, String organisation, OrganisationRoleEnums orgRole, String startDate, String endDate){
		setName(n);
		this.orgs = new ListOfPartOfOrganisations();
		this.points = new Points(earnedPoints,usedPoints);
		this.badges = new Badges();
		setRole(r);	
		orgs.SetOrgByNameRoleStartEnd(organisation, orgRole, startDate, endDate);
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
	public ListOfPartOfOrganisations getOrganisation(){
		return orgs;
	}
	
	//*************** other methods ****************************
	
	@Override
	public int compareTo(RealUser u) {
		//Sorts in descending order, used for highscores
		return u.getPoints().getTotalPoints() - getPoints().getTotalPoints();
	}
	@Override
	public String toString(){
		return "Name: "+this.getName()+","+this.getPoints().toString()+",Role:"+this.getRole().toString()+this.getOrganisation().toString();
	}

	
	
}
