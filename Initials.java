// Initials.java Created by: Joe Ermatinger 2/05/2018   

public class Initials
{
	public static void main(String[] args)
	{
		//display heading
		System.out.println("Initials.java Created by: Joe Ermatinger");
		
		//initialize variables
		String firstName = "Joseph";
		String middleName = "Richard";
		String lastName = "Ermatinger";
		char firstInitial = 'J';
		char middleInitial = 'R';
		char lastInitial = 'E';
		
		//display output
		System.out.println("Full Name: " + firstName + " " + middleName + " " + lastName );
		System.out.println("Initials: "+ firstInitial + "." + middleInitial + "." + lastInitial + "." );
	}
}	
		/* 
		firstInitial = firstName.charAt(0);
		middleInitial = middleName.charAt(0);
		lastInitial = lastName.charAt(0);
		*/