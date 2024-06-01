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

    # Navigate to the My Info page
    driver.find_element(By.ID, "menu_pim_viewMyDetails").click()

    # Click on the Emergency Contacts menu item
    driver.find_element(By.LINK_TEXT, "Emergency Contacts").click()

    # Retrieve information about all the contacts listed in the table
    contact_rows = driver.find_elements(By.XPATH, "//table[@id='emgcontact_list']//tr")[1:]  # Exclude header row
    for row in contact_rows:
        cells = row.find_elements(By.TAG_NAME, "td")
        contact_name = cells[0].text
        relationship = cells[1].text
        home_telephone = cells[2].text
        mobile_telephone = cells[3].text
        work_telephone = cells[4].text
        print(f"Contact Name: {contact_name}, Relationship: {relationship}, Home Phone: {home_telephone}, "
              f"Mobile Phone: {mobile_telephone}, Work Phone: {work_telephone}")

# Close the browser
driver.quit()
