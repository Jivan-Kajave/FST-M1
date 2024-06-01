from selenium import webdriver
from webdriver_manager.firefox import GeckoDriverManager
from selenium.webdriver.firefox.service import Service as FirefoxService

# Set up Firefox driver service
service = FirefoxService(GeckoDriverManager().install())

# Start the Driver
with webdriver.Firefox(service=service) as driver:

    # Navigate to the OrangeHRM page
    driver.get("http://alchemy.hguy.co/orangehrm")

    # Get the title of the website
    title = driver.title

    # Verify if the title matches "OrangeHRM" exactly
    if title == "OrangeHRM":
        print("Website title matches 'OrangeHRM'.")
    else:
        print("Website title does not match 'OrangeHRM'.")

    # Close the browser
    driver.quit()
