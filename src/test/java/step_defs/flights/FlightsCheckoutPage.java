package step_defs.flights;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import step_defs.BaseStep;

import static org.assertj.core.api.BDDAssertions.then;

public class FlightsCheckoutPage extends BaseStep {

    @And("The user enter as {string} cardholder's name")
    public void theUserEnterAsCardholderSName(String cardholderName) {
        PAGES.getFlightsCheckoutPage().enterCardholdersName(cardholderName);
    }

    @And("The user enter as {string} card number")
    public void theUserEnterAsCardNumber(String cardNumber) {
        PAGES.getFlightsCheckoutPage().enterCardNumber(cardNumber);
    }


    @And("The user enter as {string} expiration date")
    public void theUserEnterAsExpirationDate(String expirationDate) {
        PAGES.getFlightsCheckoutPage().enterExpirationDate(expirationDate);
    }


    @And("The user enter as {string} cvv code")
    public void theUserEnterAsCvvCode(String cvvCode) {
        PAGES.getFlightsCheckoutPage().enterCvvCode(cvvCode);
    }


    @And("The user clicks on Complete Booking button")
    public void theUserClicksOnCompleteBookingButton() {
        PAGES.getFlightsCheckoutPage().clickOnCompleteButton();
    }

    @Then("The user should see {string} message and {string} name")
    public void theUserShouldSeeMessageAndName(String message, String name) {
        then(PAGES.getFlightsCheckoutPage().getThanksMessage().contains(message));
        then(PAGES.getFlightsCheckoutPage().getThanksMessage().contains(name));
    }

    @When("The user clicks on Close button")
    public void theUserClicksOnCloseButton() {
        PAGES.getFlightsCheckoutPage().clickOnCloseButton();
    }
}
