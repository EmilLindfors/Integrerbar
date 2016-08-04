package Organisations;

import java.util.ArrayList;
/**
 * Organisations can get (buy) coupons with a certain amount of points that can be distributed to users who can use
 * them.
 */
public class PointCoupon {
	
	private final int amount;
	private final int remaining;
	private final int value;
	private final ArrayList<String> listOfReceivers;
	
	public PointCoupon(int amount, int remaining, int value) {
		super();
		this.amount = amount;
		this.remaining = remaining;
		this.value = value;
		this.listOfReceivers = new ArrayList<String>();
	}
	
	

}
