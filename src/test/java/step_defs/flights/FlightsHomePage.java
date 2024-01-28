package step_defs.flights;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import step_defs.BaseStep;
import utils.BrowserUtils;

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

    @Given("The user is on the flights page")
    public void theUserIsOnTheFlightsPage() {
        PAGES.getFlightsHomePage().clickOnFlightTab();
    }

    @When("The user clicks on the round way radio")
    public void theUserClicksOnTheRoundWayRadio() {
        PAGES.getFlightsHomePage().clickOnTheRoundTrip();
    }

    @And("The user selects departure as a {string}")
    public void theUserSelectsDepartureAsA(String departureCountry) {
        PAGES.getFlightsHomePage().selectDepartureCountry(departureCountry);
    }

    @And("The user selects return as a {string}")
    public void theUserSelectsReturnAsA(String returnCountry) {
        PAGES.getFlightsHomePage().selectReturnCountry(returnCountry);
    }


    @And("The user selects departure date as {string} and return date as {string}")
    public void theUserSelectsDepartureDateAsAndReturnDateAs(String departureDate, String returnDate) {
        PAGES.getFlightsHomePage().clickOnDatePicker();
        PAGES.getFlightsHomePage().selectDaysOnTheDatePicker(Integer.parseInt(departureDate),Integer.parseInt(returnDate));
    }

    @And("The user determines adult number as {string} and children number as  {string}")
    public void theUserDeterminesAdultNumberAsAndChildrenNumberAs(String numberOfAdult, String numberOfChildren) {
        PAGES.getFlightsHomePage().clickOnThePlusButtonOfAdults(Integer.parseInt(numberOfAdult));
        PAGES.getFlightsHomePage().clickOnThePlusButtonOfChildren(Integer.parseInt(numberOfChildren));
    }

    @And("The user clicks on the search flights button")
    public void theUserClicksOnTheSearchFlightsButton() {
        PAGES.getFlightsHomePage().clickOnTheSearchFlightButton();
    }


    @Then("The user should see that {string} header text message is displayed")
    public void theUserShouldSeeThatHeaderTextMessageIsDisplayed(String headerText) {
        then(PAGES.getFlightsDetailsPage().getTitleOfDetailsPage()).isEqualTo(headerText).withFailMessage("The user couldn't pass on the detail page!");
    }


    @And("The user should see that only list of departure countries and return countries are displayed")
    public void theUserShouldSeeThatOnlyListOfDepartureCountriesAndReturnCountriesAreDisplayed() {

    }

    @And("The user should see that only round way on the tickets")
    public void theUserShouldSeeThatOnlyRoundWayOnTheTickets() {
        then(PAGES.getFlightsDetailsPage().isRoundType()).isTrue().withFailMessage("The type of trip is not round!");
        BrowserUtils.wait(4);
    }


    @And("The user should see that only list of {string} is displayed")
    public void theUserShouldSeeThatOnlyListOfIsDisplayed(String departureDate) {
        then(PAGES.getFlightsDetailsPage().isDepartureDate(departureDate)).isTrue().withFailMessage("The day is not departure day!");
    }
}

