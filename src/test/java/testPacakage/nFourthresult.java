package testPacakage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertEquals;


public class nFourthresult {

    FirefoxDriver driver = new FirefoxDriver ();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    @Test
    public void fourth_option (){

        driver.manage().window().maximize();
        driver.get("https://duckduckgo.com/");

        WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='searchbox_input']")));
        searchBox.sendKeys("TestNG");

        WebElement fourthOption = wait .until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//ul[@role='list' and contains(@class, 'searchbox_suggestionList')]//li)[4]")));
        String actualtext = fourthOption.getText();

       //assertEquals(actualtext,"Text of the fourth result is incorrect.");
        assertEquals(actualtext, "TestNG Tutorial", "Text of the fourth result is incorrect.");

        //System.out.println(actualtext);
     //   System.out.println(fourthOption);

//        if (actualtext.equals("TestNG tutorial"))
//        {
//            System.out.println("Text of the fourth result matches.");}
//        else {
//            System.out.println(" Text of the fourth result is incorrect");
        }

    @AfterTest
    void close(){
        driver.close();
    }
}



