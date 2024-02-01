package step_defs.car_rentals;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.Assertions;
import pages.HomePage;
import step_defs.BaseStep;
import utils.BrowserUtils;

import static org.assertj.core.api.BDDAssertions.then;

public class CarRentalHomeStep extends BaseStep {
    private static final Logger LOGGER = LogManager.getLogger(CarRentalHomeStep.class);
    HomePage homePage;
    @Given("The user navigates to the Inar Academy Home page")
    public void the_user_navigates_to_the_Inar_Academy_Home_page(){
        homePage = PAGES.getHomePage();
    }

    @When("The user clicks on the Booking link")
    public void the_user_clicks_on_the_Booking_link(){
        homePage.clickOnBookingLink();
    }

    @Then("The user sees Booking Home page")
    public void the_user_sees_Booking_Home_page(){
        String actualHeader = PAGES.getCarRentalsHomePage().getInarBookingHeaderText();
        String expectedHeader = "inarbooking";
        Assertions.assertThat(expectedHeader).withFailMessage("The user is not on the Booking" +
                " home page").isEqualTo(actualHeader);
    }

    @And("The user clicks on the Car rentals tab")
    public void the_user_clicks_on_the_Car_rentals_tab(){
        BrowserUtils.wait(1.0);
        PAGES.getCarRentalsHomePage().clickOnTheCarRentalsLink();
    }

    @Then("The user validates that {string} message is visible")
    public void the_user_validates_that_true_message_is_visible(String expectedMessage){
        String actualMessage = PAGES.getCarRentalsHomePage().getHeaderTitleMessage();
        Assertions.assertThat(actualMessage).withFailMessage("The user is not on the " +
                "Booking home page").isEqualTo(expectedMessage);
    }

    @And("The user clicks on the search button")
    public void the_user_clicks_on_the_search_button(){
        PAGES.getCarRentalsHomePage().clickOnTheSearchButton();
    }

    @And("The user enter {string},{string},{string},{string} and {string}")
    public void theUserEnterCredentialsInCarRentalsHomePage
    (String pickupLocation , String pickup_date, String pickup_hour, String dropOffDate, String drop_hour ){
        PAGES.getCarRentalsHomePage().enterThePickupLocation(pickupLocation);
        PAGES.getCarRentalsHomePage().enterThePickUpDate(pickup_date);
        PAGES.getCarRentalsHomePage().selectThePickupHour(pickup_hour);
        PAGES.getCarRentalsHomePage().enterTheDropOffDate(dropOffDate);
        PAGES.getCarRentalsHomePage().selectTheDropOffHour(drop_hour);
    }

    @Then("The user face with {string}")
    public void theUserFaceWith(String errorMessage) {
        String actualMessage = PAGES.getCarRentalsHomePage().getErrorMessageInHomePage();
        then(actualMessage).isEqualTo(errorMessage);
        LOGGER.debug("Error message displayed");

    }
}
