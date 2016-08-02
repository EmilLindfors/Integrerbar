package Day;

import java.time.LocalDate;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import Points.UserPointTransactions;
import User.NullUser;
import User.User;
import User.UserList;

public class RealDay extends Day {
	
	private String description;
	private LocalDate date;
	private String openingHours;
	private UserList userList;
	private TreeMap<User, Integer> users;
	private UserPointTransactions pointTransaction;
	
	public RealDay(String desc, String date, String hours, UserList userList){
		
		String[] s = date.split("-");
		if(s.length !=3){
			System.out.println("Wrong date format");
		}
		this.userList = userList;
		this.description = desc;
		this.openingHours = hours;
		this.date = LocalDate.of(Integer.parseInt(s[0]), Integer.parseInt(s[1]), Integer.parseInt(s[2]));	
		this.users = new TreeMap<User, Integer>();
		this.pointTransaction = new UserPointTransactions(userList);
	}
	
	public String toString(){
		
		return this.description + " " + this.date.toString() + " ("+this.openingHours+")";
	}
	
	public boolean addUser(String user, String description, String hoursWorked) {

		if(userList.getUser(user) instanceof NullUser){
			System.out.println("could not find user");
			return false;
		}

		if(description.equalsIgnoreCase("saturday")){
			users.put(userList.getUser(user), (parseHours(hoursWorked)));
			return true;
		}
		if(description.equalsIgnoreCase("supervisor")){
			users.put(userList.getUser(user), (parseHours(hoursWorked) + 4));
			return true;
		} else {
			users.put(userList.getUser(user), (parseHours(hoursWorked)));
			return true;
		}

	}
	//method to first parse the hours worked from the adduser function, then sends to calculatePointsForHours
	private int parseHours(String hours){
		String[] hw = hours.split("-");
		if(hw.length!=2){
			System.out.println("wrong format");
		}
		int start = Integer.parseInt(hw[0]);
		int end = Integer.parseInt(hw[1]);
		
			if(end>=0 && end <=4){
				end = 24 + end;
		}
		//saturdays are 2 pts per hour
		if(date.getDayOfWeek().equals(6)){
			return (end-start) * 2;
		}
		//calculate per hour
		return calculatePointsForHours(start, end);		
	}
	
	//method to calculate the points earned per hour
	private int calculatePointsForHours(int start, int end){
		
		//adding hours to array
		int hours = (end-start)+1;
		int[] arrayWorked = new int[hours];
		int s = start+1;
		for(int i = 0; i<=hours-1;i++){
			arrayWorked[i] = s;
			s++;
		}
		//check each index and add to the earned total
		double earned = 0;
		for(int i = 0; i<arrayWorked.length-1; i++){
			int index = arrayWorked[i];
			if(index>7&&index<=20){
				earned += 1.0;
			} else if(index>20&&index<=24){
				earned += 1.5;
			} else if(index>24){
				earned += 2.0;
			}
		}
		return (int) earned;
	}
	public void processPointsEarned(){
		Set<Map.Entry<User,Integer>> set = users.entrySet();
		for(Map.Entry<User,Integer> me : set){
			pointTransaction.earnPointsAtDate(me.getValue(), me.getKey(), date, this.description);
			
		}
		
	}
	public LocalDate getDate(){
		return date;
	}

}
