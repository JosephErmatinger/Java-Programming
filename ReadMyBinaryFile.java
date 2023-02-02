package program7;
/*
 * File Name:		ReadMyBinaryFile.java
 * Programmers:		Joe Ermatinger & Isaac Oxendale
 * Date Created:	2019/04/14
 */
import java.io.*;
import java.util.Date;

public class ReadMyBinaryFile
{
	public static void main (String[] args) throws IOException
	{
		final String FILENAME = "WriteMyBinaryFile.dat";
		
	    String input = "";
	    String[] answerArray;
	    StringBuilder message = new StringBuilder();
	    Date today = new Date();
	   
	    //set up binary file input stream
		DataInputStream fileInput = new DataInputStream(new FileInputStream(FILENAME));
		
		//display program greeting
		System.out.println("Welcome to ReadMyBinaryFile, a program by Isaac Oxendale & Joe Ermatinger\n" + "It is currently " + today + "\n");
		System.out.println("Reading data from the file: ");
		
		//read the string in the file
		try
		{
			input = fileInput.readUTF();
		}
		catch (Exception e)  //catch i/o exception
		{
			e.printStackTrace();
		}
		answerArray = input.split("xZIozCA0rL212lfEM8La");
		
		//iterate through array and present data from binary file
		for (int i=0;i<answerArray.length;i++)
		{
			if (i>0)
				message.append('\n');
			message.append("\nPerson # " + (i/2 + 1));
			message.append("\nAddress. .: ");
			message.append(answerArray[i]);
			i++;
			message.append("\nSSN. . . .: ");
			message.append(answerArray[i]);
		}
		System.out.println(message.toString());
		
		//close the file
		fileInput.close();
		System.out.println("\nFinished reading from file.");
		
	}
}