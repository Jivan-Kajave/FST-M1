package Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Activity4 extends BaseClass {

    @Test
    public void addNewEmployee(){
        setUp();
        login();

        //Click PIM
        driver.findElement(By.id("menu_pim_viewPimModule")).click();
        //Click Add
        driver.findElement(By.id("btnAdd")).click();
        //Enter first name
        driver.findElement(By.id("firstName")).sendKeys("FirstName");
        //Enter last name
        driver.findElement(By.id("lastName")).sendKeys("LastName");
        //Get Employee id
        String employeeID = driver.findElement(By.id("employeeId")).getAttribute("value");
        //Click Save
        driver.findElement(By.id("btnSave")).click();

        //Click Employee list
        driver.findElement(By.id("menu_pim_viewEmployeeList")).click();
        //Enter Employee Id
        driver.findElement(By.id("empsearch_id")).sendKeys(employeeID);
        //Click Search
        driver.findElement(By.id("searchBtn")).click();
        //As we are searching by employee id only 1 record should be found i.e 1 row and 8 column in table
        List<WebElement> tableResult = driver.findElements(By.xpath("//table[@id = 'resultTable']/tbody/tr/td"));
        Assert.assertEquals(tableResult.size(), 8, "No record found for " + employeeID);

        tearDown();
    }
}