package program7;
/*
 * File Name:		WriteMyBinaryFile.java
 * Programmers:		Joe Ermatinger & Isaac Oxendale
 * Date Created:	2019/04/14
 * Purpose:
 */
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;


public class WriteMyBinaryFile
{
	public static void main(String[] args) throws IOException
	{
		final String FILENAME = "WriteMyBinaryFile.dat";
		//separator string
		final String DIVIDER = "xZIozCA0rL212lfEM8La";
		
		//variable declarations
		int count = 0;
		char choice;
		boolean valid, error2Displayed = false;
		
		String inputString;
		Date today = new Date();
		StringBuilder toOutFile = new StringBuilder();
		Scanner dataIn = new Scanner(System.in);
		
		//set up binary file output stream
		DataOutputStream fileOutput = new DataOutputStream(new FileOutputStream(FILENAME));
		
		//display program greeting
		System.out.println("Welcome to WriteMyBinaryFile, a program by Isaac Oxendale & Joe Ermatinger\n" + "It is currently " + today + "\n");
		
		do //while the user wants to continue, keep looping
		{
			count++;
			valid = true;
			
			//ask for person's address
			System.out.print("What is the address of person number " + count + "?  ");
			inputString = dataIn.nextLine();
			toOutFile.append(inputString);
			
			toOutFile.append(DIVIDER);
			
			do //validate input 
			{
				if (!valid && !error2Displayed)
				{
					System.out.println("\nPlease enter only numbers.");
				}
				error2Displayed = false;
				System.out.print("What is the social security number of person number " + count + "?  ");
				inputString = dataIn.nextLine();
				try
				{
					Integer.parseInt(inputString);
					valid = true;
				}
				catch (NumberFormatException e)  //validate input to be numbers only
				{
					valid = false;
				}
				if (inputString.length()!=9)     //validate input to have a length of 9
				{
					System.out.println("Please enter exactly nine numbers.");
					error2Displayed = true;
					valid = false;
				}
					
			}while(!valid);
			toOutFile.append(inputString);
			
			toOutFile.append(DIVIDER);
			
			//ask user if they would like to continue
			System.out.print("Would you like to continue? (Yes/No): ");
	        choice =  Character.toUpperCase(dataIn.findInLine(".").charAt(0));
	        dataIn.nextLine();
		} while (choice != 'N');
		
		//write data to file
		System.out.println("Writing to file . . .");
	    fileOutput.writeUTF(toOutFile.toString());
	
		//close file
	    fileOutput.close();
		System.out.println("File Closed.");
		
		//close keyboard input and terminate program
		dataIn.close();
		System.exit(0);
	}
}

