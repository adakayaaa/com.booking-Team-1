package step_defs.flights;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import step_defs.BaseStep;

import static org.assertj.core.api.BDDAssertions.then;

public class FlightsHomePage extends BaseStep {

    @Given("the user is on the Inar Academy homepage")
    public void the_user_is_on_the_ınar_academy_homepage() {
        DRIVER.get("https://InarAcademy:Fk160621.@test.inar-academy.com/");

    }
    @And("the user clicks on the Booking link")
    public void theUserOnTheFlightHomePage() {
        PAGES.getHomePage().clickOnBookingLink();
    }

    @When("the user clicks on the Flights tab")
    public void theUserClicksOnTheFlightsTab() {
        PAGES.getFlightsHomePage().clickOnFlightTab();
    }


    @Then("the user should see that {string} message.")
    public void theUserShouldSeeThatMessage(String title) {
        then(title).isEqualTo(PAGES.getFlightsHomePage().getTitleOfFlightTab()).withFailMessage("the flight tab is not working properly");
    }
}

