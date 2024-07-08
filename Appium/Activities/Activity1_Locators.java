package activities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;

public class Activity1_Locators {

    AndroidDriver driver;
    WebDriverWait wait;;

    // Set up method
    @BeforeClass
    public void setUp() throws MalformedURLException {
        // Desired Capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.miui.calculator");
        options.setAppActivity(".cal.CalculatorActivity");
        options.noReset();

        // Server Address
        URL serverURL = new URL("http://localhost:4723/wd/hub");

        // Driver Initialization
        driver = new AndroidDriver(serverURL, options);
    }

    @Test
    public void multiplyTest(){
        //Find the Number 8 and tap it
        driver.findElement(AppiumBy.id("com.miui.calculator:id/btn_8_s")).click();
        //Find the Multiply button and tap it
        driver.findElement(AppiumBy.xpath("//android.widget.ImageView[@content-desc=\"multiply\"]")).click();
        //Find the Number 5 and tap it
        driver.findElement(AppiumBy.id("com.miui.calculator:id/btn_5_s")).click();
        //Find the Multiply button and tap it
        driver.findElement(AppiumBy.accessibilityId("multiply")).click();
        //Find the Number 10 and tap it
        driver.findElement(AppiumBy.id("com.miui.calculator:id/btn_1_s")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.miui.calculator:id/btn_0_s\"]")).click();
        //Find the Equals button and tap it
        driver.findElement(AppiumBy.accessibilityId("equals")).click();
        //Get the Calculated result
        String calculatedResult = driver.findElement(AppiumBy.id("com.miui.calculator:id/result")).getText();
        //Assertion
        Assert.assertEquals(calculatedResult, "= 400");
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

}