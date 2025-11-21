package com.moger.actions;

import com.moger.pageObjects.LoginPage;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.steps.UIInteractionSteps;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class LoginNavigateSteps extends UIInteractionSteps {

    LoginPage loginPage;

    @Step("User opens the ThrillioWeb home page")
    public void opensTheHomePage () {

        loginPage.open();
    }

    @Step("User enters the required credentials")
    public void performLogin (String email, String password) {

        loginPage.login(email, password);
    }

    @Step("After entering credentials, user clicks login button")
    public void clickLoginButton () {

        loginPage.buttonClick();
    }

    // @ValidCredentials
    @Step("User should see Books resource page")
    public void nextPage () {

        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(1000));
        wait.until(ExpectedConditions.urlContains("books"));
    }

    // @ValidCredentials
    @Step("user logs out from books resource page")
    public void logOut () {

        loginPage.logoutButton();
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(1000));
        wait.until(ExpectedConditions.urlContains("/users/logout"));
    }

    // @InvalidCredentials
    @Step("If user lands on Error page")
    public String userOnErrorPage () {

        return loginPage.getMessageError();
    }

    // @InvalidCredentials
    @Step("User clicks 'Previous page' button on Error page")
    public void goBack () {

        loginPage.previousButtonClick();
    }

    // @InvalidCredentials
    @Step("Wait until the home page renders")
    public void returnLoginPage () {

        WebDriverWait wait = new WebDriverWait(getDriver(),Duration.ofSeconds(1000));
        wait.until(ExpectedConditions.urlContains("/"));
    }

    // @WrongPassword
    @Step("Alert message for wrong password")
    public WebElement getAlertMessage () {

        WebElement msg = loginPage.getDriver().findElement(By.className("error"));
        return msg;
    }

}

