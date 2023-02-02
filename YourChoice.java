// YourChoice.java by Joe Ermatinger 2/5/2018

public class YourChoice
{
	//variable declarations
	private String name;
	private int age;
	private int price;
	
	//no-arg constructor
	public YourChoice()
	{
		name = "Ficus";
		age = 75;
		price = 1200;
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
	
}
