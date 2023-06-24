/*
package homework_Lecture12_WebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class firstTest {
    ChromeDriver driver;
    String URL = "http://training.skillo-bg.com/posts/all";

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
    @Test
    public void firstTest(){
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));

        WebElement homeLogoElement = driver.findElement(By.id("homeIcon"));
        Assert.assertTrue(homeLogoElement.isDisplayed(), "Logo icon is not visible");

        WebElement logBtn = driver.findElement(By.id("nav-link-login"));
        logBtn.click();

        //дава грешка с wait
        // String expectedLogin = "http://training.skillo-bg.com/users/login";
        //        wait.until(ExpectedConditions.urlToBe("expectedLogin"));


    }


    @AfterMethod
    public void closeURL(){
        driver.close();
    }
}

*/
