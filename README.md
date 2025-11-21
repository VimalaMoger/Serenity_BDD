# UI Test Automation with Serenity BDD (Selenium / Cucumber)

- UI Test Automation with Serenity BDD
    - [Application under Test](https://github.com/VimalaMoger/Serenity_BDD#application-under-test)
      - [Scenarios to Automate](https://github.com/VimalaMoger/Serenity_BDD#scenarios-to-automate)
        - Login Page
        - Register Page       
      - [Project Structure](https://github.com/VimalaMoger/Serenity_BDD#project-structure)
      - [Dependencies](https://github.com/VimalaMoger/Serenity_BDD#dependencies)
      - [Running the tests under Maven](https://github.com/VimalaMoger/Serenity_BDD#running-the-tests-under-maven)
      - [Viewing the reports](https://github.com/VimalaMoger/Serenity_BDD#viewing-the-reports)
    

## Application under Test
Testing the UI of ThrillioWeb App

## Scenarios to Automate
Test covers the workflow of opening the login page, creating new user, login to resources, and logout

Login page:<br>

![Login Page](/assets/loginPage.PNG)

Registration page<br>

![Register Page](/assets/registerPage.PNG)

## Project Structure
------------------------------------
src/test/resources/features            
- login
    - user_login.feature
- register
    - user_register.feature 

src/test/java
- actions
    - RegisterNavigateSteps.java
    - LoginNavigateSteps.java
- AcceptanceTest.java
- pageObjects
    - LoginPage.java
    - RegisterPage.java
- steps
    - RegisterStepDefinitions.java
    - LoginStepDefinitions.java
-------------------------------------

### Dependencies
```spring-boot-starter-parent/starter-test, serenity-cucumber, maven-compiler-plugin, maven-surefire-plugin, maven-failsafe-plugin```

### Running the tests under Maven

Maven command from cmd window
```
mvn clean verify serenity:aggregate
```

### Viewing the reports
[Serenity test reports](/target/site/serenity/index.html)
