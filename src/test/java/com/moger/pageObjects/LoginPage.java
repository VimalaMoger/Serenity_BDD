package com.moger.pageObjects;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;


@DefaultUrl("https://book-v9.onrender.com/")
public class LoginPage extends PageObject {


    @FindBy(name = "email")
    private WebElementFacade emailField;

    @FindBy(name = "password")
    private WebElementFacade passwordField;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElementFacade btnLogin;

    @FindBy(xpath = "//p[1]/span")
    private WebElementFacade errorMessageElement;

    @FindBy(xpath = "//div/a[@href='javascript:history.back()']")
    private WebElementFacade btnPreviousPage;

    @FindBy(xpath = "/html/body/div/div[3]/div[3]/a[@href='/users/logout']")
    private WebElementFacade btnLogout;

    public void login(String email, String password) {
        waitFor(emailField);
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
    }

    public void buttonClick() {
        btnLogin.click();
    }

    public void previousButtonClick() {
        btnPreviousPage.click();
    }

    public void logoutButton () {

        btnLogout.click();
    }

    public String getMessageError(){
        waitFor(errorMessageElement);
        return errorMessageElement.getTextContent();
    }
}
