from selenium import webdriver
from selenium.common import TimeoutException
from selenium.webdriver.firefox.service import Service as FirefoxService
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions
from webdriver_manager.firefox import GeckoDriverManager

# Set up Firefox driver
service = FirefoxService(GeckoDriverManager().install())

# Start the Driver
with webdriver.Firefox(service=service) as driver:
    # Navigate to the OrangeHRM login page
    driver.get("http://alchemy.hguy.co/orangehrm")

    # Find and enter the username
    driver.find_element(By.ID, "txtUsername").send_keys("orange")
    # Find and enter the password
    driver.find_element(By.ID, "txtPassword").send_keys("orangepassword123")
    # Click on the login button
    driver.find_element(By.ID, "btnLogin").click()

    # Click on PIM option
    driver.find_element(By.ID, "menu_pim_viewPimModule").click()

    # Click on the Add button to add a new employee
    driver.find_element(By.ID, "btnAdd").click()

    # Fill in the required fields for the new employee
    driver.find_element(By.ID, "firstName").send_keys("Tom")
    driver.find_element(By.ID, "lastName").send_keys("Hardy")
    driver.find_element(By.ID, "employeeId").clear()  # Clear any pre-filled data
    driver.find_element(By.ID, "employeeId").send_keys("000123")  # Employee ID
    driver.find_element(By.ID, "btnSave").click()

    # Navigate back to the PIM page (Employee List tab)
    driver.find_element(By.ID, "menu_pim_viewEmployeeList").click()

    # Search Employee with Employee ID
    driver.find_element(By.ID, "empsearch_id").send_keys("000123")

    # Click the Search button
    driver.find_element(By.ID, "searchBtn").click()

    # Employee id to verify
    employee_id = "000123"

    # XPath to locate the row containing the employee details
    employee_row_xpath = f"//table[@id='resultTable']//tr[contains(., '{employee_id}')]"

    # Wait for the search results to load
    try:
        WebDriverWait(driver, 20).until(
            expected_conditions.visibility_of_element_located((By.XPATH, employee_row_xpath))
        )
        print(f"Employee '{employee_id}' has been successfully added.")
    except TimeoutException:
        print(f"Failed to add employee '{employee_id}'.")

# Close the browser
driver.quit()
