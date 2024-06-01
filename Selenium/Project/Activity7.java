package Project;

import org.openqa.selenium.By;
import org.testng.annotations.*;

public class Activity7 extends BaseClass{

    @Test
    public void addQualifications(){
        setUp();
        login();

        // Click on My Info menu
        driver.findElement(By.id("menu_pim_viewMyDetails")).click();

        // Click on Qualifications option
        driver.findElement(By.xpath("//ul[@id='sidenav']//a[contains(text(),'Qualifications')]")).click();

        // Click on Add Work Experience
        driver.findElement(By.id("addWorkExperience")).click();

        // Fill in Work Experience details
        driver.findElement(By.id("experience_employer")).sendKeys("ABC Company");
        driver.findElement(By.id("experience_jobtitle")).sendKeys("Software Engineer");;
        driver.findElement(By.id("experience_from_date")).sendKeys("2024-01-01");
        driver.findElement(By.id("experience_to_date")).sendKeys("2024-12-31");

        // Save the work experience
        driver.findElement(By.id("btnWorkExpSave")).click();

        tearDown();

    }
}



