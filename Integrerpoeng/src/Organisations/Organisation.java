package Organisations;

import User.UserList;

public class Organisation {
	
	private String name;
	private String description;
	private TypeOfOrganisation type;
	private boolean enablePoints;
	//needs to change to a more general userlist
	private UserList userList;
	
	//list of coupons issued TODO
	
	/**
	 * Constructor for Orgatisation
	 * @param name name of the orgatisation
	 * @param type is the type of organisation
	 * @param points allow for userPoints for this orgatisation
	 * @param userList should take the master userlist and extract the users tagged with the correct organisations
	 */
	
	public Organisation(String name, TypeOfOrganisation type, boolean points, UserList userList){
		this.name = name;
		this.type = type;
		this.enablePoints = points;
		this.userList = userList;
	}
	
	/**
	 * Enables the use of points for an org
	 */
	
	public void setEnablePoints(){
		this.enablePoints = true;
	}

}
