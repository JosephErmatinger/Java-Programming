/*
 * Program Name: SoftwareSales
 * Programmers: Joe Ermatinger & Isaac Oxendale
 * Date: 2019/02/14
 */

public class SoftwareSales
{
	//declare variables
	private int licenseQuantity, i;
	private final int COST = 99;
	private final double[] DISCOUNT = {1.0,.8,.7,.6,.5};
	//no-arg constructor, sets licenseQuantity to default of 0
	public SoftwareSales()
	{
		licenseQuantity=0;
	}
	//parameterized constructor, puts int value into licenseQuantity 
	public SoftwareSales(int units)
	{
		licenseQuantity = units;
	}
	//sets the number of software licenses sold
	public void setlicenseQuantity(int units)
	{
		licenseQuantity = units;
	}
	// returns the value of COST to the caller
	public int getCost()
	{
		return COST;
	}
	//gets the number of units stored in the instance field
	public int getlicenseQuanity()
	{
		return licenseQuantity;
	}
	//gets the discount based on the number of units sold
	public double getDiscount()
	{
		return DISCOUNT[this.DiscountFinder(licenseQuantity)];
	}
	//returns the final cost
	public double getFinalCost(int units)
	{
		return COST * DISCOUNT[this.DiscountFinder(units)];
	}
	//determine discount based on quantity using if else
	public int DiscountFinder(int quant)
	{
			   if (quant < 10){
			i=0;					
		} else if (quant < 20){
			i=1;
		} else if (quant < 50){
			i=2;
		} else if (quant < 100){
			i=3;
		} else {
			i=4;}
		return i;
	}	
}
	
