package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static org.junit.Assert.assertEquals;

public class AboundPageSteps {
    WebDriver driver;
    WebDriverWait wait;

    @Given("User is on the homepage")
    public void user_is_on_homepage() {
        //Create Instances
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        //Open browser
        driver.get("https://v1.training-support.net/");
    }

    @When("the user click on the About Us link")
    public void user_clicks_on_about_us_link() {
        driver.findElement(By.linkText("About Us")).click();
    }

    @Then("the user is redirected to the Abound page")
    public void the_user_is_redirected_to_the_abound_page() {
        assertEquals("https://v1.training-support.net/about", driver.getCurrentUrl());
    }


    @Then("close the browser")
    public void close_browser() {
        driver.quit();
    }
}

