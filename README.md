# UI Test Automation with Serenity BDD (Selenium / Cucumber)

- UI Test Automation with Serenity BDD
    - [Application under Test](https://github.com/VimalaMoger/Serenity_BDD/blob/main/README.md#Application under Test)
      - [Scenario to Automate](https://github.com/VimalaMoger/Serenity_BDD/blob/main/README.md#Scenarios to Automate)
        - Login Page
        - Register Page       
      - [Project Structure]((https://github.com/VimalaMoger/Serenity_BDD/blob/main/README.md#Project Structure)
      - [Running the tests under Maven](https://github.com/VimalaMoger/Serenity_BDD/blob/main/README.md#Running the tests under Maven)
      - [Viewing the reports](https://github.com/VimalaMoger/Serenity_BDD/blob/main/README.md#Viewing the reports)
      - Resources

## Application under Test
Testing the UI of ThrillioWeb App

## Scenarios to Automate
Test covers the workflow of opening the login page, creating new user, and login to resources

![Login Page](/assets/loginPage.PNG)

![Register Page](/assets/registerPage.PNG)

## Project Structure

src/test/resources/features
├──login
    └── user_login.feature
└──register
    └──user_register.feature 

src/test/java
├── actions
    ├── RegisterNavigateSteps.java
    └── LoginNavigateSteps.java
├── AcceptanceTest.java
├── pageObjects
│   ├── LoginPage.java
│   └── RegisterPage.java
└── steps
    ├── RegisterStepDefinitions.java
    └── LoginStepDefinitions.java

### Dependencies
```spring-boot-starter-parent/starter-test, serenity-cucumber, maven-compiler-plugin, maven-surefire-plugin, maven-failsafe-plugin```

### Running the tests under Maven
Maven command from cmd window
mvn clean verify serenity:aggregate

### Viewing the reports
Serenity test reports
