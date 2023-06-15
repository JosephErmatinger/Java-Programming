package application;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.jsoup.nodes.Document;

public class WebsiteWatcher2 {
	static String csvFilePath = "C:/Users/Joe/Documents/Java/DatabaseTableview/src/application/urls.csv";
	Date date = new Date();
	private Map<String, String>urlMap;
	
	public WebsiteWatcher2() {
		urlMap = new HashMap<>();
	}
	public void readUrlsFromCsv(String csvFilePath) {
		try(BufferedReader reader = new BufferedReader(new FileReader(csvFilePath))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String url = line.trim();
				urlMap.put(url, "");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void trackWebsites() {
		for (String url: urlMap.keySet()) {
			String lastContent = urlMap.get(url);
			String currentContent = getContent(url);
		
		if (!currentContent.equals(lastContent)) {
			System.out.println("Website has changed: " + url);
			System.out.println("Website last changed on: " + date);
			urlMap.put(url, currentContent);
			}
		}
	}
	public String getContent(String url) {
		try {
			Document doc = org.jsoup.Jsoup.connect(url).ignoreHttpErrors(true).get();
			String html = doc.body().html();
			return html;
		} catch (IOException e) {
			e.printStackTrace();
		}
			return "";
	}
	public static void main(String[] args) {
		WebsiteWatcher2 tracker = new WebsiteWatcher2();
		tracker.readUrlsFromCsv(csvFilePath);
		tracker.trackWebsites();
	}
}
