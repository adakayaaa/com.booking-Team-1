package step_defs.flights;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import step_defs.BaseStep;
import utils.BrowserUtils;

import static org.assertj.core.api.BDDAssertions.then;

public class FlightsExtraPage extends BaseStep {

	private static final Logger LOGGER = LogManager.getLogger(FlightsExtraPage.class);

	@Then("The user should see {string} text")
	public void theUserShouldSeeText(String text) {
		then(PAGES.getFlightsExtraPage().getTitleOfExtraPage()).withFailMessage("The user couldn't click extra button").isEqualTo(text);
		LOGGER.debug("The user should see title of extra page");
	}
	@When("The user selects as {string} meal")
	public void theUserSelectsAs(String mealName) {
		LOGGER.info("The user selects a meal");
	}


	@Then("The user should see price of {string} meal should have been added to total price")
	public void theUserShouldSeePriceOfShouldHaveBeenAddedToTotalPrice(String mealName) {
		double initTotalPrice = PAGES.getFlightsExtraPage().getTotalPrice();
		PAGES.getFlightsExtraPage().setSelectMeal(mealName);
		double priceOfMeal = PAGES.getFlightsExtraPage().priceOfMeal();
		then(PAGES.getFlightsExtraPage().getTotalPrice()).withFailMessage("Price of meal is added wrongly").isEqualTo(initTotalPrice + priceOfMeal);
		LOGGER.debug("The user should see price of selected meal should have been added to total price");
	}

	@When("The user click on go to checkout button")
	public void theUserClickOnGoToCheckoutButton() {
		PAGES.getFlightsExtraPage().clickOnGoToCheckoutButton();
		LOGGER.info("The user click on go to checkout button");
	}

	@Then("The user should see that {string} title of checkout page")
	public void theUserShouldSeeThatTitleOfCheckoutPage(String title) {
		then(PAGES.getFlightsCheckoutPage().getTitleOfCardHolder()).withFailMessage("The user couldn't pass checkout page").isEqualTo(title);
		LOGGER.debug("The user should see that title of checkout page");
	}


	}

