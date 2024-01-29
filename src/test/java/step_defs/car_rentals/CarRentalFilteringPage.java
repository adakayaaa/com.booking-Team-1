package step_defs.car_rentals;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import step_defs.BaseStep;

public class CarRentalFilteringPage extends BaseStep {
    @And("The user selects the {string}")
    public void theUserClicksOnTheButton(String priceRange) {
       PAGES.getCarRentalsFilteringPage().selectTheCheckBoxWithParameter(priceRange);
    }


    @Then("The user validates that {string} is selected")
    public void theUserValidatesThatIsSelected(String boxValue) {
        PAGES.getCarRentalsFilteringPage().isTheCheckBoxSelected(boxValue);
    }

}
