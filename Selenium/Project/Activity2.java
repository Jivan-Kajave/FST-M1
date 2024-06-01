package Project;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

public class Activity2 {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        // Set up the Firefox driver
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();

        // Open browser and navigate to the URL
        driver.get("http://alchemy.hguy.co/orangehrm");
    }

    @Test
    public void testHeaderImageURL() {
        // Find the header image element
        WebElement headerImage = driver.findElement(By.xpath("//div[@id='divLogo']//img"));

        // Get the src attribute of the header image
        String imageURL = headerImage.getAttribute("src");

        // Print the URL to the console
        System.out.println("URL of the header image: " + imageURL);
    }

    @AfterClass
    public void tearDown() {
        // Close the browser
        driver.quit();
    }
}