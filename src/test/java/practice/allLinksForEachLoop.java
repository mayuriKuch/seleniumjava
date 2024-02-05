package practice;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.IOException;
import java.util.List;
import org.jsoup.nodes.Element;

public class allLinksForEachLoop {

    public static void main(String[] args) {
        String url = "https://www.flipkart.com/";

        try {
            Document document = Jsoup.connect(url).get();

            // Extract links using for-each loop
            List<Element> links = document.select("a[href]");

            for (Element link : links) {
                String absoluteUrl = link.absUrl("href");
                System.out.println(absoluteUrl);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
