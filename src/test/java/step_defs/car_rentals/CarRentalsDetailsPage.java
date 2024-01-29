package step_defs.car_rentals;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import step_defs.BaseStep;

import static org.assertj.core.api.BDDAssertions.then;

public class CarRentalsDetailsPage extends BaseStep {

    private static final Logger LOGGER = LogManager.getLogger(CarRentalsDetailsPage.class);

    @Then("The user validates that the name of selected car is true")
    public void theUserValidatesThatTheNameOfSelectedCarIsTrue() {
        String expectedResult = PAGES.getCarRentalsFilteringPage().getBrandOfSelectedCarInFilteringPage();
        String actualResult = PAGES.getCarRentalsDetailsPage().getBrandOfSelectedCarInDetailsPage();
        then(expectedResult).isEqualTo(actualResult);
        LOGGER.debug("The user validates that the name of selected car is true");
    }


    //The user validates that "<pick_up_location>", price, "<transmission>" and "<car_category>" of displayed car in detail_page matches with the selected car in filtering_page
    @And("The user validates that {string}, price, {string} and {string} of displayed car in detail_page matches with the selected car in filtering_page")
    public void theUserValidatesThatPriceAndOfDisplayedCarInDetail_pageMatchesWithTheSelectedCarInFiltering_page(String pick_up_location, String transmission, String car_category) {
         then(PAGES.getCarRentalsDetailsPage().getPickedUpLocationOfSelectedCar()).isEqualTo(pick_up_location);
         //TODO
         then(PAGES.getCarRentalsDetailsPage().getCategoryOfTheSelectedCar()).isEqualTo(car_category);
         then(PAGES.getCarRentalsDetailsPage().getTransmissionOfSelectedCar()).isEqualTo(transmission);

    }
}
