package program4;
/*
 * Programmer .: Isaac Oxendale & Joe Ermatinger
 * Date . . . .: 2019-04-04
 * Program Name: StandardShip.java
 */

public class StandardShip implements ShipCost 
{
	//program constants
	final double UNDERBREAKPRICE = 3.00; //base cost to ship less than BREAKPOUNDS
	final double OVERBREAKPRICE  = 1.50; //cost per pound over BREAKPOUNDS
	   final int BREAKPOUNDS     = 5;    //how many pounds they are allowed to ship at a flat rate before being billed per pound
	
	//overrides calculateShipCost method       
	@Override
	public double calculateShipCost(int pounds) 
	{
		double price;
		
		if (pounds < 5) 
		{
			price = UNDERBREAKPRICE;
		}
		else
		{
			price = UNDERBREAKPRICE + OVERBREAKPRICE * (pounds - BREAKPOUNDS);
		}
		
		//returns calculate standard shipping cost
		return price;
	}

}
