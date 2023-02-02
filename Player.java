/*
 * Programmer .: Isaac Oxendale & Joe Ermatinger
 * Date . . . .: 2019-04-02
 * Program Name: Player.java
 */

package program3;

abstract class Player
{
	//holds Player name
	private String name;

	//required method override
	public abstract void play();
	
	//getter for name field
	public String getName() 
	{
		return name;
	}

	//setter for name field
	public void setName(String name) 
	{
		this.name = name;
	}
}