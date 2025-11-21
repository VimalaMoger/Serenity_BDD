package com.moger.steps;

import com.moger.actions.RegisterNavigateSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;


public class RegisterStepDefinitions {

    @Steps
    private RegisterNavigateSteps navigate;

    @Given("user register button on the login page")
    public void user_register_button_on_the_login_page () {
        navigate.opensTheHomePage();
        navigate.clickRegisterHereButton();
    }

    @And("the user enters email as {string} and password as {string} and firstname as {string} and lastname as {string}")
    public void the_user_enters_email_and_password_and_firstname_and_lastname (String email, String password,String firstName, String lastName) {
        navigate.performAddUser(email, password, firstName, lastName);
    }

    @When("user clicks the register button")
    public void user_clicks_the_register_button () {

        navigate.clickRegisterButton();
    }

    // @ValidAddUserCredentials
    @Then("the user should see a message {string}")
    public void the_user_should_be_redirected_to_the_next_page (String successMessage) {

        assertEquals(successMessage, navigate.getAlertMessage_success().getText());
    }

    // @EmailAlreadyExists, @InvalidEmail
    @Then("user should be able to see error message {string} on the error page")
    public void user_should_be_able_to_see_error_message_on_the_error_page (String errorMessage) {
        assertThat(navigate.userOnErrorPage().contains(errorMessage));
    }

    // @EmailAlreadyExists, @InvalidEmail
    @When("user clicks Previous page button")
    public void user_clicks_previous_page_button () {
        navigate.goBack();
    }

    // @EmailAlreadyExists, @InvalidEmail
    @Then("the user should be redirected to the register page")
    public void the_user_should_be_redirected_to_the_register_page () {

        navigate.returnToRegisterPage();

        assertEquals("Registration Form", navigate.getTitle());
        assertEquals("Registration Form", navigate.getDriver().getTitle());
    }
}
