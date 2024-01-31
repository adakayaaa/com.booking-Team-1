package step_defs.flights;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pages.flights.FlightsFilteringPage;
import step_defs.BaseStep;
import utils.BrowserUtils;

import static org.assertj.core.api.BDDAssertions.then;

public class FlightsDetailsPage extends BaseStep {
    private static final Logger LOGGER = LogManager.getLogger(FlightsCheckoutPage.class);

    public static int departurePrice;
    public static int arrivalPrice;

    @When("The user clicks on the cheapest tab")
    public void theUserClicksOnTheCheapestTab() {
        PAGES.getFlightsDetailsPage().clickOnCheapestTab();
        LOGGER.info("The user clicks on the cheapest tab");
    }

    @Then("The user should see that fees of tickets are arranged from cheapest to highest")
    public void theUserShouldSeeThatFeesOfTicketsAreArrangedFromCheapestToHighest() {
        then(PAGES.getFlightsDetailsPage().isSortedFromCheapestToHighest()) .withFailMessage("Prices are not sorted!").isTrue();
        LOGGER.debug("The user should see that fees of tickets are arranged from cheapest to highest");
    }

    @When("The user click on fastest tab")
    public void theUserClickOnFastestTab() {
        PAGES.getFlightsDetailsPage().clickOnFastestTab();
        LOGGER.info("The user clicks on the fastest tab");
    }

    @Then("The user should see that times of flights are arranged from fastest to slowest")
    public void theUserShouldSeeThatTimesOfFlightsAreArrangedFromFastestToSlowest() {
        then(PAGES.getFlightsDetailsPage().isSortableFromFastestToSlowest()).withFailMessage("Times are not sorted!").isTrue();
        LOGGER.debug("The user should see that times of flights are arranged from fastest to slowest");
    }

    @When("The user selects from checkbox {string} in the cabin class")
    public void theUserSelectsFromCheckboxInTheCabinClass(String classType) {
        PAGES.getFlightsDetailsPage().clickOnAllCabinTypes();
        LOGGER.info("The user selects from checkbox all the cabin class");
    }

    @Then("The user should see only {string} on the tickets")
    public void theUserShouldSeeOnlyOnTheTickets(String classType) {
        then(PAGES.getFlightsDetailsPage().isBusinessCabin(classType)).withFailMessage("The ticket type is not as expected!").isTrue();
        LOGGER.debug("The user should see only business cabin on the tickets");
    }

    @And("The user click on cheapest tab")
    public void theUserClickOnCheapestTab() {
        BrowserUtils.scrollUpWithPageUp();
        PAGES.getFlightsDetailsPage().clickOnCheapestTab();
        LOGGER.info("The user clicks on the cheapest tab");
    }

    @And("The user click on cheapest ticket")
    public void theUserClickOnCheapestTicket() {
        departurePrice=PAGES.getFlightsDetailsPage().getTicketPrice();
        PAGES.getFlightsDetailsPage().clickOnSelectTicketButton();
        LOGGER.info("The user selects on the cheapest ticket");
    }

    @Then("The user should see return ticket button{string}")
    public void theUserShouldSeeReturnTicketButton(String returnTicketText) {
        then(PAGES.getFlightsDetailsPage().getTextOfSelectReturnTicket()).withFailMessage("The user couldn't select departure ticket!").isEqualTo(returnTicketText);
        LOGGER.debug("The user should see return ticket button");
    }

    @When("The user selects return ticket on the fastest flight")
    public void theUserSelectsReturnTicketOnTheFastestFlight() {
        arrivalPrice=PAGES.getFlightsDetailsPage().getTicketPrice();
        PAGES.getFlightsDetailsPage().clickOnSelectTicketButton();
        LOGGER.info("The user selects return ticket on the fastest flight");
    }

}