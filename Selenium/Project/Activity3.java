package Project;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class Activity3 {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        // Set up the Firefox driver
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();

        //Open browser
        driver.get("http://alchemy.hguy.co/orangehrm");
    }

    @Test
    public void loginTest() {
        // Login with credentials
        WebElement username = driver.findElement(By.id("txtUsername"));
        username.sendKeys("orange");

        WebElement password = driver.findElement(By.id("txtPassword"));
        password.sendKeys("orangepassword123");

        WebElement loginBtn = driver.findElement(By.id("btnLogin"));
        loginBtn.click();

        //Read login message
        String loginMessage = driver.findElement(By.id("welcome")).getText();
        Assert.assertEquals("Welcome Akanksha586", loginMessage);
    }

    @AfterClass
    public void tearDown() {
        //Close browser
        driver.close();
    }
}