package com.moger.actions;

import com.moger.pageObjects.RegisterPage;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.steps.UIInteractionSteps;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class RegisterNavigateSteps extends UIInteractionSteps {

    RegisterPage registerPage;

    @Step("User opens the ThrillioWeb home page")
    public void opensTheHomePage () {

        registerPage.open();
    }

    @Step("User click 'Register here' button on the Login page")
    public void clickRegisterHereButton () {

        WebElement link = registerPage.getDriver().findElement(org.openqa.selenium.By.tagName("a"));
        link.click();
    }

    @Step("User enters the required information on Registration Form page")
    public void performAddUser (String email, String password, String firstName, String lastName) {

        registerPage.login(email, password,firstName,lastName);
    }

    @Step("After entering credentials, user clicks Register button")
    public void clickRegisterButton () {

        registerPage.buttonClick();
    }

    // @ValidAddUserCredentials
    @Step("Success message is displayed on the screen")
    public WebElement getAlertMessage_success () {

        WebElement msg = registerPage.getDriver().findElement(By.tagName("span"));
        return msg;
    }

    // @EmailAlreadyExists, @InvalidEmail
    @Step("If user lands on Error page, get error message")
    public String userOnErrorPage () {

        return registerPage.getMessageError();
    }

    // @EmailAlreadyExists, @InvalidEmail
    @Step("User clicks 'Previous page' button")
    public void goBack () {

        registerPage.previousButtonClick();
    }

    // @EmailAlreadyExists, @InvalidEmail
    @Step("User returns to register page again")
    public void returnToRegisterPage () {

        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(1000));
        wait.until(ExpectedConditions.urlContains("/users/new"));
    }
}

