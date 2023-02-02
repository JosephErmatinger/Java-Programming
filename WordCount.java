/*
 * Program Name: WordCount.java
 * Programmer .: Isaac Oxendale & Joe Ermatinger
 * Date . . . .: 2019-03-21
 */

import java.util.*;

public class WordCount
{
	public static void main(String[] args)
	{
		//variable & array declarations
		Date today = new Date();
		Scanner dataIn = new Scanner(System.in);
		StringTokenizer inputSentence;
		int wordCount;
		String splitTest;
		String[] splitArray;
		
		//program greeting
		System.out.println("Welcome to WordCount, a program by Isaac Oxendale & Joe Ermatinger\n" + "It is currently " + today + "\n");
		
		//receive a sentence from the screen as a string, and use it to create a stringTokenizer object
		System.out.print("Please enter a sentence: ");
		inputSentence = new StringTokenizer(dataIn.nextLine());
		wordCount = inputSentence.countTokens();
		
		//output the number of tokens (words) in the object to the screen
		System.out.println("Your sentence has " + wordCount + " words in it.");
		
		//accept another string from the screen, and put it in the split array
		System.out.print("Please enter another sentence: ");
		splitTest = dataIn.nextLine();
		splitArray = splitTest.split(" ");
		
		//display the number of elements (words) in the array to the screen
		System.out.println("Your sentence has " + splitArray.length + " words in it.");
		
		//terminate program
		dataIn.close();
		System.exit(0);
	}
}