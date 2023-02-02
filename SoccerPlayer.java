package program3;
/*
 * Programmer .: Isaac Oxendale & Joe Ermatinger
 * Date . . . .: 2019-04-02
 * Program Name: SoccerPlayer.java
 */

public class SoccerPlayer extends Player
{
	//overrides the play method inherited from the Player abstract class 
	@Override
	public void play()
	{
		System.out.println("Soccer, where the object\n of the game is to score the most goals.\n");
	}	
}