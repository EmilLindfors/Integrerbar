package Points;

import java.time.LocalDate;
import java.util.Observable;

import User.UserRoleEnums;
import User.User;
import User.UserList;

public class UserPointTransactions extends Observable {
	
	/* Method: usePoints to buy items and log what was bought
	 * and when. Check so that there are enough points. 
	 * Return a boolean if purchase was successful or not.
	 * Assumes that parameters are legal and checked before
	 */
	private int transaction;
	private String description;
	
	
	public UserPointTransactions(UserList userList){
		addObserver(userList);
		this.transaction = 0;
	}
	public boolean usePointsAtDate(int transaction, User user, LocalDate date, String description){
		this.description = description;
		this.transaction = -transaction;
		return usePoints(transaction, user, date, description);
		
		
	}
	public boolean usePointsNow(int transaction, User user, String description){
		this.description = description;
		this.transaction = -transaction;
		return usePoints(transaction, user, LocalDate.now(), description);
	}
	
	private boolean usePoints(int transaction, User user, LocalDate date, String description){
		if(user.getRole().equals(UserRoleEnums.INACTIVE)){
			System.out.println("User: "+user.getName()+" is not active, contact an admin");
			return false;
		}
		//subtract itemWorth from usablePoints and return true
		int itemWorth = transaction;

			if(user.getPoints().getSpendablePoints()>itemWorth){
				user.getPoints().usePoints(transaction);
				user.getPoints().getPointHistory().addRecord(date, -transaction, description);
				setChanged();
				notifyObservers(user);
				return true;
			}
			System.out.println(user.getName()+ " does not have "+ transaction +" points to spend.");
			System.out.println(user.getName()+" has "+user.getPoints().getSpendablePoints()+" spendable points.");
		return false;
		
	}
	public boolean earnPointsAtDate(int transaction, User user, LocalDate date, String description){
		this.description = description;
		this.transaction = transaction;
		return earnPoints(transaction, user, date, description);
		
		
	}
	public boolean earnPointsNow(int transaction, User user, String description){
		this.description = description;
		this.transaction = transaction;
		return earnPoints(transaction, user, LocalDate.now(), description);
	}
	
	public boolean earnPoints(int transaction, User user, LocalDate date, String description){
		if(user.getRole().equals("inactive")){
			System.out.println("User: " +user.getName() +" is not active, contact an admin");
			return false;
		}

		user.getPoints().earnPoints(transaction);

		user.getPoints().getPointHistory().addRecord(date, transaction, description);
		setChanged();
		notifyObservers(user);
		return true;
	}
	public int getTransactionAmount(){
		return this.transaction;
	}
	public String getTransactionDescription(){
		return this.description;
	}
	
}
