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

    # Click on My Info menu item
    driver.find_element(By.ID, "menu_pim_viewMyDetails").click()

    # Click on Qualifications option on the left side menu
    driver.find_element(By.LINK_TEXT, "Qualifications").click()

    # Click on Add button
    driver.find_element(By.ID, "addWorkExperience").click()

    # Fill in the Work Experience form
    driver.find_element(By.ID, "experience_employer").send_keys("IBM India Pvt Ltd")
    driver.find_element(By.ID, "experience_jobtitle").send_keys("Software Engineer")
    driver.find_element(By.ID, "experience_from_date").send_keys("2020-01-01")
    driver.find_element(By.ID, "experience_to_date").send_keys("2024-06-01")
    driver.find_element(By.ID, "experience_comments").send_keys("Worked as a software engineer.")

    # Click Save
    driver.find_element(By.ID, "btnWorkExpSave").click()

# Close the browser
driver.quit()
