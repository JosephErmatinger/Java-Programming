package application;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CSVPrint {
	
	public static void main(String[] args) {

		String csvFilePath = "C:/Users/raide/Documents/Eclipse.Workspace/JavafxDatabase/src/resources/urls.csv";
		String line = "";
		try {
			BufferedReader br = new BufferedReader(new FileReader(csvFilePath));
			while((line = br.readLine()) !=null) {
				String[] values = line.split(",");
				System.out.println("Site custom name: " + values[0] + ", Site folder: " + values[1] + ", Page URL: " + values[2] + ", Page Status: " + values[3] + ", Response Code: " + values[4] + ", Category: " + values[5]);
			}br.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}catch (SecurityException e) {
			    e.printStackTrace();
			}
	  }	
}
