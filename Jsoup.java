package application;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class JsoupCrawler {
	
	public static void main(String[] args) {

		String txtFilePath = "C:/Users/raide/Documents/Eclipse.Workspace/JavafxDatabase/src/resources/urls.txt";
		String line = "";
		try {
			BufferedReader br = new BufferedReader(new FileReader(txtFilePath));
			while((line = br.readLine()) !=null) {
				System.out.println(line);
				Document doc = Jsoup.connect(line).ignoreHttpErrors(true).get();
				String html = doc.body().html();
				System.out.println(html);
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
