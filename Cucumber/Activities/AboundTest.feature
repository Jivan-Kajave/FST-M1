@aboundTest
Feature: AboundPageTest

  Scenario: TS Homepage test
    Given User is on the homepage
    When the user click on the About Us link
    Then the user is redirected to the Abound page
    Then close the browser
