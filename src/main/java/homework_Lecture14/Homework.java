package homework_Lecture14;


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
import java.util.List;

public class Homework {

    // test ID - Check number of posts, both in profile and personal

    ChromeDriver driver;

    private final String URL = "http://training.skillo-bg.com/posts/all";
    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        System.out.println("1. Navigate to Skillo page");
        driver.get(URL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }
    @Test
    public void loginTest() {

        System.out.println("2. Click login btn");
        WebElement loginBtn = driver.findElement(By.id("nav-link-login"));
        WebDriverWait waitLoginBtn = new WebDriverWait(driver, Duration.ofSeconds(2));
        waitLoginBtn.until(ExpectedConditions.visibilityOf(loginBtn));
        loginBtn.click();

        System.out.println("3. Validate that the URL is correct");
        String expectedLoginPageURL = "http://training.skillo-bg.com/users/login";
        WebDriverWait waitURL = new WebDriverWait(driver, Duration.ofSeconds(3));
        waitURL.until(ExpectedConditions.urlToBe(expectedLoginPageURL));

        System.out.println("4. Validate that the sign in text is visible");
        WebElement SignBtn = driver.findElement(By.xpath("//p[text()='Sign in']"));
        Assert.assertTrue(SignBtn.isDisplayed(), "Sign Btn icon is not visible");

        System.out.println("5. Enter user name");
        WebElement userName = driver.findElement(By.name("usernameOrEmail"));
        userName.clear();
        userName.sendKeys("IvaNik");

        System.out.println("6. Enter pass");
        WebElement pass = driver.findElement(By.id("defaultLoginFormPassword"));
        pass.clear();
        pass.sendKeys("adidas");

        System.out.println("7. Click sign in");
        WebElement signInBtn = driver.findElement(By.id("sign-in-button"));
        signInBtn.click();

        System.out.println("8. Check number of posts in profile");
        List<WebElement> posts = driver.findElements(By.cssSelector(".post-feed-img"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfAllElements(posts));
        System.out.println("The number of posts in profile is: " + posts.size());

        System.out.println("9. Check number of profile personal posts");
        WebElement profilePosts = driver.findElement(By.id("nav-link-profile"));
        wait.until(ExpectedConditions.visibilityOfAllElements(profilePosts));
        profilePosts.click();
        List<WebElement> personalPosts = driver.findElements(By.cssSelector(".post-img"));
        
        System.out.println("The number of personal posts is: " + personalPosts.size());
    }

    @AfterMethod
    public void cleanup() {
        driver.close();
    }
}
