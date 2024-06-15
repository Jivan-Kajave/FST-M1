package project;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import static activities.W3ActionsBase.doSwipe;


public class GoogleChromeProject_TestToDoList {
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
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        //Open Selenium Page
        driver.get("https://v1.training-support.net/selenium");
    }

    @Test
    public void webAppTest() throws InterruptedException {
        //Get width and height of the screen
        Dimension dim = driver.manage().window().getSize();
        Point start = new Point((int) (dim.getWidth() * 0.5), (int) (dim.getWidth() * 0.8));
        Point end = new Point((int) (dim.getHeight() * 0.5), (int) (dim.getHeight() * 0.6));

        //Wait for the page to load
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.Button[@text=\"Get Started!\"]")));

        //Scroll to the end of the page
        doSwipe(driver, start, end, 25);

        //Wait for To-Do Link and Click it
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.TextView[contains=(@text,'To-Do List')]"))).click();

        //Wait for the page to load
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.EditText[@resource-id='taskInput']")));

        //Find Elements on the page
        WebElement addTaskInput = driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id='taskInput']"));
        WebElement addTaskButton = driver.findElement(AppiumBy.xpath("//android.widget.Button[@text='Add Task']"));
        //Enter Task
        addTaskInput.sendKeys("Learn Java");
        addTaskButton.click();
        addTaskInput.sendKeys("Learn Selenium");
        addTaskButton.click();
        addTaskInput.sendKeys("Learn Appium");
        addTaskButton.click();

        //Clear the list
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Clear List']")).click();

        //Assertion
        List<WebElement> taskAdded = driver.findElements(AppiumBy.xpath(""));
        Assert.assertEquals(taskAdded.size(), 0);

    }

}
