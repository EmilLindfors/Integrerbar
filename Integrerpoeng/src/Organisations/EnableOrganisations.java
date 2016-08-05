package Organisations;

import Points.EnablePoints;

public class EnableOrganisations {
	
	private static boolean orgEnabled;

	// Thread-safe due to guarantees about initializers
	private static final EnableOrganisations instance = new EnableOrganisations();

	private EnableOrganisations() {

	}

	public static EnableOrganisations getInstance() {
		orgEnabled = true;
		return instance;
	}
	
	public static boolean checkIfEnabled(){
		return orgEnabled;
	}

}
