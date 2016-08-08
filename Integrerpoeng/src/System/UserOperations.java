package System;

/**
 * Main Add user interface - can be extended by modules
 * @author Emil
 *
 */

public interface UserOperations {
	/**
	 * Add a CSV String of user:
	 * @param user s[0] = name +","+ s[1] = birth date +"," s[2] = Organisation name + ","+ s[3] = roleInOrganisation
	 * 
	 */
	abstract void addUser(String user);
	abstract String getUser(String name);
	abstract String updateUser(String name);
	abstract String deleteUser(String name);

}
