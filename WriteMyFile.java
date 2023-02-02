/*
 * Program Name: WriteMyFile
 * Programmers: Joe Ermatinger & Isaac Oxendale
 * Date: 2019/02/14
 */

import java.util.*;

import java.io.*;

public class WriteMyFile
{
	public static void main(String[] args) throws IOException
	{
		//variable declarations
		String filename, inventoryItem;
		int counter=0;
		char continueYN;
		
		//display heading
		System.out.printf("Welcome to DemoSoftwareSales\nby Joe Ermatinger & Isaac Oxendale\n\n");
		//new scanner object to receive keyboard input		
		Scanner keyboard = new Scanner(System.in);
		//prompt user for filename
		System.out.printf("\nEnter the file name:  ");		
		//assign filename to variable
		filename = keyboard.nextLine();
		
		File islandFile = new File(filename);
		//if file already exists terminate program
		if (islandFile.exists())
		{
			System.out.printf("\nThe file " + filename + " already exists\n");
			System.exit(0);
		}
		
		PrintWriter outputFile = new PrintWriter(islandFile);
		
		System.out.printf("If you were stranded on a desert island, you would want the following items:");
		
		do
		{
			//prompt user for input
			System.out.printf("\nEnter item #%d: ",counter +1);
			
			inventoryItem = keyboard.nextLine();
			//write item to file
			outputFile.printf("%s\n",inventoryItem);
			
			//prompt for sentinel value
			System.out.printf("\nContinue? (y/n): ");
			continueYN =  Character.toUpperCase(keyboard.findInLine(".").charAt(0));
			keyboard.nextLine();
			//increment counter variable
			counter++;
		}
		//continue loop?
		while(continueYN == 'Y');
		//close file
		outputFile.close();
		System.out.printf("Data successfully written to the file. You have taken %d item(s) with you.\n", counter);
	}
}