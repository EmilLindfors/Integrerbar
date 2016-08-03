package Points;

public class Points {
	private int totalEarnedPoints;
	private int usedPoints;
	private TransactionHistory pointHistory;
	
	public Points(int earnedPoints, int usedPoints){
		this.totalEarnedPoints = earnedPoints;
		this.usedPoints = usedPoints;
		this.pointHistory = new TransactionHistory(earnedPoints, usedPoints);
	}
	
	public void usePoints(int transaction){
		this.usedPoints += transaction;	
	}
	public void earnPoints(int transaction){
		this.totalEarnedPoints += transaction;
	}
	
	public TransactionHistory getPointHistory(){
		return pointHistory;
	}
	public void printHistory(String s){
		pointHistory.showRecords(s);
	}
	public int getUsedPoints(){
		return this.usedPoints;
	}
	public int getTotalPoints(){
		return this.totalEarnedPoints;
	}
	public int getSpendablePoints(){
		return this.totalEarnedPoints - this.usedPoints;
	}
	
	@Override
	public String toString(){
		return "Total Earned Points: "+this.getTotalPoints()+",Total Used Points: "+this.getUsedPoints();
	}
	

	
}
