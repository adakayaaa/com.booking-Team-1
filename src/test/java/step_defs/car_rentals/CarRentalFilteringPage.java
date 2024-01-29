package step_defs.car_rentals;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import step_defs.BaseStep;

import static org.assertj.core.api.BDDAssertions.then;

public class CarRentalFilteringPage extends BaseStep {
    private static final Logger LOGGER = LogManager.getLogger(CarRentalFilteringPage.class);

    @And("The user selects the {string}")
    public void theUserClicksOnTheButton(String priceRange) {
        PAGES.getCarRentalsFilteringPage().selectTheCheckBoxWithParameter(priceRange);
        LOGGER.info("The user selects the " + priceRange);
    }


    @Then("The user validates that {string} is selected")
    public void theUserValidatesThatIsSelected(String boxValue) {
        PAGES.getCarRentalsFilteringPage().isTheCheckBoxSelected(boxValue);
        LOGGER.debug("The user validates that " + boxValue + " is selected");
    }

    //The user enters "<pick_up_location>","<price_range>","<car_spec>","<transmission>" and "<car_category>"
    @And("The user enters {string},{string},{string},{string} and {string}")
    public void the_user_enters_criteria
    (String pick_up_location, String price_range, String car_spec, String transmission, String car_category) {
        PAGES.getCarRentalsFilteringPage().enterPickupLocation(pick_up_location);
        PAGES.getCarRentalsFilteringPage().selectTheCheckBoxWithParameter(price_range);
        PAGES.getCarRentalsFilteringPage().selectTheCheckBoxWithParameter(car_spec);
        PAGES.getCarRentalsFilteringPage().selectTheCheckBoxWithParameter(transmission);
        PAGES.getCarRentalsFilteringPage().selectTheCheckBoxWithParameter(car_category);
        LOGGER.info("The user enters " + pick_up_location + "," + price_range + "," + car_spec + "," + transmission + " and " + car_category);
    }
    @And("The user clicks on search button in filtering page")
    public void the_user_clicks_on_search_button_in_filtering_page(){
        PAGES.getCarRentalsFilteringPage().clickOnTheFilteringPageSearchButton();
        LOGGER.info("The user clicks on search button in filtering page");
    }

    @Then("The user validates that {string},{string},{string} and {string} matches with displayed cars' information")
    public void theUserValidatesThatAndMatchesWithDisplayedCarsInformation
            (String pick_up_location, String price_range, String transmission, String car_category) {
        then(PAGES.getCarRentalsFilteringPage().areThePricesOfTheFilteredCarsInTheSelectedPriceRage(price_range)).isTrue();
        
    }
}
