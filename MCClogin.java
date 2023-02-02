/*
 * Program Name: MCClogin.java
 * Programmer .: Isaac Oxendale & Joe Ermatinger
 * Date . . . .: 2019-03-21
 */

import java.util.*;
import javax.swing.JOptionPane;

public class MCClogin
{
	public static void main(String[] args)
	{
		Date today = new Date();
		String fName, lName, studNo;
		StringBuilder userName, password, message;
		
		//program greeting
		JOptionPane.showMessageDialog(null,"Welcome to MCClogin, a program by Isaac Oxendale & Joe Ermatinger\n" + "It is currently " + today + "\n", "MCClogin by Isaac Oxendale and Joe Ermatinger", JOptionPane.PLAIN_MESSAGE);
	
		//collect strings from screen
		fName =  JOptionPane.showInputDialog(null,"Enter your first name: ");
		lName =  JOptionPane.showInputDialog(null,"Enter your last name: ");
		studNo = JOptionPane.showInputDialog(null,"Enter your student number: ");

		//create username according to requirements
		userName = new StringBuilder(fName.toLowerCase());
		userName.append(".");
		userName.append(lName.toLowerCase());
		
		//create password according to requirements
		password = new StringBuilder();
		password.append(Character.toLowerCase(fName.charAt(0)));
		password.append(studNo);
		password.append("!");
		password.insert(1, Character.toLowerCase(lName.charAt(0)));
	
		//create message as a human way to display username and password
		message = new StringBuilder("Your username is:\t");
		message.append(userName.toString());
		message.append("\nAnd your password is:\t");
		message.append(password.toString());
		
		//display message 
		JOptionPane.showMessageDialog(null, message.toString(), "MCClogin by Isaac Oxendale and Joe Ermatinger", JOptionPane.PLAIN_MESSAGE);
		
		//terminate program
		System.exit(0);
	}
}