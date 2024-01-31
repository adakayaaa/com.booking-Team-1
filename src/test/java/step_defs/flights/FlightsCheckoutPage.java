package step_defs.flights;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import step_defs.BaseStep;

import static org.assertj.core.api.BDDAssertions.then;

public class FlightsCheckoutPage extends BaseStep {
    private static final Logger LOGGER = LogManager.getLogger(FlightsCheckoutPage.class);

    @And("The user enter as {string} cardholder's name")
    public void theUserEnterAsCardholderSName(String cardholderName) {
        PAGES.getFlightsCheckoutPage().enterCardholdersName(cardholderName);
        LOGGER.info("The user enter a cardholder's name");
    }

    @And("The user enter as {string} card number")
    public void theUserEnterAsCardNumber(String cardNumber) {
        PAGES.getFlightsCheckoutPage().enterCardNumber(cardNumber);
        LOGGER.info("The user enter a card number");
    }


    @And("The user enter as {string} expiration date")
    public void theUserEnterAsExpirationDate(String expirationDate) {
        PAGES.getFlightsCheckoutPage().enterExpirationDate(expirationDate);
        LOGGER.info("The user enter a expiration date");
    }


    @And("The user enter as {string} cvv code")
    public void theUserEnterAsCvvCode(String cvvCode) {
        PAGES.getFlightsCheckoutPage().enterCvvCode(cvvCode);
        LOGGER.info("The user enter a cvv code");
    }


    @And("The user clicks on Complete Booking button")
    public void theUserClicksOnCompleteBookingButton() {
        PAGES.getFlightsCheckoutPage().clickOnCompleteButton();
        LOGGER.info("The user click on the booking button");
    }

    @Then("The user should see {string} message and {string} name")
    public void theUserShouldSeeMessageAndName(String message, String name) {
        then(PAGES.getFlightsCheckoutPage().getThanksMessage().contains(message));
        then(PAGES.getFlightsCheckoutPage().getThanksMessage().contains(name));
        LOGGER.debug("The user  should see message of booking completed ");
    }

    @When("The user clicks on Close button")
    public void theUserClicksOnCloseButton() {
        PAGES.getFlightsCheckoutPage().clickOnCloseButton();
        LOGGER.info("The user click on the close button");
    }

    @Then("The user should see error message")
    public void theUserShouldSeeErrorMessage() {
        then(PAGES.getFlightsCheckoutPage().isErrorMessageDisplayed()).withFailMessage("The error message is not displayed!").isTrue();
        LOGGER.debug("The user should see error message");
    }

    @And("The user enter as {string} invalid expiration date")
    public void theUserEnterAsInvalidExpirationDate(String expirationDate) {
        PAGES.getFlightsCheckoutPage().enterExpirationDate(expirationDate);
        LOGGER.info("The user enter an invalid expiration date");
    }
}
