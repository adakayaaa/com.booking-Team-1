package step_defs.car_rentals;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import step_defs.BaseStep;

import static org.assertj.core.api.BDDAssertions.then;

public class CarRentalsDetailsStep extends BaseStep {

	private static final Logger LOGGER = LogManager.getLogger(CarRentalsDetailsStep.class);

	@Then("The user validates that the name of selected car is true")
	public void theUserValidatesThatTheNameOfSelectedCarIsTrue() {
		String expectedResult = CarRentalFilteringStep.SELECTED_CAR.getSelectedCarName();
		String actualResult = PAGES.getCarRentalsDetailsPage().getBrandOfSelectedCarInDetailsPage();

		then(expectedResult).isEqualTo(actualResult);

		LOGGER.debug("The user validates that the name of selected car is true");
	}

	// The user validates that "<pick_up_location>", price, "<transmission>" and
	// "<car_category>" of displayed car in detail_page matches with the selected car in
	// filtering_page
	@And("The user validates that {string}, price, {string} and {string} of displayed car in detail_page matches with the selected car in filtering_page")
	public void theUserValidatesThatPriceAndOfDisplayedCarInDetail_pageMatchesWithTheSelectedCarInFiltering_page(
			String pick_up_location, String transmission, String car_category) {
		then(PAGES.getCarRentalsDetailsPage().getPickedUpLocationOfSelectedCar()).isEqualTo(pick_up_location);
		then(PAGES.getCarRentalsDetailsPage().getFeeOfSelectedCar())
			.isEqualTo(CarRentalFilteringStep.SELECTED_CAR.getPriceOfSelectedCar() * 3);
		then(PAGES.getCarRentalsDetailsPage().getTransmissionOfSelectedCar()).isEqualTo(transmission);
		then(PAGES.getCarRentalsDetailsPage().getCategoryOfTheSelectedCar()).isEqualTo(car_category);
		LOGGER.debug(
				"The user validates that {string}, price, {string} and {string} of displayed car in detail_page matches with the selected car in filtering_page");
	}

	@And("The user validates that total_price calculation is true")
	public void theUserValidatesThatTotal_priceCalculationIsTrue() {
		double taxValue = 0.02;
		double taxAmount = PAGES.getCarRentalsDetailsPage().getFeeOfSelectedCar() * taxValue;
		double expectedResult = CarRentalFilteringStep.SELECTED_CAR.getPriceOfSelectedCar() * 3 + taxAmount;
		then(expectedResult).withFailMessage("Total price is wrong !")
			.isEqualTo(PAGES.getCarRentalsDetailsPage().getTotalPrice());
	}

	@When("The user clicks on the What is covered button")
	public void theUserClicksOnTheWhatIsCoveredButton() {
		PAGES.getCarRentalsDetailsPage().clickOnTheWhatIsCovered();
	}

	@Then("The user validates that total_price is increased by amount total_cover_price")
	public void theUserValidatesThatTotal_priceIsIncreasedByAmountTotal_cover_price() {
		double taxValue = 0.02;
		double taxAmount = PAGES.getCarRentalsDetailsPage().getFeeOfSelectedCar() * taxValue;
		double expectedResult = PAGES.getCarRentalsDetailsPage().getFeeOfSelectedCar() + taxAmount
				+ PAGES.getCarRentalsDetailsPage().getTotalCoverPrice();
		double actualResult = PAGES.getCarRentalsDetailsPage().getTotalPrice();
		then(actualResult).withFailMessage("Total price is not correctly calculated!").isEqualTo(expectedResult);
	}

	@When("The user clicks on go_to_book button")
	public void theUserClicksOnGo_to_bookButton() {
		PAGES.getCarRentalsDetailsPage().clickOnTheGoToBookButton();
	}

}
