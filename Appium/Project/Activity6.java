package project;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import static activities.W3ActionsBase.doSwipe;

public class Activity6 {

    // Driver Declaration
    AndroidDriver driver;
    WebDriverWait wait;

    // Set up method
    @BeforeClass
    public void setUp() throws MalformedURLException {
        // Desired Capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.android.chrome");
        options.setAppActivity("com.google.android.apps.chrome.Main");
        options.noReset();

        // Server Address
        URL serverURL = new URL("http://localhost:4723/wd/hub");

        // Driver Initialization
        driver = new AndroidDriver(serverURL, options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        //Open Selenium Page
        driver.get("https://v1.training-support.net/selenium");
    }

    @Test(priority = 1)
    public void loginTestValid() throws InterruptedException {

        //Get width and height of the screen
        Dimension dim = driver.manage().window().getSize();
        Point start = new Point((int) (dim.getWidth() * 0.5), (int) (dim.getWidth() * 0.8));
        Point end = new Point((int) (dim.getHeight() * 0.5), (int) (dim.getHeight() * 0.4));

        //Wait for the page to load
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.Button[@text=\"Get Started!\"]")));

        //Scroll to the end of the page
        doSwipe(driver, start, end, 80);

        //Wait for To-Do Link and Click it
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@text=\"Popups\"]"))).click();

        Thread.sleep(5000);
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@text=\"Sign In\"]")).click();
        driver.findElement(AppiumBy.id("username")).sendKeys("admin");
        driver.findElement(AppiumBy.id("password")).sendKeys("password");
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@text=\"Log in\"]")).click();

        Assert.assertTrue(driver.findElement(AppiumBy.id("//android.widget.TextView[@text=\"Welcome Back, admin\"]")).isDisplayed());
    }

    @Test(priority = 2)
    public void loginTestInvalid() throws InterruptedException {

        driver.findElement(AppiumBy.xpath("//android.widget.Button[@text=\"Sign In\"]")).click();
        driver.findElement(AppiumBy.id("username")).clear();
        driver.findElement(AppiumBy.id("username")).sendKeys("admin1");
        driver.findElement(AppiumBy.id("password")).clear();
        driver.findElement(AppiumBy.id("password")).sendKeys("password1");
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@text=\"Log in\"]")).click();
        Assert.assertTrue(driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Invalid Credentials\"]")).isDisplayed());

    }
    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
