package practice;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class allLinksParallelStream {

    public static void main(String[] args) {
        String url = "https://www.flipkart.com/";

        try {
            Document document = Jsoup.connect(url).get();

            // Extract links using parallel stream
            List<String> links = document.select("a[href]")
                    .parallelStream()
                    .map(link -> link.attr("abs:href"))
                    .collect(Collectors.toList());

            links.forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

