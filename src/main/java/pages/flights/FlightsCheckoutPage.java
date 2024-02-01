package pages.flights;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

import java.util.List;

public class FlightsCheckoutPage extends BasePage {

	@FindBy(xpath = "(//label[@class='fs-4 fw-normal mb-3'])[1]")
	private WebElement titleOfCardholder;

	@FindBy(css = ".form-control")
	private List<WebElement> listOfCardInput;

	@FindBy(css = ".btn-blue")
	private WebElement completeBookingButton;

	@FindBy(xpath = "(//div[@class=\"thanks\"]/h1)[1]")
	private WebElement thanksMessage;

	@FindBy(css = "button.btn-danger")
	private WebElement closeButton;

	@FindBy(css = ".fs-5")
	private WebElement errorMessage;

	public String getTitleOfCardHolder() {
		return titleOfCardholder.getText();
	}

	public void enterCardholdersName(String name) {
		listOfCardInput.get(0).sendKeys(name);
	}

	public void enterCardNumber(String cardNumber) {
		listOfCardInput.get(1).sendKeys(cardNumber);
	}

	public void enterExpirationDate(String expirationDate) {
		listOfCardInput.get(2).sendKeys(expirationDate);
	}

	public void enterCvvCode(String cvvCode) {
		listOfCardInput.get(3).sendKeys(cvvCode);
	}

	public void clickOnCompleteButton() {
		completeBookingButton.click();
	}

	public String getThanksMessage() {
		return thanksMessage.getText();
	}

	public void clickOnCloseButton() {
		closeButton.click();
	}

	public boolean isErrorMessageDisplayed() {
		return !errorMessage.getText().isEmpty();
	}

}
