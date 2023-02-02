/*
 * Programmer .: Isaac Oxendale & Joe Ermatinger
 * Date . . . .: 2019-04-01
 * Program Name: BaseballPlayer.java
 */
package program3;

public class BaseballPlayer extends Player
{
	//overrides the play method inherited from the Player abstract class 
	@Override
	public void play()
	{
		System.out.println("Baseball, where the object\n of the game is to score the most home runs.\n");
	}	
}