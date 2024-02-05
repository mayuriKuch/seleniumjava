package practice;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class alllinksLamdaex {

    public static void main(String[] args) {
        String url = "https://www.flipkart.com/";

        try {
            Document document = Jsoup.connect(url).get();

            // Extract links using lambda expressions
            List<String> links = document.select("a[href]")
                    .stream()
                    .map(link -> link.attr("abs:href"))
                    .collect(Collectors.toList());

            links.forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

