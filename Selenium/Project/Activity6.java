package Project;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

public class Activity6 extends BaseClass{

    @Test
    public void verifyDirectory() {
        setUp();
        login();

        // Locate the navigation menu
        WebElement directoryMenuItem = driver.findElement(By.id("menu_directory_viewDirectory"));

        // Verify that the "Directory" menu item is visible
        Assert.assertTrue(directoryMenuItem.isDisplayed(), "Directory menu item is not visible");

        // Verify that the "Directory" menu item is clickable
        Assert.assertTrue(directoryMenuItem.isEnabled(), "Directory menu item is not clickable");

        // Click on the "Directory" menu item
        directoryMenuItem.click();

        // Verify that the heading of the page matches "Search Directory"
        WebElement pageTitle = driver.findElement(By.xpath("//div[@class='head']/h1"));
        Assert.assertEquals(pageTitle.getText(), "Search Directory", "Page heading does not match");

        tearDown();

    }
}

