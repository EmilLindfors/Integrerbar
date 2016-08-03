package Points;

import java.time.LocalDate;
/*
 * Class to keep track of the transaction at a certain date
 */

public class TransactionHistoryInstance {
	LocalDate date;
	int transaction;
	String description;
	
	TransactionHistoryInstance(LocalDate d, int t, String s){
		this.date = d;
		this.transaction = t;
		this.description = s;
	}
	
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public int getTransaction() {
		return transaction;
	}
	public void setTransaction(int transaction) {
		this.transaction = transaction;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	

}
