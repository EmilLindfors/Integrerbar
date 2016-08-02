package Points;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class TransactionHistory {
	
/*	each user has a transaction history which is stored as a 
 *	TreeMap where amount and dates are recorded.  
 */
	private ArrayList<HistoryInstance> history;
	
	// constructors
	TransactionHistory(){
		this.history = new ArrayList<HistoryInstance>();
	}
	TransactionHistory(int startingTotal, int startingSpent){
		this.history = new ArrayList<HistoryInstance>();
		history.add(new HistoryInstance(LocalDate.now(), startingTotal, "Starting total earned"));
		history.add(new HistoryInstance(LocalDate.now(), startingSpent, "Starting total spent"));
	}
	
	//assumes correct values
	
	public void addRecord(LocalDate d, int t, String s){
		history.add(new HistoryInstance(d,t,s));
	}
	
	//prints all history to console
	
	public void showRecords(String s){
		System.out.println("****************** Log for "+s+" ******************");
		//sort arraylist by date with custom comparator
		history.sort(Comparator.comparing(HistoryInstance::getDate));
		
		int totalUsed = 0;
		int totalEarned = 0;
		String earnedOrUsed = "";
		
		for(HistoryInstance hi : history){
			if(hi.getTransaction()>0){
				totalEarned +=hi.getTransaction();
				earnedOrUsed = "Earned: ";
			} else {
				totalUsed +=hi.getTransaction();
				earnedOrUsed = "Used: ";
			}
			System.out.printf("%-6s%-3d points   %-11s %-6s\n",earnedOrUsed, hi.getTransaction(),hi.getDate().toString(),hi.getDescription());
			
		}
		System.out.println("Total Earned: "+totalEarned+" | Total Used: "+totalUsed+" | Usable: " +(totalEarned+totalUsed));
		System.out.println("**************************************************\n");
	}
	public ArrayList<HistoryInstance> getRecordsAtDate(LocalDate startDate, LocalDate endDate){
		ArrayList<HistoryInstance> betweenDates = new ArrayList<HistoryInstance>();
		for(HistoryInstance hi:history){
			if(hi.date.isAfter(startDate)&& hi.date.isBefore(endDate)){
				betweenDates.add(hi);
			}
		}
		return betweenDates;
	}
	public int getPointsInPeriod(LocalDate startDate, LocalDate endDate){
		ArrayList<HistoryInstance> list = getRecordsAtDate(startDate, endDate);
		int sum = 0;
		for(HistoryInstance hi:list){
			sum += hi.getTransaction();
		}
		return sum;
	}
}
