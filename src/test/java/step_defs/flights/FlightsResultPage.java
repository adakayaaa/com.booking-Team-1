package step_defs.flights;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import step_defs.BaseStep;
import utils.BrowserUtils;


import static org.assertj.core.api.BDDAssertions.then;

public class FlightsResultPage extends BaseStep {


    @Then("The user should see title of the result page {string}")
    public void theUserShouldSeeTitleOfTheResultPage(String titleOfResultPage) {
        then(PAGES.getFlightsResultPage().getTitleOfResultPage()).isEqualTo(titleOfResultPage).withFailMessage("The user couldn't select return ticket");
    }


//    @And("The user should see that the ticket prices as expected on the mains")
//    public void theUserShouldSeeThatTheTicketPricesAsExpectedOnTheMains() {
//        then(PAGES.getFlightsDetailsPage().getTicketPrice()).isEqualTo(PAGES.getFlightsResultPage().getPriceOfMainForDeparture()).
//                withFailMessage("The departure prices are not equal!");
//        then(PAGES.getFlightsDetailsPage().getTicketPrice()).isEqualTo(PAGES.getFlightsResultPage().getPriceOfMainForArrival()).
//                withFailMessage("The arrival prices are not equal!");
//        BrowserUtils.wait(5);
//    }
}
