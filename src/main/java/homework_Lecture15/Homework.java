package homework_Lecture15;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Homework {

    WebDriver driver;
    WebDriverWait smallWait;
    WebDriverWait longWait;
    private String baseUrl = "http://the-internet.herokuapp.com/";
    @BeforeMethod
    void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        smallWait = new WebDriverWait(driver, Duration.ofSeconds(3));
        longWait =  new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void testCheckBox() {
        driver.get(baseUrl + "/checkboxes");
        WebElement checkbox1 = driver.findElement(By.xpath("(//form/input[@type='checkbox'])[1]"));
        boolean checkbox1State = checkbox1.isSelected();
        checkbox1.click();
        WebElement checkbox2 = driver.findElement(By.xpath("(//form/input[@type='checkbox'])[2]"));
        boolean checkbox2State = checkbox2.isSelected();
        checkbox2.click();
        Assert.assertEquals(checkbox1State, !checkbox1.isSelected());
        Assert.assertEquals(checkbox2State, !checkbox2.isSelected());
    }

    @Test
    public void dropdown() {
        driver.get(baseUrl + "/dropdown");
        WebElement dropdown = driver.findElement(By.id("dropdown"));
        Select select = new Select(dropdown);
        WebElement firstOption = select.getFirstSelectedOption();
        String selectedOption0 = select.getFirstSelectedOption().getText();
        Assert.assertEquals(selectedOption0, "Please select an option");
        select.selectByVisibleText("Option 2");
        Assert.assertFalse(firstOption.isEnabled());
        String selectedOption = select.getFirstSelectedOption().getText();
        Assert.assertEquals(selectedOption, "Option 2");
    }
    @Test
    void dynamicLoadedPageElement() {
        driver.get(baseUrl + "/dynamic_loading/1");

        By startBtnLoc = By.xpath("//div[@id='start']/button[contains(text(),'Start')]");
        By loadingBarLoc = By.id("loading");
        List<WebElement> loadingBars = driver.findElements(loadingBarLoc);
        Assert.assertTrue(loadingBars.isEmpty());
        WebElement hello = driver.findElement(By.xpath("//div[@id='finish']/h4"));
        Assert.assertFalse(hello.isDisplayed());
        WebElement startBtn = driver.findElement(startBtnLoc);
        startBtn.click();
        longWait.until(ExpectedConditions.visibilityOfElementLocated(loadingBarLoc));
        longWait.until(ExpectedConditions.invisibilityOfElementLocated(loadingBarLoc));
        Assert.assertTrue(hello.isDisplayed());
        Assert.assertEquals(hello.getText(), "Hello World!");
    }
    @AfterMethod
    void cleanUp() {
        driver.quit();
    }

}
