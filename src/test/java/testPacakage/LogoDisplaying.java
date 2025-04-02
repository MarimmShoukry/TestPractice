package testPacakage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertTrue;

public class LogoDisplaying {
    WebDriver driver = new ChromeDriver();

    @Test
    public void logoAssertion() {
        driver.manage().window().maximize();
        driver.get("https://duckduckgo.com/");

        //Boolean logo = driver.findElement(By.xpath("//a[@class=\"header_logoHorizontal__KABN4 header_logoText__d_X6V header_logoImg__85jCX\"]")).isDisplayed();
     // WebElement logo = driver.findElement(By.cssSelector("section[class='header_headerLeft__rW6nD header_headerSection___XMRI'] img"));
      // WebElement logo = driver.findElement(By.xpath("//a[@class=\"header_logoHorizontal__KABN4 header_logoText__d_X6V header_logoImg__85jCX\"]"));
        //assertTrue(logo.isDisplayed(), "Loge isn't displayed");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement logo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@class='header_headerLeft__rW6nD header_headerSection___XMRI']//img")));
        Assert.assertTrue(logo.isDisplayed(),"Logo isn't displayed. ");

    }

    @AfterTest
    public void close() {
       driver.quit();
    }
}