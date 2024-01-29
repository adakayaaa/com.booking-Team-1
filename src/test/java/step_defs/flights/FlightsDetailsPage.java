package step_defs.flights;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import step_defs.BaseStep;


import static org.assertj.core.api.BDDAssertions.then;

public class FlightsDetailsPage extends BaseStep {
    @When("The user clicks on the cheapest tab")
    public void theUserClicksOnTheCheapestTab() {
        PAGES.getFlightsDetailsPage().clickOnCheapestTab();
    }

    @Then("The user should see that fees of tickets are arranged from cheapest to highest")
    public void theUserShouldSeeThatFeesOfTicketsAreArrangedFromCheapestToHighest() {
        then(PAGES.getFlightsDetailsPage().isSortedFromCheapestToHighest()).isTrue().withFailMessage("Prices are not sorted!");

    }

    @When("The user click on fastest tab")
    public void theUserClickOnFastestTab() {
        PAGES.getFlightsDetailsPage().clickOnFastestTab();

    }


    @Then("The user should see that times of flights are arranged from fastest to slowest")
    public void theUserShouldSeeThatTimesOfFlightsAreArrangedFromFastestToSlowest() {
        then(PAGES.getFlightsDetailsPage().isSortableFromFastestToSlowest()).isTrue().withFailMessage("Times are not sorted!");

    }


    @When("The user selects from checkbox {string} in the cabin class")
    public void theUserSelectsFromCheckboxInTheCabinClass(String classType) {
        PAGES.getFlightsDetailsPage().clickOnAllCabinTypes();
    }

    @Then("The user should see only {string} on the tickets")
    public void theUserShouldSeeOnlyOnTheTickets(String classType) {
        then(PAGES.getFlightsDetailsPage().isEconomyCabin(classType)).isTrue().withFailMessage("The ticket type is not as expected!");

    }
}