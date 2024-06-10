Feature: HRMAssignment
  Scenario: Successfully login with valid credentials
    Given User launch Chrome browser
    When User open url "https://admin-demo.nopcommerce.com/login"
    And User Enter Email as "admin@yourstore.com" and password as "admin"
    And Click on Login
    Then Page Title Should be "Dashboard / nopCommerce administration"
    When User click on Log out link
    Then Page Title  should be "Your store. Login" after logout
    And close browser