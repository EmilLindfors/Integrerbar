package User;

import System.UserOperations;

/**
 * Extension of @See System.AddUser for the User Module
 * @author Emil
 *
 */

public interface AddUserToUser extends UserOperations {
	
	/**
	 * Add a CSV String of user:
	 * @param user s[0] = name +","+ s[1] = birth date +"," s[2] = Organisation + ","+ s[3] = roleInOrganisation
	 * 
	 */
	abstract void addUser(String user);
}
