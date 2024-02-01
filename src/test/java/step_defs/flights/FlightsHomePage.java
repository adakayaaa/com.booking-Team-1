package step_defs.flights;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import step_defs.BaseStep;
import utils.BrowserUtils;

import static org.assertj.core.api.BDDAssertions.then;

public class FlightsHomePage extends BaseStep {

	private static Logger LOGGER = LogManager.getLogger(FlightsHomePage.class);

	@When("the user clicks on the Flights tab")
	public void theUserClicksOnTheFlightsTab() {
		PAGES.getFlightsHomePage().clickOnFlightTab();
		LOGGER.info("The user is on the Flight Tab homepage");
	}

	@Then("the user should see that {string} message.")
	public void theUserShouldSeeThatMessage(String title) {
		then(title).isEqualTo(PAGES.getFlightsHomePage().getTitleOfFlightTab())
			.withFailMessage("the flight tab is not working properly");
		LOGGER.debug("The user should see that title of flight homepage");
	}

	@Given("The user is on the flights page")
	public void theUserIsOnTheFlightsPage() {
		PAGES.getFlightsHomePage().clickOnFlightTab();
		LOGGER.info("The user is on the Flight Tab homepage");
	}

	@When("The user clicks on the round way radio")
	public void theUserClicksOnTheRoundWayRadio() {
		PAGES.getFlightsHomePage().clickOnTheRoundTrip();
		LOGGER.info("The user is click the Round Trip radio on the flight homepage");
	}

	@And("The user selects departure as a {string}")
	public void theUserSelectsDepartureAsA(String departureCountry) {
		PAGES.getFlightsHomePage().selectDepartureCountry(departureCountry);
		LOGGER.info("The user selects departure country");
	}

	@And("The user selects return as a {string}")
	public void theUserSelectsReturnAsA(String returnCountry) {
		PAGES.getFlightsHomePage().selectReturnCountry(returnCountry);
		LOGGER.info("The user selects arrival country");
	}

	@And("The user selects departure date as {string} and return date as {string}")
	public void theUserSelectsDepartureDateAsAndReturnDateAs(String departureDate, String returnDate) {
		PAGES.getFlightsHomePage().clickOnDatePicker();
		PAGES.getFlightsHomePage()
			.selectDaysOnTheDatePicker(Integer.parseInt(departureDate), Integer.parseInt(returnDate));
		LOGGER.info("The user selects departure date and return date");
	}

	@And("The user determines adult number as {string} and children number as  {string}")
	public void theUserDeterminesAdultNumberAsAndChildrenNumberAs(String numberOfAdult, String numberOfChildren) {
		PAGES.getFlightsHomePage().clickOnThePlusButtonOfAdults(Integer.parseInt(numberOfAdult));
		PAGES.getFlightsHomePage().clickOnThePlusButtonOfChildren(Integer.parseInt(numberOfChildren));
		LOGGER.info("The user determines adult and children numbers");
	}

	@And("The user clicks on the search flights button")
	public void theUserClicksOnTheSearchFlightsButton() {
		PAGES.getFlightsHomePage().clickOnTheSearchFlightButton();
		LOGGER.info("The user clicks on the search flight button");
	}

	@Then("The user should see that {string} header text message is displayed")
	public void theUserShouldSeeThatHeaderTextMessageIsDisplayed(String headerText) {
		then(PAGES.getFlightsDetailsPage().getTitleOfDetailsPage())
			.withFailMessage("The user couldn't pass on the detail page!")
			.isEqualTo(headerText);
		LOGGER.debug("The user should see that title on the details page of the flight tab");
	}

	@And("The user should see that only list of {string} and {string} are displayed")
	public void theUserShouldSeeThatOnlyListOfAndAreDisplayed(String departureCountry, String arrivalCountry) {
		then(PAGES.getFlightsDetailsPage().isSelectedDepartureCountry(departureCountry)).isTrue();
		then(PAGES.getFlightsDetailsPage().isSelectedArrivalCountry(arrivalCountry)).isTrue();
		LOGGER.debug(
				"The user should see that list of the departure country and also arrival country on the details page of the flight tab");
	}

	@And("The user should see that only round way on the tickets")
	public void theUserShouldSeeThatOnlyRoundWayOnTheTickets() {
		then(PAGES.getFlightsDetailsPage().isRoundType()).withFailMessage("The type of trip is not round!").isTrue();
		LOGGER.debug("The user should see that only round way on the tickets on the details page of the flight tab");

	}

	@And("The user should see that only list of {string} is displayed")
	public void theUserShouldSeeThatOnlyListOfIsDisplayed(String departureDate) {
		then(PAGES.getFlightsDetailsPage().isDepartureDate(departureDate))
			.withFailMessage("The day is not departure day!")
			.isTrue();
		LOGGER.debug("The user should see that onliy list of departure date on the tickets");
	}

	@Then("The user should see {string}text")
	public void theUserShouldSeeText(String titleOfStayPage) {
		then(PAGES.getFlightsHomePage().getTitleOfStayPage()).withFailMessage("The close button is not working!")
			.isEqualTo(titleOfStayPage);
		LOGGER.debug("The user should see that title of stay page of the flight tab");
	}

}
