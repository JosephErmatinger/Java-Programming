//Payroll.java Created by: Joe Ermatinger 2/05/2018   

import java.io.*;
import java.util.Scanner;

public class Payroll 
{
    //variable declarations
	private String Name;
	private int ID;
	private double hourlyRate;
	private int hours;
	
	//no-arg constructor
	public void Payroll()
	{
		Name = "";
		ID = 0;
		hourlyRate = 0.0;
		hours = 0;
	}
	//two-arg constructor
	public void Payroll (String name, int id)
	{
		Name = name;
		ID = id;
	}
	//setters(mutators)
	public void setName (String name)
	{
		Name = name;
	}
	public void setID (int id)
	{
		ID = id;
	}
	public void setHourlyRate(double rate)
	{
		hourlyRate = rate;
	}
	public void setHours(int hrs)
	{
		hours = hrs;
	}
	//getters(accessors)
	public String getName()
	{
		return Name;
	}
	public int getId()
	{
		return ID;
	}
	public double getHourlyRate()
	{
		return hourlyRate;
	}
	public int getHours()
	{
		return hours;
	}
	public double grossPay()
	{
		return (hourlyRate * hours);   //hourly rate calculation
	}
}