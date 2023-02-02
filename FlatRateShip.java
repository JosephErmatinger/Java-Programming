package program4;
/*
 * Programmer .: Isaac Oxendale & Joe Ermatinger
 * Date . . . .: 2019-04-04
 * Program Name: FlatRateShip.java
 */

import java.util.Scanner;

public class FlatRateShip implements ShipCost 
{    
	//variable declarations
	double price = 0;
	
	//program constants
	final double SMPRICE =  8.50; //price to ship a small box
	final double MDPRICE = 12.00; //price to ship a medium box
	final double LGPRICE = 20.00; //price to ship a large box
	
	//overrides the calculateShipCost method
	@Override
	public double calculateShipCost(int pounds)
    {
		char choice;
		Scanner dataIn = new Scanner(System.in);
		
		//prompt user for parcel size
		System.out.println("What size package will you be using?\n\tSmall/Medium/Large");
	    choice =  Character.toUpperCase(dataIn.findInLine(".").charAt(0));
	    
	    //selects size of parcel
	    switch (choice)
	    {
	    case 'S':
	    	price = SMPRICE; 
	    	break;
	    case 'M':
	    	price = MDPRICE;
    		break;
    	case 'L':
    		price = LGPRICE;
    		break;
    	}
	
    	//close keyboard input
	    dataIn.close();
	
		return price;
    }
	
}
 