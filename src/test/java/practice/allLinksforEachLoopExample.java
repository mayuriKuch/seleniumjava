package practice;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class allLinksforEachLoopExample {

    public static void main(String[] args) {
     
        WebDriver driver = new ChromeDriver();

        // Navigate to the specified URL
        driver.get("https://www.flipkart.com/");

        // Retrieve all links using for-each loop
        List<WebElement> links = driver.findElements(By.tagName("a"));

        for (WebElement link : links) {
            String href = link.getAttribute("href");
            System.out.println(href);
        }

        // Close the browser
        driver.quit();
    }
}
