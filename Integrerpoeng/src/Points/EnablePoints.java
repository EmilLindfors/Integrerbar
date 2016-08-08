package Points;

import Organisations.OrganisationSetup;
import Organisations.Organisation;
import User.UserList;

/**
 * Singleton pattern to enable/disable the points module
 * and interface to check if module is enabled
 * 
 * @author Emil
 *
 */
public class EnablePoints {

	private static boolean pointsEnabled;

	// Thread-safe due to guarantees about initializers
	private static final EnablePoints instance = new EnablePoints();

	private EnablePoints() {

	}

	public static EnablePoints getInstance() {
		pointsEnabled = true;
		return instance;
	}

	/**
	 * Enables points for an organisation
	 * 
	 * @param org
	 *            the organisation object to enable points for
	 * @return true if managed to enable points for the org
	 */

	public boolean EnablePointsForOrg(Organisation org) {

		// first check if Organisations are actually enabled
		if (OrganisationSetup.checkIfEnabled()) {

			// enables points in the org
			org.setEnablePoints();
			return true;
		}
		return false;

	}

	/**
	 * To be used if organsiations are disabled
	 * 
	 * @param userlist
	 *            the user list object to enable points for
	 * @return true if managed to enable points for the userList
	 */

	public boolean EnablePointsForUsers(UserList userlist) {
		// first check if Organisations are actually disabled
		if (!OrganisationSetup.checkIfEnabled()) {

			// enables points in the userList
			userlist.setEnablePoints();
			return true;
		}
		return false;

	}

	public static boolean checkIfEnabled() {
		return pointsEnabled;
	}

}
