package step_defs.flights;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import step_defs.BaseStep;

import static org.assertj.core.api.BDDAssertions.then;

public class FlightsBookingPage extends BaseStep {

	private static final Logger LOGGER = LogManager.getLogger(FlightsBookingPage.class);

	@Then("The user should see that {string} text")
	public void theUserShouldSeeThatText(String titleOfBookingPage) {
		then(PAGES.getFlightsBookingPage().getTitleOfBookingPage()).isEqualTo(titleOfBookingPage)
			.withFailMessage("The select who's flying button is not working on the result page");

	}

	@And("The user should see that only {string} and {string} are displayed")
	public void theUserShouldSeeThatOnlyAndAreDisplayed(String fromDepartureToArrival, String fromArrivalToDeparture) {
		then(PAGES.getFlightsBookingPage().getFromDepartureCountryToArrivalCountry()).isEqualTo(fromDepartureToArrival);
		then(PAGES.getFlightsBookingPage().getFromArrivalCountryToDepartureCountry()).isEqualTo(fromArrivalToDeparture);
	}

	@And("The user should see that only {string} on the tickets")
	public void theUserShouldSeeThatOnlyOnTheTickets(String tripType) {
		then(PAGES.getFlightsBookingPage().getTextOfTripType()).isEqualTo(tripType)
			.withFailMessage("The trip type is wrong!");
	}

	@And("The user should see that taxes are calculated truly")
	public void theUserShouldSeeThatTaxesAreCalculatedTruly() {
		then(PAGES.getFlightsBookingPage().isEqualToTotalPrice()).isTrue().withFailMessage("The taxes are not correct");
	}

	@When("The user enters  as {string} email and  as {string} phone number")
	public void theUserEntersAsEmailAndAsPhoneNumber(String email, String phoneNumber) {
		PAGES.getFlightsBookingPage().enterEmail(email);
		PAGES.getFlightsBookingPage().enterPhoneNumber(phoneNumber);
	}

	@And("The user enters as {string} first name and as {string} last name")
	public void theUserEntersAsFirstNameAndAsLastName(String firstName, String lastName) {
		PAGES.getFlightsBookingPage().enterFirstName(firstName);
		PAGES.getFlightsBookingPage().enterLastName(lastName);
	}

	@And("The user select gender as {string} and birthdate as {string} year and {string} month and {string} day")
	public void theUserSelectGenderAsAndBirthdateAsYearAndMonthAndDay(String gender, String year, String month,
			String day) {
		PAGES.getFlightsBookingPage().selectGender(gender);
		PAGES.getFlightsBookingPage().selectBirthDate(year, month, day);
	}

	@And("The user clicks on select extras button")
	public void theUserClicksOnSelectExtrasButton() {
		PAGES.getFlightsBookingPage().clickOnExtraButton();
	}

}
