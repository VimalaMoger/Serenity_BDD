Feature: User Login Functionality

  @ValidCredentials
  Scenario: Successful Login with Valid Credentials

    Given the user is on the login page
    When the user enters email as "<email>" and password as "<password>"
    And clicks the login button
    Then the user should be redirected to the next page
    Then the user clicks logout button
    And the user should be directed to the login page

    Examples:
      | email 		             | password     |
      | user1@semanticsquare.com | test	        |

  @InvalidCredentials
  Scenario Outline: Unsuccessful Login with Invalid Credentials

    Given the user is on the login page
    When the user enters email as "<wrongEmail>" and password as "<password>"
    And clicks the login button
    Then the user should be able to see error message "<errorMessage>" on the error page
    When clicks Previous page button
    And the user should be directed to the login page

    Examples:
      | wrongEmail      | password  | errorMessage                                                 |
      | user1@com.net    | test1     | User with email user@com.net does not exist in our system    |
      | user2@com.net    | test2     | User with email user@com.net does not exist in our system    |
      | user3@com.net    | test3     | User with email user@com.net does not exist in our system    |

  @WrongPassword
  Scenario: Login with wrong password

    Given the user is on the login page
    When the user enters email as "<email>" and password as "<wrongPassword>"
    And clicks the login button
    Then the user should be able to see alert message "<errorMessage>"

    Examples:
          | email                       | wrongPassword  | errorMessage                               |
          | user1@semanticsquare.com    | xyz            | Incorrect credentials. Please try again    |