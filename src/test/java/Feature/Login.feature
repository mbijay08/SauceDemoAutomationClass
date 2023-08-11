Feature: Login to SauceDemo

  Scenario: Successful login with valid credentials
    Given user is on login page
    When user enters username "standard_user" and password "secret_sauce"
    And user clicks login button
    Then user should be on homepage
    And user should be able to see inventory count

  Scenario: Items successfully added in the checkout cart
    Given user is on homepage
    When user picks required items
    And user clicks checkout button
    And user inputs first name "firstname" and last name "lastname" and zip "12345"
    Then user is able to see all the added items in cart