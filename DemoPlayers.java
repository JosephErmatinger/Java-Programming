package program3;
import java.util.*;

/*
 * Programmer .: Isaac Oxendale & Joe Ermatinger
 * Date . . . .: 2019-04-02
 * Program Name: DemoPlayers.java
 * Purpose . . : 
 */

public class DemoPlayers
{
	public static void main(String[] args)
	{
		//variable declarations and instantiate objects
		SoccerPlayer   player1 = new SoccerPlayer();
		MonopolyPlayer player2 = new MonopolyPlayer();
		BaseballPlayer player3 = new BaseballPlayer();
		Scanner        dataIn  = new Scanner(System.in);
		Date           today   = new Date();
		StringBuilder  message = new StringBuilder();
		
	    //display heading
		System.out.println("Welcome to DemoPlayers, a program by Isaac Oxendale & Joe Ermatinger\n" + "It is currently " + today + "\n");
		
		//sets the name for each type of player
	    System.out.print("Enter the Soccer Player's name  : ");
	    player1.setName(dataIn.nextLine());
	    System.out.print("Enter the Monopoly Player's name: ");
	    player2.setName(dataIn.nextLine());
	    System.out.print("Enter the Baseball Player's name: ");
	    player3.setName(dataIn.nextLine());
	    
	    //outputs a message to the screen for player1
	    message.append("\nHi, my name is ");
	    message.append(player1.getName());
	    message.append(" and my game is ");
	    System.out.print(message.toString());
	    player1.play();
	    
	    //outputs a message to the screen for player2
	    message = new StringBuilder();
	    message.append("Hi, my name is ");
	    message.append(player2.getName());
	    message.append(" and my game is ");
	    System.out.print(message.toString());
	    player2.play();
	    
	    //outputs a message to the screen for player3
	    message = new StringBuilder();
	    message.append("Hi, my name is ");
	    message.append(player3.getName());
	    message.append(" and my game is ");
	    System.out.print(message.toString());
	    player3.play();
	    
	    //terminate program
	    dataIn.close();
	    System.exit(0);
	}
}