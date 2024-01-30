package step_defs.flights;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import step_defs.BaseStep;
import utils.BrowserUtils;

import static org.assertj.core.api.BDDAssertions.then;

public class FlightsResultPage extends BaseStep {

	@Then("The user should see title of the result page {string}")
	public void theUserShouldSeeTitleOfTheResultPage(String titleOfResultPage) {
		then(PAGES.getFlightsResultPage().getTitleOfResultPage()).isEqualTo(titleOfResultPage)
			.withFailMessage("The user couldn't select return ticket");
	}

	@And("The user click on Select Who's flying button")
	public void theUserClickOnSelectWhoSFlyingButton() {
		PAGES.getFlightsResultPage().clickOnSelectWhoFlyingButton();
	}

	@And("The user should see that adult number as {string} and children number as  {string} on the result page")
	public void theUserShouldSeeThatAdultNumberAsAndChildrenNumberAsOnTheResultPage(String countOfAdult,
			String countOfChildren) {
		then(PAGES.getFlightsResultPage().getCountOfAdult()).isEqualTo(Integer.parseInt(countOfAdult))
			.withFailMessage("The count of adult is wrong!");
		then(PAGES.getFlightsResultPage().getCountOfChildren()).isEqualTo(Integer.parseInt(countOfChildren))
			.withFailMessage("The count of children is wrong!");
	}

	@And("The user should see that only  {string} and  {string} are displayed")
	public void theUserShouldSeeThatOnlyAndAreDisplayed(String departureCountry, String arrivalCountry) {
		then(PAGES.getFlightsResultPage().getDepartureCountryToArrivalCountry().startsWith(departureCountry));
		then(PAGES.getFlightsResultPage().getDepartureCountryToArrivalCountry().endsWith(arrivalCountry));
		then(PAGES.getFlightsResultPage().getArrivalCountryToDepartureCountry().startsWith(arrivalCountry));
		then(PAGES.getFlightsResultPage().getArrivalCountryToDepartureCountry().endsWith(departureCountry));

	}

	// @And("The user should see that the ticket prices as expected on the mains")
	// public void theUserShouldSeeThatTheTicketPricesAsExpectedOnTheMains() {
	// then(PAGES.getFlightsDetailsPage().getTicketPrice()).isEqualTo(PAGES.getFlightsResultPage().getPriceOfMainForDeparture()).
	// withFailMessage("The departure prices are not equal!");
	// then(PAGES.getFlightsDetailsPage().getTicketPrice()).isEqualTo(PAGES.getFlightsResultPage().getPriceOfMainForArrival()).
	// withFailMessage("The arrival prices are not equal!");
	// BrowserUtils.wait(5);
	// }

}
