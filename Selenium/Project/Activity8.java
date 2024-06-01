package Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

public class Activity8 extends BaseClass{

    @Test
    public void applyLeave(){
        setUp();
        login();

        // Click on Leave option
        driver.findElement(By.id("menu_leave_viewLeaveModule")).click();

        //Click on Apply option
        driver.findElement(By.id("menu_leave_applyLeave")).click();

        //Select leave type and duration of the leave
        driver.findElement(By.id("applyleave_txtLeaveType")).sendKeys("DayOff");
        driver.findElement(By.id("applyleave_txtFromDate")).sendKeys("2024-06-10");
        driver.findElement(By.id("applyleave_txtToDate")).sendKeys("2024-06-11");

        // Click on Apply Button
        driver.findElement(By.id("applyBtn")).click();

        // Navigate to the My Leave page
        driver.findElement(By.id("menu_leave_viewMyLeaveList")).click();

        // Check the status of the leave application
        WebElement leaveStatus = driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr[1]/td[6]"));
        System.out.println("Leave application status: " + leaveStatus.getText());

        tearDown();

    }
}



