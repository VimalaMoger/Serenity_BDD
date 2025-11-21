package com.moger.steps;

import com.moger.actions.LoginNavigateSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;


public class LoginStepDefinitions {

    @Steps
    LoginNavigateSteps navigate;

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page () {

        navigate.opensTheHomePage();
    }

    @When("the user enters email as {string} and password as {string}")
    public void the_user_enters_email_and_password (String email, String password) {

        navigate.performLogin(email, password);
    }

    @And("clicks the login button")
    public void clicks_the_login_button () {

        navigate.clickLoginButton();
    }

    // @ValidCredentials
    @Then("the user should be redirected to the next page")
    public void the_user_should_be_redirected_to_the_next_page () {

        navigate.nextPage();
    }

    @Then("the user clicks logout button")
    public void the_user_clicks_logout_button () {
        navigate.logOut();
    }

    //  @InvalidCredentials
    @Then("the user should be able to see error message {string} on the error page")
    public void the_user_should_be_able_to_see_error_message_on_the_error_page (String errorMessage) {

        assertThat(navigate.userOnErrorPage().contains(errorMessage));
    }

    //   @InvalidCredentials
    @When("clicks Previous page button")
    public void clicks_previous_page_button () {
        navigate.goBack();
    }

    //   @InvalidCredentials
    @Then("the user should be directed to the login page")
    public void the_user_should_be_directed_to_the_login_page () {

        navigate.returnLoginPage();
        assertEquals("Login Form", navigate.getTitle());
        assertEquals("Login Form", navigate.getDriver().getTitle());
    }

    // @WrongPassword
    @Then("the user should be able to see alert message {string}")
    public void the_user_should_be_able_to_see_alert_message (String loginError) {

        assertEquals(loginError, navigate.getAlertMessage().getText());

    }
}