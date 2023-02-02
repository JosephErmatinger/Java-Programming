/*
 * Program Name: MCClogin.java
 * Programmer .: Isaac Oxendale & Joe Ermatinger
 * Date . . . .: 2019-03-21
 */


public class PasswordVerify
{
	public static boolean passwordIsValid(String str)
	{
		//variable declarations
		boolean hasUpper = false; 
		boolean hasLower = false; 
		boolean hasDigits = false;
		
		//check if passed string is less than 6 digits
		if (str.length()< 6)
		{
			return false;	//if it is, return false
		}
		else			//if it isn't...
		{
		//check each character in the string for validity
		for (int i=0;i < str.length(); i++)
		{
			if (Character.isUpperCase(str.charAt(i)))
				hasUpper = true;
			if (Character.isLowerCase(str.charAt(i)))
				hasLower = true;
			if (Character.isDigit(str.charAt(i)))
				hasDigits = true;
		}
		}
		//return true if all are valid, false if one or more are not
		return hasUpper && hasLower && hasDigits;
	}
}	