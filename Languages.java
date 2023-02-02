/*
 * Program Name: Languages.java
 * Programmer .: Isaac Oxendale & Joe Ermatinger
 * Date . . . .: 2019-03-14
 */

import java.util.ArrayList;
import java.util.Date; 

/**
 *  This program demonstrates an ArrayList.
 */
 
// Compile and run this program in its current state to study its behavior
// then, make the modifications explained below in the "Add Code" comments
 

public class Languages
{
   public static void main(String[] args)
   {
	   //display heading
	   Date today = new Date();
	   System.out.println("Welcome to Languages\nCreated by: Joe Ermatinger & Isaac Oxendale\nIt is currently: " + today + "\n");
      
	   // Create an ArrayList to hold some names.
      ArrayList<String> nameList = new ArrayList<String>();
      
      // Leave this section as is.... 
      nameList.add("C");
	  nameList.add("Nonsense");
      nameList.add("C++");
	  nameList.add("Ridiculous");
	  
	  // Add code to this program that uses the appropriate methods to:
		// 1.  Replace "Ridiculous" with "RPG"
		// 2.  Remove "Nonsense" from the list
		// 3.  Add "Java" to the end of the list
		// 4.  Insert "C#" into the list, right after "C++"
	  
	  nameList.set(3, "RPG");
	  nameList.remove(1);
	  nameList.add("Java");
	  nameList.add(2,"C#");
	  
      // Display the size of the ArrayList.
      System.out.println("The ArrayList has " + nameList.size() + " objects stored in it.");

      // Now display the items in nameList.
      for (String name : nameList)
         System.out.println(name);
   }
}