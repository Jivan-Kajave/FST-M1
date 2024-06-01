package Project;

import org.openqa.selenium.By;
import org.testng.annotations.*;


public class Activity5 extends BaseClass {

        @Test
        public void editUserInformation(){
            setUp();
            login();

        // Click on My Info menu item
        driver.findElement(By.id("menu_pim_viewMyDetails")).click();

        // Click on Edit button
        driver.findElement(By.id("btnSave")).click();

        // Fill in Name, Gender, Nationality, and DOB fields
        driver.findElement(By.id("personal_txtEmpFirstName")).clear();
        driver.findElement(By.id("personal_txtEmpFirstName")).sendKeys("Rohit");
        driver.findElement(By.id("personal_txtEmpLastName")).clear();
        driver.findElement(By.id("personal_txtEmpLastName")).sendKeys("Sharma");
        driver.findElement(By.id("personal_optGender_1")).click();
        driver.findElement(By.id("personal_cmbNation")).sendKeys("Indian");
        driver.findElement(By.id("personal_DOB")).sendKeys("1988-05-10"); // Format as required

        // Click Save
        driver.findElement(By.id("btnSave")).click();

        tearDown();

    }
}


