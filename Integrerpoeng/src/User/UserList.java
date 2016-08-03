package User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Observable;
import java.util.Observer;

import Points.UserPointTransactions;
import Print.FormatStringList;
/* List of all Users
 * 
 */
public class UserList implements Observer {
	
	private ArrayList<RealUser> userList;
	private FormatStringList highscore;
	
	public UserList(){
		this.userList = new ArrayList<RealUser>();
		this.highscore = new FormatStringList();
	}
	public void addUsers(RealUser user){
		userList.add(user);
	}
	
	//find user by name
	public User getUser(String name){

			for(RealUser u: userList){
				if(u.getName().equalsIgnoreCase(name)){
					return u;
				}
			}
		//using null pattern to return null user if name not avaliable
		return new NullUser();
		
	}
	
	//Observes if there are any transactions, and if so, notifies highscore
	@Override
	public void update(Observable pointTransaction, Object user) {
			if(pointTransaction instanceof UserPointTransactions){
				UserPointTransactions tr = (UserPointTransactions)pointTransaction;
				System.out.print("Transaction of: " + tr.getTransactionAmount()+" points | Reason: "+ tr.getTransactionDescription());

				}
			if(user instanceof RealUser){
				User usr = (RealUser)user;
				System.out.println(" | User: "+usr.getName()+" | Total: "+ usr.getPoints().getTotalPoints()+" points.");
				}
	}
	
	public ArrayList<RealUser> getList(){
		return this.userList;
	}
	public void showPointHistory(String s){
		getUser(s).getPoints().getPointHistory().showRecords(s);
	}
	
}

