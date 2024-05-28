package activities;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.*;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class activity10 {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeClass
    public void setup() {
        // Setup WebDriver
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        // Open the website
        driver.get("https://v1.training-support.net/selenium/simple-form");
    }

    // Read data from Excel
    public static List<List<Object>> readExcel(String filePath) {
        List<List<Object>> data = new ArrayList<>();
        try {
            FileInputStream file = new FileInputStream(filePath);
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheetAt(0);

            for (Row row: sheet) {
                List<Object> rowData = new ArrayList<>();
                for(Cell cell: row) {
                    if(cell != null) {
                        switch (cell.getCellType()) {
                            case STRING:
                                rowData.add(cell.getStringCellValue());
                                break;
                            case NUMERIC:
                                rowData.add(cell.getNumericCellValue());
                                break;
                            case BOOLEAN:
                                rowData.add(cell.getBooleanCellValue());
                                break;
                        }
                    }
                }
                data.add(rowData);
            }
            file.close();
            workbook.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

    @DataProvider(name = "Registration")
    public static Object[][] signUpInfo() {
        String filePath = "C:\\Users\\003B4Y744\\IdeaProjects\\FST_TestNG\\src\\test\\java\\inputs\\activity10.xlsx";
        List<List<Object>> data = readExcel(filePath);
        return new Object[][] {
                { data.get(1) },
                { data.get(2) },
                { data.get(3) },
        };
    }

    @Test(dataProvider = "Registration")
    public void registrationTest(List<Object> rows) {
        WebElement firstNameField = driver.findElement(By.id("firstName"));
        WebElement lastNameField = driver.findElement(By.id("lastName"));
        WebElement emailField = driver.findElement(By.id("email"));
        WebElement phoneNumberField = driver.findElement(By.id("number"));

        // Clear fields
        firstNameField.clear();
        lastNameField.clear();
        emailField.clear();
        phoneNumberField.clear();

        // Enter data
        firstNameField.sendKeys(rows.get(1).toString());
        lastNameField.sendKeys(rows.get(2).toString());
        emailField.sendKeys(rows.get(3).toString());

        // Convert phone number to a common format
        String phoneNumber = rows.get(4).toString().replaceAll("[^0-9]", "");
        phoneNumberField.sendKeys(phoneNumber);

        // Click submit button
        driver.findElement(By.cssSelector("input.green")).click();

        // Wait for alert
        try {
            Alert message = wait.until(ExpectedConditions.alertIsPresent());
            System.out.println("Alert Message: " + message.getText());
            Reporter.log("Alert Message: " + message.getText());
            message.accept();
        } catch (Exception e) {
            System.out.println("Timeout waiting for alert.");
            Reporter.log("Timeout waiting for alert.");
            e.printStackTrace();
        }

        // Refresh the page
        driver.navigate().refresh();
    }

    @AfterClass
    public void teardown() {
        driver.quit();
    }
}