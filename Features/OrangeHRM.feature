Feature: HRMAssignment
  Scenario: Successfully login with valid credentials
    Given User launch Chrome browser
    When User open url "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
    And User Enter Email as "Admin" and password as "admin123"
    And Click on Login
    Then Page Title Should be "OrangeHRM"
    Then User click on Claim menu
    Then User validate page title claim
    And User click on Assign Claim button
    And User enter the claim request Details
    Then User click on Create button
    Then User validate the the claim confirmation message
    Then User validate the raised claim in Record
    Then User click on Log out link
    Then Page Title  should be "OrangeHRM" after logout
    And close browser