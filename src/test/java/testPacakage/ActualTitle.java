package testPacakage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ActualTitle {
    WebDriver driver = new ChromeDriver();

    @Test
    public void test() {
        driver.manage().window().maximize();
        driver.get("https://duckduckgo.com/");

        String actualTitle = driver.getTitle();
        assertEquals("Google", actualTitle, "Page title does not match!");
    }
    @AfterTest
     public void close(){
     driver.quit();

    }




}
