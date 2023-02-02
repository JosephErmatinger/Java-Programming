package program4;
/*
 * Programmer .: Isaac Oxendale & Joe Ermatinger
 * Date . . . .: 2019-04-04
 * Program Name: ShipCost.java
 */

public interface ShipCost 
{
	//each class that uses this interface must override the calculateShipCost method
	abstract double calculateShipCost(int pounds);
}
 