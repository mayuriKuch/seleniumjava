package practice;

import org.jsoup.Jsoup;

import org.jsoup.nodes.Document;
import java.io.IOException;
import java.util.stream.Collectors;

public class alllinksStreamExample {

    public static void main(String[] args) {
        String url = "https://www.flipkart.com/";

        try {
            Document document = Jsoup.connect(url).get();

            // Extract links using functional programming concepts
            document.select("a[href]")
                    .stream()
                    .map(link -> link.attr("abs:href"))
                    .forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}