package User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Observable;
import java.util.Observer;

import Points.Highscore;
import Points.UserPointTransactions;
/* List of all Users
 * 
 */
public class UserList implements Observer {
	
	private ArrayList<RealUser> userList;
	private Highscore highscore;
	
	public UserList(){
		this.userList = new ArrayList<RealUser>();
		this.highscore = new Highscore();
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
	public void showHighscore(){
		this.highscore.showHighscore(userList);
	}
	public void showHighscoreForRole(String role){
		ArrayList<RealUser> list = new ArrayList<RealUser>();
		for(RealUser u: this.userList){
			if(u.getRole().toString().equalsIgnoreCase(role)){
			list.add(u);
			}
		}
		this.highscore.showHighscore(list);
	}
	public void showHighscoreForPeriod(LocalDate startDate, LocalDate endDate){
		ArrayList<RealUser> list = new ArrayList<RealUser>();
		System.out.println("****** Highscores ********");
		for(RealUser u: this.userList){
			int sumDuringPeriod = u.getPoints().getPointHistory().getPointsInPeriod(startDate, endDate);
			System.out.printf("%-30s %d\n",u.getName(),sumDuringPeriod);
		}
		Collections.sort(list);
		System.out.println("**************************\n");
		
		
	}
}

