package application;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.Locale;

public class TVGuideScraper {
    public static void main(String[] args) {
        String url = "https://www.tvguide.com/new-tonight/";

        try {
            Document doc = Jsoup.connect(url).get();
            Elements tvShowElements = doc.select(".c-TvObjectCard");
            Date today = new Date();
            String filename = today.toString().replace(" ", "_").replace(":", "-") + ".txt";
            FileWriter writer = new FileWriter(filename);

            for (Element tvShowElement : tvShowElements) {
                String date = tvShowElement.select(".c-TvObjectCard_meta").get(0).text();
                String time = tvShowElement.select(".c-TvObjectCard_meta").get(1).text();
                String network = tvShowElement.select(".c-TvObjectCard_meta").get(2).text();
                String title = tvShowElement.select(".g-text-xlarge").text();
                String episodeDetails = tvShowElement.select(".c-TvObjectCard_metawrapper").text();
                String description = tvShowElement.select(".c-TvObjectCard_summary").text();

                DateTimeFormatter currentDateFormatter = DateTimeFormatter.ofPattern("EEE, MMM d", Locale.ENGLISH);
                String adjustedDateString = currentDateFormatter.format(java.time.LocalDate.now());         
                
                LocalTime parsedTime = LocalTime.parse(time, DateTimeFormatter.ofPattern("h:mm a", Locale.ENGLISH));
                LocalTime adjustedTime = parsedTime.minusHours(4);
                DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("h:mm a", Locale.ENGLISH);
                String adjustedTimeString = adjustedTime.format(timeFormatter);

                writer.write("Date: " + adjustedDateString + "\n");
                writer.write("Time: " + adjustedTimeString + "\n");
                writer.write("Network: " + network + "\n");
                writer.write("Title: " + title + "\n");
                writer.write("Episode Details: " + episodeDetails + "\n");
                writer.write("Description: " + description + "\n");
                writer.write("-----\n");

                System.out.println("Date: " + adjustedDateString);
                System.out.println("Time: " + adjustedTimeString);
                System.out.println("Network: " + network);
                System.out.println("Title: " + title);
                System.out.println("Episode Details: " + episodeDetails);
                System.out.println("Description: " + description);
                System.out.println("-----");
            }
            writer.close();
            System.out.println("Data written to " + filename);
        } catch (IOException e) {
            e.printStackTrace();
        }catch (DateTimeParseException e) {
        	e.printStackTrace();
        System.out.println("Date or time parsing error.");
        }
    }
}
