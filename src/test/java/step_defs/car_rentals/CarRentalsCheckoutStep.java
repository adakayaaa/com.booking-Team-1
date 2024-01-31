package step_defs.car_rentals;

import io.cucumber.java.en.Then;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import step_defs.BaseStep;

import static org.assertj.core.api.BDDAssertions.then;

public class CarRentalsCheckoutStep extends BaseStep {
    private static final Logger LOGGER = LogManager.getLogger(CarRentalsCheckoutStep.class);

    @Then("The user validates that {string},{string} and {string} of displayed car in checkout_page matches with the selected car in detail_page")
    public void the_user_validates_that_and_of_displayed_car_in_checkout_page_matches_with_the_selected_car_in_detail_page
    (String pick_up_location, String transmission, String car_category) {
            then(PAGES.getCarRentalsCheckoutPage().getBrandOfSelectedCarInCheckoutPage()).isEqualTo(pick_up_location);
            then(PAGES.getCarRentalsCheckoutPage().getCategoryOfSelectedCarInCheckoutPage()).isEqualTo(car_category);
            then(PAGES.getCarRentalsCheckoutPage().getTransmissionsOfSelectedCarInCheckoutPage()).isEqualTo(transmission);
        LOGGER.debug("The user validates that {string}, price, {string} and {string} of displayed car in checkout page matches with the selected car in detail_page");
    }

}
