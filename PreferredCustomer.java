/*
 * Programmer .: Isaac Oxendale & Joe Ermatinger
 * Date . . . .: 2019-03-21
 * Program Name: PreferredCustomer.java
 * Purpose . . : Demonstrate the use of the PreferredCustomer subclass
 */

package program8;

public class PreferredCustomer extends Customer
{
	
	double purchase;
	
	final double DSCNTLVL1 = 0.05;
	final double DSCNTLVL2 = 0.06;
	final double DSCNTLVL3 = 0.07;
	final double DSCNTLVL4 = 0.1;

	//no-arg constructor
	public PreferredCustomer() 
	{
		purchase = 0.0;
	}
	
	//full-arg constructor
	public PreferredCustomer(String name, String address, String telNo, int custNo, boolean isOnMalingList, double initialPurchase)
	{
		super(name, address, telNo, custNo, isOnMalingList);
		purchase = initialPurchase;
	}
	
	//adds a purchase to the purchase total
	public void addPurchase(double newPurchase)
	{
		purchase += newPurchase;
	}
	
	//gets the current discount based on cumulative purchases
	public double getDiscount()
	{
		   
		double discount = 0.0;
		
			 if (purchase >= 500)
		    	 discount = DSCNTLVL1;
		else if (purchase >= 1000) 
				discount = DSCNTLVL2;
		else if (purchase >= 1500) 
				discount = DSCNTLVL3;
		else if (purchase >= 2000) 
				discount = DSCNTLVL4;
			 
		return discount;
	}
	
	//getter for purchase field
	public double getPurchase() {
		return purchase;
	}

	//setter for purchase field
	public void setPurchase(double purchase) {
		this.purchase = purchase;
	}

	//clears all purchases on customer account when they have reached their expiration date
	public void clearPurchase()
	{
		purchase = 0.0;
	}
	
	@Override
	public String toString()
	{
		StringBuilder message = new StringBuilder();
		message.append(super.toString());
		message.append("\nTotal Purchases.:\t");
		message.append(String.format("$%.2f", purchase));
		message.append("\nCurrent Discount:\t");
		message.append(String.format("%.0f%%", 100 * this.getDiscount()));
		
		return message.toString();
	}

}
