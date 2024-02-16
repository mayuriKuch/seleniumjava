package practice;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.List;
import java.util.stream.Collectors;

public class allLinksParallelStreamExample {

  
    public static void main(String [] args) {
       
        WebDriver driver = new ChromeDriver();

        // Navigate to the specified URL
        driver.get("https://www.flipkart.com/");

        // Retrieve all links with the href attribute using parallel stream and XPath
        List<String> links = driver.findElements(By.xpath("//a[@href]"))
                .parallelStream()
                .map(link -> link.getAttribute("href"))
                .filter(href -> href != null && !href.isEmpty())
                .distinct()
                .collect(Collectors.toList());

        // Print the links
        links.forEach(System.out::println);

        // Close the browser
        driver.quit();
    }
}
