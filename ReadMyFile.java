/*
 * Program Name: ReadMyFile
 * Programmers: Joe Ermatinger & Isaac Oxendale
 * Date: 2019/02/14
 */

import java.util.*;
import java.io.*;

public class ReadMyFile
{
	public static void main(String[] args) throws IOException
	{
	  //counter variable declaration
      int count=0;
      //create scanner object for keyboard input
      Scanner keyboard = new Scanner(System.in);
      // Get the file name.
      System.out.print("Enter the name of a file: ");
      String filename = keyboard.nextLine();
      //make sure the file exists
      File islandFile = new File(filename);
      if (!islandFile.exists())
      {
         // Display an error message.
         System.out.println("The file " + filename +
                            " does not exist.");
         
         // Exit the program.
         System.exit(0);
      }
      // Open the file.
      Scanner inputFile = new Scanner(islandFile);
      //begin do while
      System.out.println();
      do
      {
         // Read the next item.
         String inventoryItem = inputFile.nextLine();

         // Display the last item read.
         System.out.printf("I want to take %s with me on the desert island.\n", inventoryItem);
         count++;
      }
      while (inputFile.hasNext());
      System.out.printf("\nI took %d items with me.\n\n", count);
      // Close the file.
      inputFile.close();
	}	
}
	