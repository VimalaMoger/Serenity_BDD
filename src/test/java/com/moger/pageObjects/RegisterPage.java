package com.moger.pageObjects;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

@DefaultUrl("https://book-v9.onrender.com/")
public class RegisterPage extends PageObject {

    //@FindBy(linkText = "Register here")
           // "row//div[/span/a[@href='/users/new']")
    @FindBy(xpath = "//div[@class='row']/form/div[4]/span/a[@href='javascript:history.back()']")
    private WebElementFacade registerButtonOnLoginPage;

    @FindBy(name = "email")
    private WebElementFacade emailField;

    @FindBy(name = "password")
    private WebElementFacade passwordField;

    @FindBy(name = "firstName")
    private WebElementFacade firstNameField;

    @FindBy(name = "lastName")
    private WebElementFacade lastNameField;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElementFacade btnRegister;

    @FindBy(xpath = "//p[1]/span")
    private WebElementFacade errorMessageElement;

    @FindBy(xpath = "//div/a[@href='javascript:history.back()']")
    private WebElementFacade btnPreviousPage;

    public void login(String email, String password, String firstName, String lastName) {
        waitFor(emailField);
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        firstNameField.sendKeys(firstName);
        lastNameField.sendKeys(lastName);
        //btnLogin.click();
    }

    public void registerButtonOnLoginPage() {
        registerButtonOnLoginPage.click();
    }

    public void buttonClick() {
        btnRegister.click();
    }

    public void previousButtonClick() {
        btnPreviousPage.click();
    }

    public String getMessageError(){
        waitFor(errorMessageElement);
        return errorMessageElement.getTextContent();
    }
}

