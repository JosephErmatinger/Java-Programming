// Car.java Created by: Joe Ermatinger 2/05/2018   

public class Car
{
	//variable declarations
	private int yearModel;
	private String make;
	private int Speed;
	
	//parameterized constructor
	public Car(int newYearModel, String newMake)
	{
		yearModel = newYearModel;
		make = newMake;
		Speed = 0;
	}
	//getters(accessors)
	public int getYear()
	{
		return yearModel;
	}
	public String getMake()
	{
		return make;
	}
	public int getSpeed()
	{
		return Speed;
	}
	public void accelerate()
	{
		Speed +=5;              //increase speed by 5
	}
	public void brake()
	{
		Speed -=5;              //decrease speed by 5
	}
}	