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

    # Navigate to the OrangeHRM page
    driver.get("http://alchemy.hguy.co/orangehrm")

    # Wait for the header image to be visible
    header_image = WebDriverWait(driver, 10).until(
        expected_conditions.visibility_of_element_located((By.XPATH, "//div[@id='divLogo']/img"))
    )

    # Get the url of the header image
    header_image_url = header_image.get_attribute("src")

    # Print the url to the console
    print("URL of the header image:", header_image_url)

