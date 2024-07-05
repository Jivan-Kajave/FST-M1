package activities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Activity5 {
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
        options.setAppPackage("com.android.mms");
        options.setAppActivity(".ui.MmsTabActivity");
        options.noReset();

        // Server Address
        URL serverURL = new URL("http://localhost:4723/wd/hub");

        // Driver Initialization
        driver = new AndroidDriver(serverURL, options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    // Test method
    @Test
    public void sendMessage() {
        // Find and click the add button
        driver.findElement(AppiumBy.accessibilityId("Compose")).click();

        // Find element to add Recipient
        //driver.findElement(AppiumBy.accessibilityId("Choose recipients")).click();

        // Find the element to add recipient
        driver.findElement(AppiumBy.id("com.android.mms:id/recipients_viewer")).click();
        driver.findElement(AppiumBy.id("com.android.mms:id/recipients_editor")).sendKeys("7030291009");
        // Click Save
        driver.findElement(AppiumBy.id("com.android.mms:id/confirm_recipient")).click();

        // Wait for textbox to appear
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.android.mms:id/embedded_text_editor")));

        // Enter text to send
        driver.findElement(AppiumBy.id("com.android.mms:id/embedded_text_editor")).click();
        driver.findElement(AppiumBy.id("com.android.mms:id/embedded_text_editor")).sendKeys("Hello from Appium");
        // Press Send
        driver.findElement(AppiumBy.accessibilityId("Send message")).click();

        // Assertion
        String messageTextSent = driver.findElement(AppiumBy.id("com.android.mms:id/message_body")).getText();
        Assert.assertEquals(messageTextSent, "Hello from Appium");
    }

    // Tear down method
    @AfterClass
    public void tearDown() {
        // Close the app
        driver.quit();
    }
}
