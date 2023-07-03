package lecture14;

// Test scenario ID:1 - Successful register
// 1. Navigate to the Login page
// 2. Click 'Register' button
// 3. Check that the 'Sign up' header is displayed
// 4. Enter valid username. Validate that a green check is displayed after entering the value.
// 5. Enter valid email. Validate that a green check is displayed after entering the value.
// 6. Enter password. Validate that a green check is displayed after entering the value.
// 7. Confirm password . Validate that a green check is displayed after entering the value.
// 8. Click Sign in.
// 9. Validate a successful pop-up message
// 10. Validate that the user landed on http://training.skillo-bg.com/posts/all
// 11. Navigate to the Profile page
// 12. Validate that the username is correctly displayed on the Profile page

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Practice {
    private static ChromeDriver driver;
    private final String BASE_URL = "http://training.skillo-bg.com/";
    private final String HOME_URL = BASE_URL + "posts/all";
    private  final String REGISTER_URL = BASE_URL + "users/register";

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get(HOME_URL);
    }
    @Test
    public void registerNewUserTest(){
        System.out.println("1. Navigate to the Login page/navigate to the login btn");
        WebElement loginBtn = driver.findElement(By.id("nav-link-login"));
        clickElement(loginBtn);

        System.out.println("2. Click 'Register' button");
        WebElement registerBtn = driver.findElement(By.linkText("Register"));
        clickElement(registerBtn);

        System.out.println("3. Check that the 'Sign up' header is displayed");
        WebElement header = driver.findElement(By.tagName("h4"));
        String  actualHeaderText = header.getText();
        Assert.assertEquals(actualHeaderText,"Sign up", "Sign up header is not displayed" + actualHeaderText);

        System.out.println("4. Enter valid username. Validate that a green check is displayed after entering the value.");
        WebElement usernameField = driver.findElement(By.name("username"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOf(usernameField));
    }

    private void clickElement(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
        }

    @AfterMethod
    public void cleanUp(){
        driver.close();
    }
}
