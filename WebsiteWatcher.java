package application;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class WebsiteWatcher {
	static String csvFilePath = "C:/Users/Joe/Documents/Java/DatabaseTableview/src/application/urls.csv";
	Date date = new Date();
	private Map<String, String>websiteContent;
	
	public WebsiteWatcher() {
		websiteContent = new HashMap<>();
	}
	public void addWebsiteUrl(String url) {
		websiteContent.put(url, getContent(url));
	}
	public void loadWebsiteUrlsFromCsv(String csvFilePath) {
		try(BufferedReader reader = new BufferedReader(new FileReader(csvFilePath))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String [] parts = line.split(",");
				String url = parts[0].trim();
				addWebsiteUrl(url);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void monitorWebsites() {
		while(true) {
			for (String url: websiteContent.keySet()) {
				String currentContent = getContent(url);
				String previousContent = websiteContent.get(url);
			
			if (!currentContent.equals(previousContent)) {
				System.out.println("Website has changed: " + url);
				System.out.println("Website last changed on: " + date);
				websiteContent.put(url, currentContent);
			}
			}
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			}
	}
	private String getContent(String url) {
		StringBuilder content = new StringBuilder();
		try {
			URL websiteUrl = new URL(url);
			URLConnection connection = websiteUrl.openConnection();
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String line;
			while ((line = reader.readLine()) != null) {
				content.append(line);
			}
				reader.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e ) { 
				e.printStackTrace();
			}
			return content.toString();
	}
	public static void main(String[] args) {
		WebsiteWatcher monitor = new WebsiteWatcher();
		monitor.loadWebsiteUrlsFromCsv(csvFilePath);
		monitor.monitorWebsites();
	}
}
