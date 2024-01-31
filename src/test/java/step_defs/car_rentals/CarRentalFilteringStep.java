package step_defs.car_rentals;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pages.car_rentals.used_class.Car;
import step_defs.BaseStep;
import utils.BrowserUtils;
import utils.Pages;

import static org.assertj.core.api.BDDAssertions.then;

public class CarRentalFilteringStep extends BaseStep {
    public static Car SELECTED_CAR;
    private static final Logger LOGGER = LogManager.getLogger(CarRentalFilteringStep.class);

    @And("The user selects the {string}")
    public void theUserClicksOnTheButton(String priceRange) {
        PAGES.getCarRentalsFilteringPage().selectTheCheckBoxWithParameter(priceRange);
        LOGGER.info("The user selects the " + priceRange);
    }


    @Then("The user validates that {string} is selected")
    public void theUserValidatesThatIsSelected(String boxValue) {
//        JavascriptExecutor js = (JavascriptExecutor) DRIVER;
//        js.executeScript("window.scrollBy(0, 300)");
//        BrowserUtils.wait(1.0);
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
        then(PAGES.getCarRentalsFilteringPage().arePickedUpLocationsOfFilteredCarsMatch(pick_up_location)).isTrue();
        then(PAGES.getCarRentalsFilteringPage().areThePricesOfTheFilteredCarsInTheSelectedPriceRage(price_range)).isTrue();
        then(PAGES.getCarRentalsFilteringPage().areTransmissionsOfFilteredCarsMatch(transmission)).isTrue();
        then(PAGES.getCarRentalsFilteringPage().areCategoriesOfFilteredCarsMatch(car_category)).isTrue();
        LOGGER.debug("The user validates that all of information match with selected boxes");


    }

    @When("The user clicks on price highest sort button")
    public void theUserClicksOnPriceHighestSortButton() {
        PAGES.getCarRentalsFilteringPage().clickOnTheHighestSortButton();
        LOGGER.info("The user clicks on price highest sort button");

    }


    @Then("The user validates that cars are sorted from highest to lowest")
    public void theUserValidatesThatCarsAreSortedFromHighestToLowest() {
        then(PAGES.getCarRentalsFilteringPage().areAllPricesArrangedFromHighestToLowest()).isTrue();
        LOGGER.debug("The user validates that cars are sorted from highest to lowest");
    }


    @When("The user clicks on price lowest sort button")
    public void theUserClicksOnPriceLowestSortButton() {
        PAGES.getCarRentalsFilteringPage().clickOnTheLowestSortButton();
        LOGGER.info("The user clicks on price lowest sort button");
    }


    @Then("The user validates that cars are sorted from lowest to highest")
    public void theUserValidatesThatCarsAreSortedFromLowestToHighest() {
        then(PAGES.getCarRentalsFilteringPage().areAllPricesArrangedFromLowestToHighest()).isTrue();
        LOGGER.debug("The user validates that cars are sorted from lowest to heighest");
    }

    @And("The user clicks View Dial button of the #{int} element")
    public void theUserClicksViewDialButtonOfTheFirstElement(int index) {
        BrowserUtils.wait(1.0);
        PAGES.getCarRentalsFilteringPage().clickOnTheViewDealButton(index);
        LOGGER.info("The user clicks View Dial button of the first element");
        SELECTED_CAR = PAGES.getCarRentalsFilteringPage().getSelectedCar();
    }

}