package program4;
/*
 * Programmer .: Isaac Oxendale & Joe Ermatinger
 * Date . . . .: 2019-04-04
 * Program Name: OverNightShip.java
 */

public class OverNightShip implements ShipCost 
{
	final int BREAKPOUNDS        = 7;     //how many pounds they are allowed to ship at a flat rate before being billed per pound 
	final double OVERBREAKPRICE  = 1.50;  //cost per pound over BREAKPOUNDS
	final double UNDERBREAKPRICE = 5.00;  //base cost to ship less than BREAKPOUNDS
	final double SURCHARGE       = 10.00; //surcharge for overnight shipping
	
	//overrides calculateShipCost
	@Override
	public double calculateShipCost(int pounds) 
	{
		double price;
		
		if (pounds > 5) 
		{
			price = SURCHARGE + UNDERBREAKPRICE;
		}
		else
		{
			price = SURCHARGE + UNDERBREAKPRICE + OVERBREAKPRICE * (pounds - BREAKPOUNDS);
		}
		
		//returns calculated Overnight Shipping cost
		return price;
	}

}
