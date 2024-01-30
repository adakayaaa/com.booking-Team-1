package step_defs.flights;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import step_defs.BaseStep;

import static org.assertj.core.api.BDDAssertions.then;

public class FlightsBookingPage extends BaseStep {

    @Then("The user should see that {string} text")
    public void theUserShouldSeeThatText(String titleOfBookingPage) {
        then(PAGES.getFlightsBookingPage().getTitleOfBookingPage()).isEqualTo(titleOfBookingPage).
                withFailMessage("The select who's flying button is not working on the result page");
    }


    @And("The user should see that only {string} and {string} are displayed")
    public void theUserShouldSeeThatOnlyAndAreDisplayed(String fromDepartureToArrival, String fromArrivalToDeparture) {
        then(PAGES.getFlightsBookingPage().getFromDepartureCountryToArrivalCountry()).isEqualTo(fromDepartureToArrival);
        then(PAGES.getFlightsBookingPage().getFromArrivalCountryToDepartureCountry()).isEqualTo(fromArrivalToDeparture);
    }

    @And("The user should see that only {string} on the tickets")
    public void theUserShouldSeeThatOnlyOnTheTickets(String tripType) {
        then(PAGES.getFlightsBookingPage().getTextOfTripType()).isEqualTo(tripType).withFailMessage("The trip type is wrong!");
    }
}
