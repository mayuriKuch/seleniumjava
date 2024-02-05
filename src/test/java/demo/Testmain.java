package demo;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Testmain {
    public static void main(String[] args) {
        try {
            // Step 1: Read data from Excel and store in HashMap 1
            String excelFilePath = "C:\\Users\\MAYURI\\OneDrive\\Desktop\\WU Assignment.xlsx";
            HashMap<String, Double> excelData = readDataFromExcel(excelFilePath);

            // Step 2: Read data using Selenium WebDriver and store in HashMap 2
            String url = "https://money.rediff.com/losers/bse/daily/groupall";
            HashMap<String, Double> webData = scrapeDataFromWebsite(url);

            // Step 3: Compare the values stored in the two HashMaps
            if (excelData.equals(webData)) {
                System.out.println("Values match!");
            } else {
                System.out.println("Values do not match.");
            }
        } catch (IOException e) {
        	
            e.printStackTrace();
        }
    }

    private static HashMap<String, Double> readDataFromExcel(String filePath) throws IOException {
        HashMap<String, Double> dataMap = new HashMap<>();
        FileInputStream fis = new FileInputStream("C:\\Users\\MAYURI\\OneDrive\\Desktop\\WU Assignment.xlsx");
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheetAt(0);

        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            String stockName = row.getCell(0).getStringCellValue();
            double stockPrice = row.getCell(1).getNumericCellValue();
            dataMap.put(stockName, stockPrice);
        }

        workbook.close();
        fis.close();
        return dataMap;
    }

    private static HashMap<String, Double> scrapeDataFromWebsite(String url) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://money.rediff.com/losers/bse/daily/groupall");

        HashMap<String, Double> dataMap = new HashMap<>();
        List<WebElement> stockElements = driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr"));

        for (WebElement stockElement : stockElements) {
            String stockName = stockElement.findElement(By.xpath(".//td[1]")).getText();
            double stockPrice = Double.parseDouble(stockElement.findElement(By.xpath(".//td[4]")).getText());
            dataMap.put(stockName, stockPrice);
        }

        driver.quit();
        return dataMap;
    }
}

