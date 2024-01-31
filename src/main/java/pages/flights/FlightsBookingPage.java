package pages.flights;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import pages.BasePage;
import utils.BrowserUtils;

import javax.swing.text.html.CSS;
import java.util.List;

public class FlightsBookingPage extends BasePage {

	@FindBy(css = "div.display-6")
	private WebElement whosFlyingTitle;

	@FindBy(css = "div.fw-semibold")
	private WebElement flightPlaces;

	@FindBy(xpath = "//span[@class=\"fs-3 mx-3\"]")
	private WebElement typeOfTrip;

	@FindBy(css = "input.form-control")
	private List<WebElement> inputFields;

	@FindBy(css = "select.form-select")
	private List<WebElement> selectsTabs;

	@FindBy(css = ".mb-3.fs-4.fw-bold>div>span")
	private List<WebElement> pricesOfTicketOnTheBookingPage;

	@FindBy(xpath = "(//h1[@class='fw-bold m-0']/span)[2]")
	private WebElement totalPriceWithTaxes;

	@FindBy(css = "button.btn-blue")
	private WebElement selectExtrasButton;

	public String getTitleOfBookingPage() {
		return whosFlyingTitle.getText();
	}

	public String getFromDepartureCountryToArrivalCountry() {
		return flightPlaces.getText().substring(0, flightPlaces.getText().indexOf("-") - 1);
	}

	public String getFromArrivalCountryToDepartureCountry() {
		return flightPlaces.getText().substring(flightPlaces.getText().indexOf("-") + 2);
	}

	public String getTextOfTripType() {
		return typeOfTrip.getText();
	}

	public void enterEmail(String email) {
		inputFields.get(0).sendKeys(email);
	}

	public void enterPhoneNumber(String phoneNumber) {
		inputFields.get(1).sendKeys(phoneNumber);
	}

	public void enterFirstName(String firstName) {
		inputFields.get(2).sendKeys(firstName);
	}

	public void enterLastName(String lastName) {
		inputFields.get(3).sendKeys(lastName);
	}

	public void selectGender(String gender) {
		Select select = new Select(selectsTabs.get(1));
		select.selectByVisibleText(gender);
	}

	public void selectBirthDate(String year, String month, String day) {
		Select selectYear = new Select(selectsTabs.get(2));
		selectYear.selectByVisibleText(year);

		Select selectMonth = new Select(selectsTabs.get(3));
		selectMonth.selectByVisibleText(month);

		Select selectDay = new Select(selectsTabs.get(4));
		selectDay.selectByVisibleText(day);
	}

	public Double getPriceOfTicket() {
		return Double.parseDouble(pricesOfTicketOnTheBookingPage.get(0).getText().substring(2));
	}

	public Boolean isEqualToTotalPrice() {
		double tax1 = ((getPriceOfTicket() * 5 / 100) * 100) / 100.0;
		double tax2 = ((getPriceOfTicket() * 2 / 100) * 100) / 100.0;

		double expected = tax1 + tax2 + getPriceOfTicket();
		double actual = Double.parseDouble(totalPriceWithTaxes.getText().substring(1));

		return expected == actual;

	}

	public void clickOnExtraButton() {
		BrowserUtils.scrollDownWithPageDown();
		BrowserUtils.wait(2);
		selectExtrasButton.click();
	}

}
