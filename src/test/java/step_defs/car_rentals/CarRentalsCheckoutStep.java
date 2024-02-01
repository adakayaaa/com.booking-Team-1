package step_defs.car_rentals;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.NoSuchElementException;
import step_defs.BaseStep;

import static org.assertj.core.api.BDDAssertions.then;

public class CarRentalsCheckoutStep extends BaseStep {

	private static final Logger LOGGER = LogManager.getLogger(CarRentalsCheckoutStep.class);

	@Then("The user validates that {string},{string} and {string} of displayed car in checkout_page matches with the selected car in detail_page")
	public void the_user_validates_that_and_of_displayed_car_in_checkout_page_matches_with_the_selected_car_in_detail_page(
			String pick_up_location, String transmission, String car_category) {
		then(PAGES.getCarRentalsCheckoutPage().getPickedUpLocationOfSelectedCarInCheckoutPage())
			.isEqualTo(pick_up_location);
		then(PAGES.getCarRentalsCheckoutPage().getCategoryOfSelectedCarInCheckoutPage()).isEqualTo(car_category);
		then(PAGES.getCarRentalsCheckoutPage().getTransmissionsOfSelectedCarInCheckoutPage()).isEqualTo(transmission);
		LOGGER.debug("The user validates that {string}, price, {string} and {string} of displayed car in "
				+ "checkout page matches with the selected car in detail_page");
	}

	@And("The user enter valid card holder's name {string}")
	public void theUserEnterValidCardHolderSName(String cardHoldersName) {
		PAGES.getCarRentalsCheckoutPage().enterCardHolder(cardHoldersName);
		LOGGER.info("The user enter valid card holder's name");
	}

	@And("The user enter valid card number  {string}")
	public void theUserEnterValidCardNumber(String cardNumber) {
		PAGES.getCarRentalsCheckoutPage().enterCardNumber(cardNumber);
		LOGGER.info("The user enter valid card number");
	}

	@And("The user enter valid expiration date {string}")
	public void theUserEnterValidExpirationDate(String expirationDate) {
		PAGES.getCarRentalsCheckoutPage().enterExpirationDate(expirationDate);
		LOGGER.info("The user enter valid expiration date");
	}

	@And("The user enter valid CVV code {string}")
	public void theUserEnterValidCVVCode(String cvvCode) {
		PAGES.getCarRentalsCheckoutPage().enterCvvCode(cvvCode);
		LOGGER.info("The user enter valid CVV code");
	}

	@And("The user clicks on the Book_now button")
	public void theUserClicksOnTheBook_nowButton() {
		PAGES.getCarRentalsCheckoutPage().clickOnTheBookNowButton();
		LOGGER.info("The user clicks on the Book_now button");
	}

	@Then("The user validates that booking_successful {string} is displayed")
	public void theUserValidatesThatBooking_successfulIsDisplayed(String bookingSuccessfullyMessage) {
		then(PAGES.getCarRentalsCheckoutPage().getBookingSuccessfullyMessage()).isEqualTo(bookingSuccessfullyMessage);
		LOGGER.debug("The user validates that booking_successful message is displayed");
	}

	@And("The user validates that {string} is true")
	public void theUserValidatesThatIsTrue(String expectedPickupLocation) {
		String actualPickupLocation = PAGES.getCarRentalsCheckoutPage().getPickupLocationInTheThankMessage();
		then(actualPickupLocation).isEqualTo(expectedPickupLocation);
		LOGGER.info("The user validates that Pickup Location is true");
	}

	// "<firstName>","<lastName>","<phoneNumber>","<country>","<address>","<city>",
	// "<postalCode>","<cardholderName>","<cardNumber>","<expirationDate>","<cvv>"
	@When("The user enters user information {string},{string},{string},{string},{string},{string}, {string},{string},{string},{string},{string}")
	public void theUserEntersUserInformation(String firstName, String lastName, String phoneNumber, String country,
			String address, String city, String postalCode, String cardholderName, String cardNumber,
			String expirationDate, String cvv) {
		PAGES.getCarRentalsCheckoutPage()
			.enterCheckoutProcessInformation(firstName, lastName, phoneNumber, country, address, city, postalCode,
					cardholderName, cardNumber, expirationDate, cvv);
	}

	@When("The user clicks on the close button")
	public void theUserClicksOnTheCloseButton() {
		PAGES.getCarRentalsCheckoutPage().clickOnTheCloseButton();
		LOGGER.info("The user clicks on the close button");
	}

	@Then("The user validates that {string} of the {string} is displayed")
	public void theUserValidatesThatIsDisplayed(String expectedErrorMessage, String elementName) {

		try {
			String actualMessage = PAGES.getCarRentalsCheckoutPage().getErrorMessageOfSpecifiedElement(elementName);
			then(actualMessage).isEqualTo(expectedErrorMessage);
			LOGGER.info("The user validates that ErrorMessage of the element is displayed");

		}
		catch (NoSuchElementException ex) {
			LOGGER.error(ex.getMessage());
		}
	}

}
