from selenium import webdriver
from selenium.webdriver.firefox.service import Service as FirefoxService
from selenium.webdriver.common.by import By
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

    # Click on My Info menu item
    driver.find_element(By.ID, "menu_pim_viewMyDetails").click()

    # Click on the Edit button
    driver.find_element(By.ID, "btnSave").click()

    # Fill in the Name field
    driver.find_element(By.ID, "personal_txtEmpFirstName").clear()
    driver.find_element(By.ID, "personal_txtEmpFirstName").send_keys("Jivan")
    driver.find_element(By.ID, "personal_txtEmpLastName").clear()
    driver.find_element(By.ID, "personal_txtEmpLastName").send_keys("Kajave")

    # Select Gender
    driver.find_element(By.ID, "personal_optGender_1").click()

    # Click on the Nationality dropdown
    nationality_dropdown = driver.find_element(By.ID, "personal_cmbNation")
    nationality_dropdown.click()

    # Select Indian from the dropdown options
    indian_option = driver.find_element(By.XPATH, "//option[contains(text(),'Indian')]")
    indian_option.click()


    #Fill in the DOB field
    driver.find_element(By.ID, "personal_DOB").clear()
    driver.find_element(By.ID, "personal_DOB").send_keys("1995-11-02")

    # Click Save
    driver.find_element(By.ID, "btnSave").click()

# Close the browser
driver.quit()
