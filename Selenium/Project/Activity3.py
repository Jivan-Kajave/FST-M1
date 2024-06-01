from selenium import webdriver
from webdriver_manager.firefox import GeckoDriverManager
from selenium.webdriver.firefox.service import Service as FirefoxService
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions

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

    # Wait for the homepage to load after login
    WebDriverWait(driver, 10).until(
        expected_conditions.title_is("OrangeHRM")
    )

    # Verify that the homepage has opened
    if "dashboard" in driver.current_url:
        print("Successfully logged in and reached the homepage.")
    else:
        print("Failed to login or reach the homepage.")

