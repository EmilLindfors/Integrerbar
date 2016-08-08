package Organisations;

import java.util.ArrayList;

public class OrganisationSetup {
	
	// the roles of the people in the organisation, leader etc.
	private static ArrayList<OrganisationRoleEnums> organisationRoles;
	
	//the types of organisations
	private static ArrayList<TypeOfOrganisation> organisationTypes;

	private static boolean orgEnabled;

	// Thread-safe due to guarantees about initializers
	private static final OrganisationSetup instance = new OrganisationSetup();

	private OrganisationSetup() {
		this.organisationRoles = new ArrayList<OrganisationRoleEnums>();
	}

	public static OrganisationSetup getInstance() {
		orgEnabled = true;
		return instance;
	}

	public static boolean checkIfEnabled() {
		return orgEnabled;
	}

	public void addPossibleRoles(OrganisationRoleEnums role) {
		organisationRoles.add(role);
	}
}
