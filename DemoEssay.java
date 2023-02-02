/*
 * Programmer .: Isaac Oxendale & Joe Ermatinger
 * Date . . . .: 2019-03-21
 * Program Name: DemoEssay.java
 * Purpose . . : Demonstrate the use of the Essay subclass
 */

package program9;

import java.util.Date;
import java.util.Scanner;

public class DemoEssay {
	public static void main(String[] args) {
		Essay NewEssay = new Essay();
		Scanner dataIn = new Scanner(System.in);
		Date today = new Date();
		double testDouble;

		// display heading
		System.out.println("Welcome to DemoEssay, a program by Isaac Oxendale & Joe Ermatinger\n" + "It is currently " + today + "\n");

		//Gets score for Grammar
		System.out.print("Please enter a score for Grammar (0 - 30): ");
		testDouble = Double.parseDouble(dataIn.nextLine());
		testDouble = Math.abs(testDouble); //takes the absolute value of the input
		while (testDouble > 30) {
			System.out.print("That's not a valid score!\nYou entered:  " + testDouble
					+ ", please enter a number less than 30:  ");
			testDouble = Double.parseDouble(dataIn.nextLine());
			testDouble = Math.abs(testDouble); //takes the absolute value of the input
		}
		NewEssay.setGrammar(testDouble);

		//Gets score for Spelling
		System.out.print("Please enter a score for Spelling (0 - 20):  ");
		testDouble = Double.parseDouble(dataIn.nextLine());
		testDouble = Math.abs(testDouble); //takes the absolute value of the input
		while (testDouble > 20) {
			System.out.print("That's not a valid score!\nYou entered:  " + testDouble
					+ ", please enter a number less than 20:  ");
			testDouble = Double.parseDouble(dataIn.nextLine());
			testDouble = Math.abs(testDouble); //takes the absolute value of the input
		}
		NewEssay.setSpelling(testDouble);

		//Gets score for Correct Length
		System.out.print("Please enter a score for Correct Length (0 - 20):  ");
		testDouble = Double.parseDouble(dataIn.nextLine());
		testDouble = Math.abs(testDouble); //takes the absolute value of the input
		while (testDouble > 20) {
			System.out.print("That's not a valid score!\nYou entered:  " + testDouble
					+ ", please enter a number less than 20:  ");
			testDouble = Double.parseDouble(dataIn.nextLine());
			testDouble = Math.abs(testDouble); //takes the absolute value of the input
		}
		NewEssay.setCorrectLength(testDouble);

		//Gets score for Content
		System.out.print("Please enter a score for Content (0 - 30):  ");
		testDouble = Double.parseDouble(dataIn.nextLine());
		testDouble = Math.abs(testDouble); //takes the absolute value of the input
		while (testDouble > 30) {
			System.out.print(String.format("That's not a valid score!\nYou entered: ", testDouble)
					+ ", please enter a number less than 30:  ");
			testDouble = Double.parseDouble(dataIn.nextLine());
			testDouble = Math.abs(testDouble); //takes the absolute value of the input
		}
		NewEssay.setContent(testDouble);

		NewEssay.setScore();

		//Prints total essay score
		System.out.println("\nEssay Scores:\n\n" + NewEssay.toString());

		//terminate program
		dataIn.close();
		System.exit(0);
	}
}