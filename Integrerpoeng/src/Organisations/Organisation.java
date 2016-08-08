package Organisations;

import java.util.ArrayList;

public class Organisation implements AddUserToOrganisation {

	private String name;
	private String description;
	private OrganisationInfo organisationInfo;
	private TypeOfOrganisation type;
	private boolean enablePoints;
	// only name and role of board users
	private ArrayList<String> board;

	// all added to this list with all their info
	private ArrayList<String> members;

	// list of coupons issued TODO

	/**
	 * Constructor for Orgatisation
	 * 
	 * @param name
	 *            name of the orgatisation
	 * @param type
	 *            is the type of organisation
	 * @param points
	 *            allow for userPoints for this orgatisation
	 * @param userList
	 *            should take the master userlist and extract the users tagged
	 *            with the correct organisations
	 * @throws InstantiationException
	 */

	public Organisation() {

	}

	public Organisation(String name, String description, TypeOfOrganisation type) {
		this();
		this.name = name;
		this.type = type;
		this.board = new ArrayList<String>();
		this.members = new ArrayList<String>();
		this.organisationInfo = new OrganisationInfo();
	}

	/**
	 * Add a CSV String of user:
	 * @param user s[0] = name +","+ s[1] = birth date +","+ s[2] = role
	 * 
	 */
	
	@Override
	public void addUser(String user) {
		String[] s = user.split(",");
		OrganisationRoleEnums role = OrganisationRoleEnums.ROLE1.checkIfStringEqualsAny(s[3]);
		if (role != null) {

			if (role.equals(OrganisationRoleEnums.ROLE8)) {
				members.add(user);
				System.out.println("Added " + s[0] + " to the " + role.toString() + " of " + this.name);
			} else {
				board.add(user);
				System.out.println("Added " + s[0] + " as the " + role.toString() + " of the board of " + this.name);
			}
		} else {
			System.out.println("Error: "+s[2]+" is not a role defined by OrganisationRoleEnums");
		}

	}

	/**
	 * Enables the use of points for an org
	 */

	public void setEnablePoints() {
		this.enablePoints = true;
	}
	public ArrayList<String> getList(String listName){
		if(listName.equalsIgnoreCase("board")){
			return this.board;
		} else if(listName.equalsIgnoreCase("members")) {
			return this.members;
		} else if(listName.equalsIgnoreCase("all")){
			ArrayList<String> newList = new ArrayList<String>(board);
			newList.addAll(members);
			return newList;
		}else {
			System.out.println("Error: Integrerbar does not contain the list "+listName);
			return null;
		}
	}

}
