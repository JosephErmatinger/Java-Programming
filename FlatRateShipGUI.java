package program4;
/*
 * Programmer .: Isaac Oxendale & Joe Ermatinger
 * Date . . . .: 2019-04-04
 * Program Name: FlatRateShipGUI.java
 */

import javax.swing.JOptionPane;

public class FlatRateShipGUI implements ShipCost 
{    
	double price = 0;
    
	//constant declarations
	final double SMPRICE =  8.50; //price to ship a small box
	final double MDPRICE = 12.00; //price to ship a medium box
	final double LGPRICE = 20.00; //price to ship a large box
			  
	//overrides the calculateShipCost method
	@Override
	public double calculateShipCost(int pounds)
    {
		char choice;
		String input;
		
		//prompt user for parcel size
		input = JOptionPane.showInputDialog("What size package will you be using?\n\tSmall/Medium/Large");
	    choice =  Character.toUpperCase(input.charAt(0));
	    
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
        //return price for small, medium, or large parcel	
	    return price;
    }
	
}
 