package Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;
import java.util.List;

public class Activity9 extends BaseClass {

    @Test
    public void retrieveEmergencyContacts() {
        setUp();
        login();

        // Click on My Info menu
        driver.findElement(By.id("menu_pim_viewMyDetails")).click();

        // Click on the "Emergency Contacts" menu item
        driver.findElement(By.linkText("Emergency Contacts")).click();

        // Retrieve information about all the contacts listed in the table
        List<WebElement> contactRows = driver.findElements(By.xpath("//table[@id='emgcontact_list']/tbody/tr"));

        System.out.println("Emergency Contacts:");

        for (WebElement row : contactRows) {
            List<WebElement> columns = row.findElements(By.tagName("td"));
            String name = columns.get(1).getText();
            String relationship = columns.get(2).getText();
            String homeTelephone = columns.get(3).getText();
            String mobileTelephone = columns.get(4).getText();

            System.out.println("Name: " + name);
            System.out.println("Relationship: " + relationship);
            System.out.println("Home Telephone: " + homeTelephone);
            System.out.println("Mobile Telephone: " + mobileTelephone);
            System.out.println();
        }

        // Close the browser after all contacts are processed
        tearDown();
    }
}
