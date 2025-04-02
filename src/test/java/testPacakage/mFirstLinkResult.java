package testPacakage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

import java.time.Duration;

public class mFirstLinkResult {
    WebDriver driver = new ChromeDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    @org.testng.annotations.Test
    public void verifyLink() {

        driver.manage().window().maximize();
        driver.get("https://duckduckgo.com/");
        //WebElement searchBox = driver.findElement(By.xpath("//input[@id='searchbox_input']"));
        //searchBox.sendKeys("Selenium WebDriver");

        WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='searchbox_input']")));
        searchBox.sendKeys("Selenium WebDriver");

        ////First option
       // WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement firstOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//li[@id='-363436486'])[1]")));
        firstOption.click();
       ///First Result Link
        //WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement firstResultLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='WebDriver - Selenium']")));
        firstResultLink.click();

       String currentUrl =  driver.getCurrentUrl();
       Assert.assertEquals(currentUrl,"https://www.selenium.dev/documentation/webdriver/");
       //System.out.println("Current URL: " + currentUrl);

    }
    @AfterTest
    void close(){
        driver.close();
    }
}

