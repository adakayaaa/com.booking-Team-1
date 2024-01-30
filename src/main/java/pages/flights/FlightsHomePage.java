package pages.flights;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import pages.BasePage;

import java.util.List;

public class FlightsHomePage extends BasePage {

	@FindBy(xpath = "(//div[@class='headerList']/div)[2]")
	private WebElement flightTab;

	@FindBy(css = "h1.headerTitle")
	private WebElement flightTabTitle;

	@FindBy(css = ".me-3 >input")
	private List<WebElement> radioButtonsForWay;

	@FindBy(css = "select.headerSearchInput")
	private List<WebElement> selectDepartureAndArrivalCountriesItems;

	@FindBy(css = ".headerSearchText")
	private List<WebElement> datePickerAndPeopleTabs;

	@FindBy(css = ".headerSearchItem>.headerBtn")
	private WebElement searchFlightsButton;

	@FindBy(css = ".rdrNextPrevButton")
	private List<WebElement> prevAndNextMonthButtons;

	@FindBy(css = ".rdrDays > button")
	private List<WebElement> days;

	@FindBy(css = ".optionCounterButton")
	private List<WebElement> counterButtons;

	@FindBy(css = ".optionCounterNumber")
	private List<WebElement> defaultCountsOfPeople;

	public void clickOnFlightTab() {
		flightTab.click();
	}

	public String getTitleOfFlightTab() {
		return flightTabTitle.getText();
	}

	public void clickOnTheRoundTrip() {
		radioButtonsForWay.get(0).click();
	}

	public void selectDepartureCountry(String country) {
		Select selectDepartureCountry = new Select(selectDepartureAndArrivalCountriesItems.get(1));
		selectDepartureCountry.selectByVisibleText(country);
	}

	public void selectReturnCountry(String country) {
		Select selectReturnCountry = new Select(selectDepartureAndArrivalCountriesItems.get(2));
		selectReturnCountry.selectByVisibleText(country);
	}

	public void clickOnDatePicker() {
		datePickerAndPeopleTabs.get(0).click();
	}

	public void selectDaysOnTheDatePicker(int departureDay, int returnDay) {
		prevAndNextMonthButtons.get(1).click();
		List<WebElement> daysOnTheDatePicker = days.stream()
			.filter(day -> !day.getAttribute("class").contains("rdrDayPassive"))
			.toList();
		daysOnTheDatePicker.get(departureDay - 1).click();
		daysOnTheDatePicker.get(returnDay - 1).click();
	}

	public String getDefaultValueOfAdult() {
		return defaultCountsOfPeople.get(0).getText();
	}

	public String getDefaultValueOfChildren() {
		return defaultCountsOfPeople.get(1).getText();
	}

	public void clickOnThePlusButtonOfAdults(int totalOfAdult) {
		datePickerAndPeopleTabs.get(1).click();
		int defaultCountsOfAdults = Integer.parseInt(getDefaultValueOfAdult());
		for (int i = 0; i < totalOfAdult - defaultCountsOfAdults; i++) {
			counterButtons.get(1).click();
		}
	}

	public void clickOnThePlusButtonOfChildren(int totalOfChildren) {
		int defaultCountsOfChildren = Integer.parseInt(getDefaultValueOfChildren());
		for (int i = 0; i < totalOfChildren - defaultCountsOfChildren; i++) {
			counterButtons.get(3).click();
		}
	}

	public void clickOnTheSearchFlightButton() {
		searchFlightsButton.click();
	}

}
