Feature: User Register Functionality

  @ValidAddUserCredentials
  Scenario: Successful Register with Valid Credentials

    Given user register button on the login page
    When the user enters email as "<email>" and password as "<password>" and firstname as "user" and lastname as "new"
    And user clicks the register button
    Then the user should see a message "You have been successfully registered!"

    Examples:
      | email 		             | password     |
      | user61@semanticsquare.com | test	        |

  @EmailAlreadyExists
  Scenario Outline: Unsuccessful Register with valid Credentials

    Given user register button on the login page
    When the user enters email as "<email>" and password as "<password>" and firstname as "user" and lastname as "new"
    And user clicks the register button
    Then user should be able to see error message "<errorMessage>" on the error page
    When user clicks Previous page button
    And the user should be redirected to the register page

    Examples:
      | email                       | password  | errorMessage                                               |
      | user61@semanticsquare.com    | test      | Email already exists.Please enter a valid email address    |

  @InvalidEmail
    Scenario Outline: Unsuccessful Register with Invalid Email

      Given user register button on the login page
      When the user enters email as "<email>" and password as "<password>" and firstname as "user" and lastname as "new"
      And  user clicks the register button
      Then user should be able to see error message "<errorMessage>" on the error page
      When user clicks Previous page button
      And the user should be redirected to the register page

      Examples:
        | email           | password  | errorMessage                                          |
        | user@net        | test      | Invalid Email address. Please enter a valid format    |