package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.*;

public class activity2 {

    WebDriver driver;

    @BeforeTest
    public void setUp() {
        // Set up the Firefox driver
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();

        // Open browser
        driver.get("https://v1.training-support.net/selenium/target-practice");
    }

    @Test
    public void testCase1() {
        //This test case will pass
        String title = driver.getTitle();
        Assert.assertEquals(title, "Target Practice");
    }

    @Test
    public void testCase2() {
        //This test case will Fail
        Assert.assertTrue(driver.findElement(By.id("black")).isEnabled());
    }

    @Test(enabled = false)
    public void testCase3() {
        //This test will be skipped and not counted
        String subHeading = driver.findElement(By.className("sub")).getText();
        Assert.assertTrue(subHeading.contains("Practice"));
    }

    @Test
    public void testCase4() {
        // Skip this method by throwing a SkipException
        throw new SkipException("Skipping this test method");
    }

    @AfterTest
    public void tearDown() {
        // Close the browser
            driver.quit();
    }
}

