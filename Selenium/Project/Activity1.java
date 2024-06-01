package Project;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;


public class Activity1 {
    WebDriver driver;
    String expectedTitle = "OrangeHRM";

    @BeforeClass
    public void setUp() {
        // Set up the Firefox driver
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();

        //Open browser
        driver.get("http://alchemy.hguy.co/orangehrm");
    }

    @Test
    public void testWebsiteTitle() {
        // Navigate to the URL
        driver.get("http://alchemy.hguy.co/orangehrm");

        // Get the title of the website
        String actualTitle = driver.getTitle();

        // Verify the title matches
        Assert.assertEquals(actualTitle, expectedTitle, "Website title does not match expected title");
    }

    @AfterClass
    public void tearDown() {
        // Close the browser
        driver.quit();
    }
}

