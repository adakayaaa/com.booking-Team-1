package step_defs.flights;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import step_defs.BaseStep;
import utils.BrowserUtils;

import static org.assertj.core.api.BDDAssertions.then;

public class FlightsBookingPage extends BaseStep {

    private static final Logger LOGGER = LogManager.getLogger(FlightsBookingPage.class);

    @Then("The user should see that {string} text")
    public void theUserShouldSeeThatText(String titleOfBookingPage) {
        then(PAGES.getFlightsBookingPage().getTitleOfBookingPage()).withFailMessage("The select who's flying button is not working on the result page")
                .isEqualTo(titleOfBookingPage);
        LOGGER.debug("The user should see that title of booking page");


    }

    @And("The user should see that only {string} and {string} are displayed")
    public void theUserShouldSeeThatOnlyAndAreDisplayed(String fromDepartureToArrival, String fromArrivalToDeparture) {
        then(PAGES.getFlightsBookingPage().getFromDepartureCountryToArrivalCountry()).isEqualTo(fromDepartureToArrival);
        then(PAGES.getFlightsBookingPage().getFromArrivalCountryToDepartureCountry()).isEqualTo(fromArrivalToDeparture);
        LOGGER.debug("The user should see that only departure and arrival countries are displayed");
    }

    @And("The user should see that only {string} on the tickets")
    public void theUserShouldSeeThatOnlyOnTheTickets(String tripType) {
        then(PAGES.getFlightsBookingPage().getTextOfTripType()) .withFailMessage("The trip type is wrong!").isEqualTo(tripType);
        LOGGER.debug("The user should see that only selected trip type on the ticket");
    }

    @And("The user should see that taxes are calculated truly")
    public void theUserShouldSeeThatTaxesAreCalculatedTruly() {
        then(PAGES.getFlightsBookingPage().isEqualToTotalPrice()).withFailMessage("The taxes are not correct").isTrue();
        LOGGER.debug("The user should see that taxes are calculated truly");
    }

    @When("The user enters  as {string} email and  as {string} phone number")
    public void theUserEntersAsEmailAndAsPhoneNumber(String email, String phoneNumber) {
        PAGES.getFlightsBookingPage().enterEmail(email);
        PAGES.getFlightsBookingPage().enterPhoneNumber(phoneNumber);
        LOGGER.info("The user enters a valid email and a valid phone number");
    }

    @And("The user enters as {string} first name and as {string} last name")
    public void theUserEntersAsFirstNameAndAsLastName(String firstName, String lastName) {
        PAGES.getFlightsBookingPage().enterFirstName(firstName);
        PAGES.getFlightsBookingPage().enterLastName(lastName);
        LOGGER.info("The user enters a first name and a last name");
    }

    @And("The user select gender as {string} and birthdate as {string} year and {string} month and {string} day")
    public void theUserSelectGenderAsAndBirthdateAsYearAndMonthAndDay(String gender, String year, String month,
                                                                      String day) {
        PAGES.getFlightsBookingPage().selectGender(gender);
        PAGES.getFlightsBookingPage().selectBirthDate(year, month, day);
        LOGGER.info("The user selects a gender and then selects year,month, a day for birth date.");
    }

    @And("The user clicks on select extras button")
    public void theUserClicksOnSelectExtrasButton() {
        PAGES.getFlightsBookingPage().clickOnExtraButton();
        LOGGER.info("The user clicks on select extras button");
    }

    @When("The user enters  as invalid {string} email and  as invalid {string} phone number")
    public void theUserEntersAsInvalidEmailAndAsInvalidPhoneNumber(String email, String phoneNumber) {
        PAGES.getFlightsBookingPage().enterEmail(email);
        PAGES.getFlightsBookingPage().enterPhoneNumber(phoneNumber);
        LOGGER.info("The user enters an invalid email and a invalid phone number");
    }

    @Then("The user should see  alert message")
    public void theUserShouldSeeAlertMessage() {
        Alert alert = DRIVER.switchTo().alert();
        then(alert.getText()).withFailMessage("The user shouldn't click select extra button").isEqualTo("Please fill the following fields:");
        LOGGER.debug("The user should see  alert message");
    }
}

