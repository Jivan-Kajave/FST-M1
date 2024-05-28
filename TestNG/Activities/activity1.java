package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class activity1 {

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        // Set up the Firefox driver
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();

        // Open browser
        driver.get("https://v1.training-support.net");
    }

    @Test
    public void testTitleAndAboutUs() {
        // Assertion for page title
        String title = driver.getTitle();
        Assert.assertEquals(title, "Training Support");

        // Find the "About Us" Button on the page and click it
        driver.findElement(By.id("about-link")).click();

        // Assert the title of the new page
        String newPageTitle = driver.getTitle();
        Assert.assertEquals(newPageTitle, "About Training Support");
    }

    @AfterClass
    public void tearDown() {
        // Close the browser
        driver.quit();
    }
}
