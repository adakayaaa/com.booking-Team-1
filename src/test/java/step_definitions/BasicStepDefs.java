package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import utils.ConfigManager;



public class BasicStepDefs extends BaseStep{

    @Given("the user is on the Inar Academy homepage")
    public void the_user_is_on_the_inar_academy_homepage() {
        DRIVER.get(ConfigManager.getProperty("baseURL"));
    }

    @And("the user is on the Booking link")
    public void theUserIsOnTheBookingLink() {

    }

    @And("the user clicks on the Stays tab")
    public void theUserClicksOnTheStaysTab() {

    }

    @And("the user clicks on the Flights tab")
    public void theUserClicksOnTheFlightsTab() {

    }

    @And("the user clicks on the CarRentals tab")
    public void theUserClicksOnTheCarRentalsTab() {

    }

}
