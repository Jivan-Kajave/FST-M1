from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
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

    # Click on Leave option
    driver.find_element(By.ID, "menu_leave_viewLeaveModule").click()

    # Click on the Apply option
    driver.find_element(By.ID, "menu_leave_applyLeave").click()

    # Select leave type
    driver.find_element(By.ID, "applyleave_txtLeaveType").send_keys("DayOff")

    # Select duration of the leave
    driver.find_element(By.ID, "applyleave_txtFromDate").send_keys("2024-06-10")
    driver.find_element(By.ID, "applyleave_txtToDate").send_keys("2024-06-11")

    # Click Apply
    driver.find_element(By.ID, "applyBtn").click()

# Close the browser
driver.quit()
