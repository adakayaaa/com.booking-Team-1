package step_defs.flights;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import step_defs.BaseStep;
import utils.BrowserUtils;

import static org.assertj.core.api.BDDAssertions.then;

public class FlightsResultPage extends BaseStep {

	private static Logger LOGGER = LogManager.getLogger(FlightsResultPage.class);

	@Then("The user should see title of the result page {string}")
	public void theUserShouldSeeTitleOfTheResultPage(String titleOfResultPage) {
		then(PAGES.getFlightsResultPage().getTitleOfResultPage())
			.withFailMessage("The user couldn't select return ticket")
			.isEqualTo(titleOfResultPage);
		LOGGER.debug("The user should see title of the result page");
	}

	@And("The user click on Select Who's flying button")
	public void theUserClickOnSelectWhoSFlyingButton() {
		PAGES.getFlightsResultPage().clickOnSelectWhoFlyingButton();
		LOGGER.info("The user  click on Select Who's flying button");
	}

	@And("The user should see that adult number as {string} and children number as  {string} on the result page")
	public void theUserShouldSeeThatAdultNumberAsAndChildrenNumberAsOnTheResultPage(String countOfAdult,
			String countOfChildren) {
		then(PAGES.getFlightsResultPage().getCountOfAdult()).withFailMessage("The count of adult is wrong!")
			.isEqualTo(Integer.parseInt(countOfAdult));
		LOGGER.debug("The user should see that adult number as expected");
		then(PAGES.getFlightsResultPage().getCountOfChildren()).withFailMessage("The count of children is wrong!")
			.isEqualTo(Integer.parseInt(countOfChildren));
		LOGGER.debug("The user should see that children number as expected");

	}

	@And("The user should see that only  {string} and  {string} are displayed")
	public void theUserShouldSeeThatOnlyAndAreDisplayed(String departureCountry, String arrivalCountry) {
		then(PAGES.getFlightsResultPage().getDepartureCountryToArrivalCountry().startsWith(departureCountry));
		then(PAGES.getFlightsResultPage().getDepartureCountryToArrivalCountry().endsWith(arrivalCountry));
		LOGGER.debug("The user should see that from departure country to arrival country is displayed as expected");

		then(PAGES.getFlightsResultPage().getArrivalCountryToDepartureCountry().startsWith(arrivalCountry));
		then(PAGES.getFlightsResultPage().getArrivalCountryToDepartureCountry().endsWith(departureCountry));
		LOGGER.debug("The user should see that from arrival country to departure country is displayed as expected");

	}

	@Then("The user should see that the ticket prices as expected on the mains")
	public void theUserShouldSeeThatTheTicketPricesAsExpectedOnTheMains() {
		then(FlightsDetailsPage.departurePrice).isEqualTo(PAGES.getFlightsResultPage().getPriceOfMainForDeparture())
			.withFailMessage("The departure prices are not equal!");
		LOGGER.debug("The user should see that the departure ticket prices as expected on the mains");

		then(FlightsDetailsPage.arrivalPrice).isEqualTo(PAGES.getFlightsResultPage().getPriceOfMainForArrival())
			.withFailMessage("The arrival prices are not equal!");
		LOGGER.debug("The user should see that the arrival ticket prices as expected on the mains");
	}

}
