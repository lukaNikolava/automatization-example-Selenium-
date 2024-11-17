package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\admin\\Desktop\\chromedriver-win64\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();


        driver.get("https://www.youtube.com");


        driver.manage().window().maximize();


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {

            WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("search_query")));
            searchBox.sendKeys("Hollow purple Satoru Gojo edit");


            WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("search-icon-legacy")));
            searchButton.click();


            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("ytd-video-renderer")));

            List<WebElement> videoResults = driver.findElements(By.cssSelector("ytd-video-renderer #video-title"));


            if (!videoResults.isEmpty()) {
                WebElement firstVideo = videoResults.get(0);
                wait.until(ExpectedConditions.elementToBeClickable(firstVideo)).click();
                System.out.println("Clicked on the first video.");
            } else {
                System.out.println("No videos found.");
            }



        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
