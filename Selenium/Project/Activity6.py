from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
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

    # Locate the navigation menu
    directory_menu = WebDriverWait(driver, 10).until(
    expected_conditions.visibility_of_element_located((By.ID, "menu_directory_viewDirectory"))
    )

    # Verify that the “Directory” menu item is visible
    if directory_menu.is_displayed():
        print("Directory menu item is visible.")
    else:
        print("Directory menu item is not visible.")

    # Verify that the “Directory” menu item is clickable
    if directory_menu.is_enabled():
        print("Directory menu item is clickable.")
        directory_menu.click()

        # Verify that the heading of the page matches “Search Directory”
        search_heading = WebDriverWait(driver, 10).until(
            expected_conditions.visibility_of_element_located((By.TAG_NAME, "h1"))
        )
        if search_heading.text == "Search Directory":
            print("Heading of the page matches 'Search Directory'.")
        else:
            print("Heading of the page does not match 'Search Directory'.")
    else:
        print("Directory menu item is not clickable.")

# Close the browser
driver.quit()
