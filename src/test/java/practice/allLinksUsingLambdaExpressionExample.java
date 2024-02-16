package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class allLinksUsingLambdaExpressionExample {

    public static void main(String[] args) {
      
        WebDriver driver = new ChromeDriver();

        // Navigate to the specified URL
        driver.get("https://www.flipkart.com/");

        // Retrieve all links using lambda expression and XPath
        List<String> links = driver.findElements(By.xpath("//a[@href]"))
                .stream()
                .map(link -> link.getAttribute("href"))
                .filter(href -> href != null && !href.isEmpty())
                .distinct()
                .toList();  // Collect to List (Java 9 and above)

        // Print the links
        links.forEach(System.out::println);

        // Close the browser
        driver.quit();
    }
}
