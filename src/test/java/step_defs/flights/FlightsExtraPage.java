package step_defs.flights;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import step_defs.BaseStep;
import utils.BrowserUtils;

import static org.assertj.core.api.BDDAssertions.then;

public class FlightsExtraPage extends BaseStep {

    @Then("The user should see {string} text")
    public void theUserShouldSeeText(String text) {
        then(PAGES.getFlightsExtraPage().getTitleOfExtraPage()).isEqualTo(text).withFailMessage("The user couldn't click extra button");
    }

    @When("The user selects as {string}")
    public void theUserSelectsAs(String mealName) {
        System.out.println();
    }


    @Then("The user should see price of {string} should have been added to total price")
    public void theUserShouldSeePriceOfShouldHaveBeenAddedToTotalPrice(String mealName) {
        double initTotalPrice = PAGES.getFlightsExtraPage().getTotalPrice();
        PAGES.getFlightsExtraPage().setSelectMeal(mealName);
        double priceOfMeal = PAGES.getFlightsExtraPage().priceOfMeal();
        then(PAGES.getFlightsExtraPage().getTotalPrice()).isEqualTo(initTotalPrice + priceOfMeal).withFailMessage("Price of meal is added wrongly");
    }

    @When("The user click on go to checkout button")
    public void theUserClickOnGoToCheckoutButton() {
        PAGES.getFlightsExtraPage().clickOnGoToCheckoutButton();
    }

    @Then("The user should see that {string} title of checkout page")
    public void theUserShouldSeeThatTitleOfCheckoutPage(String title) {
        then(PAGES.getFlightsCheckoutPage().getTitleOfCardHolder()).isEqualTo(title).withFailMessage("The user couldn't pass checkout page");
    }
}
