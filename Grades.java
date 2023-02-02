package program5;
/*
 * File Name:	Grades.java
 * Programmers: Joe Ermatinger & and Isaac Oxendale
 * Date:		2019/04/14
 */
import java.util.Scanner;
import java.util.Date;
import java.util.InputMismatchException;

public class Grades
{
	public static void main(String[] args)
	{
		//variable declarations
		char continueYN, letterGrade;
		int gradeInput = -1, stuPass = 0, stuFail = 0, counter = 0; 
		Scanner dataIn = new Scanner(System.in);
		Date today = new Date();
		
		//program greeting
		System.out.printf("Welcome to the Letter Grade Converter\nby Joe Ermatinger & Isaac Oxendale\n" + "It is currently " + today + "\n");
		
		do // while the user wishes to continue entering grades, continue to loop
		{
			do //validate grade input to be between 0 & 100
			{
				System.out.printf("\nEnter numerical grade (0-100): ");
				try //validate numerical input
				{
					gradeInput = dataIn.nextInt();
					dataIn.nextLine();
				}
				catch (InputMismatchException e)
				{
					System.out.println("Please enter a number.");
					gradeInput = -1;
					dataIn.nextLine();
				}
				if (gradeInput < 0 || gradeInput > 100)
					System.out.print("\nError, grade must be in valid range (0-100).");
				
			}while(gradeInput < 0 || gradeInput > 100);
			
			//set appropriate letter grade based on gradeInput
				   if (gradeInput < 60){
				letterGrade = 'E';					
			} else if (gradeInput < 70){
				letterGrade = 'D';
			} else if (gradeInput < 80){
				letterGrade = 'C';
			} else if (gradeInput < 90){
				letterGrade = 'B';
			} else {
				letterGrade = 'A';	
			}	
			
			//display letter grade to screen	   
			System.out.printf("Letter grade: %c\n\n", letterGrade);
			
			//ask user to continue, is yes iterate again
			System.out.printf("Continue? (y/n): ");
			continueYN =  Character.toUpperCase(dataIn.findInLine(".").charAt(0));
			
			if(letterGrade == 'E')
			{
				 stuFail++;
			}
			else
			{
				stuPass++;
			}
			counter++;
		}
		while(continueYN == 'Y');
		
		//display output
		System.out.printf("The number of passing grades: %d\n", stuPass);
		System.out.printf("The number of failing grades: %d\n", stuFail);	
		System.out.printf("You have processed %d students.\n", counter);
		
		//close keyboard input
		dataIn.close();
	}
}
	