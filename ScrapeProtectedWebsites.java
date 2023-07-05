import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.IOException;
import java.util.Map;

public class ScrapeProtectedWebsites {
    private static final String GITHUB_LOGIN_URL = "https://github.com/login";
    private static final String GITHUB_TARGET_URL = "https://github.com/your_username";

    private static final String FACEBOOK_LOGIN_URL = "https://www.facebook.com/login";
    private static final String FACEBOOK_TARGET_URL = "https://www.facebook.com/your_username";

    public static void main(String[] args) {
        scrapeGitHub();
        scrapeFacebook();
    }

    private static void scrapeGitHub() {
        try {
            // Step 1: Perform login
            Connection.Response loginForm = Jsoup.connect(GITHUB_LOGIN_URL)
                    .method(Connection.Method.GET)
                    .execute();

            Document loginDoc = loginForm.parse();
            String authenticityToken = loginDoc.select("input[name=authenticity_token]").val();

            Connection.Response loginResponse = Jsoup.connect(GITHUB_LOGIN_URL)
                    .data("login", "your_username")
                    .data("password", "your_password")
                    .data("authenticity_token", authenticityToken)
                    .cookies(loginForm.cookies())
                    .method(Connection.Method.POST)
                    .execute();

            Map<String, String> loginCookies = loginResponse.cookies();

            // Step 2: Make request to the target page
            Document targetDoc = Jsoup.connect(GITHUB_TARGET_URL)
                    .cookies(loginCookies)
                    .get();

            // Step 3: Process the scraped data
            // Do whatever you want with the scraped data from the target page
            System.out.println(targetDoc.html());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void scrapeFacebook() {
        try {
            // Step 1: Perform login
            Connection.Response loginForm = Jsoup.connect(FACEBOOK_LOGIN_URL)
                    .method(Connection.Method.GET)
                    .execute();

            Document loginDoc = loginForm.parse();

            Connection.Response loginResponse = Jsoup.connect(FACEBOOK_LOGIN_URL)
                    .data("email", "your_email")
                    .data("pass", "your_password")
                    .cookies(loginForm.cookies())
                    .method(Connection.Method.POST)
                    .execute();

            Map<String, String> loginCookies = loginResponse.cookies();

            // Step 2: Make request to the target page
            Document targetDoc = Jsoup.connect(FACEBOOK_TARGET_URL)
                    .cookies(loginCookies)
                    .get();

            // Step 3: Process the scraped data
            // Do whatever you want with the scraped data from the target page
            System.out.println(targetDoc.html());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
