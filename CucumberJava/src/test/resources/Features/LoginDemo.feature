Feature: Test Login Functionality

  Scenario Outline: Check login is successful with valid credentials
    Given user is on login page
    When user enters <username> and <password>
    And user clicks on login
    Then user is navigated to the home page

    Examples: 
      | username | password |
      | David    |    12345 |
 	    | Jenny    |    12346 |
