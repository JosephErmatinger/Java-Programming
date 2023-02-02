/*
 * Program Name: YourChoice2.java
 * Programmer .: Isaac Oxendale & Joe Ermatinger
 * Date . . . .: 2019-03-14
 */

public class YourChoice2
{
	//variable declarations
	private String name;
	private int age;
	private int price;
	private static int instancesCreated;
	
	//constructors, accepting various arguments
	public YourChoice2()
	{
		name = "Ficus";
		age = 75;
		price = 1200;
		instancesCreated += 1;
	}
	public YourChoice2(String name)
	{
		this.name = name;
		age = 75;
		price = 1200;
		instancesCreated += 1;
	}
	public YourChoice2(String name, int age)
	{
		this.name = name;
		this.age = age;
		price = 1200;
		instancesCreated += 1;
	}
	public YourChoice2(String name, int age, int price)
	{
		this.name = name;
		this.age = age;
		this.price = price;
		instancesCreated += 1;
	}
	//setters(mutators)
	public void setName(String a)
	{
		name = a;
	}
	public void setAge(int b)
	{
		age = b;
	}
	public void setPrice(int c)
	{
		price = c;
	}
	//getters(accessors)
	public String getName()
	{
		return name;
	}
	public int getAge()
	{
		return age;
	}
	public int getPrice()
	{
		return price;
	}
	//returns a nicely formatted string of the object's contents
	public String toString()
	{
		StringBuilder strout = new StringBuilder("       Bonsai Tree\n");
		strout.append("-----------------------\n");
		strout.append("Name. . . . . . : " + name + "\n");
		strout.append("Age . . . . . . : " + age + "\n");
		strout.append("Price . . . . . : " + price + "\n");
		strout.append("instancesCreated: " + instancesCreated + "\n");
		return strout.toString();
	}
	// returns number of instances created
	public static int getInstancesCreated() 
	{
		return instancesCreated;
	}
}
