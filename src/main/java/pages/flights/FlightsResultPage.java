package pages.flights;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import utils.BrowserUtils;

import java.util.List;

public class FlightsResultPage extends BasePage {

	@FindBy(css = "h3.display-4")
	private List<WebElement> titlesOfResultPage;

	@FindBy(xpath = "//div[@class='fare-item col-3 mt-5 active-fare ']//div[@class='d-block w-100 fs-5 text-muted']/span")
	private List<WebElement> pricesOfMain;

	@FindBy(css = "button.btn-blue")
	private WebElement selectWhoFlyingButton;

	@FindBy(xpath = "(//span[@class=\"mx-3\"])[1]")
	private WebElement countOfAdultAndChildren;

	@FindBy(css = "div.fw-semibold")
	private List<WebElement> flightPlaces;

	public String getTitleOfResultPage() {
		return titlesOfResultPage.get(0).getText();
	}

	public int getPriceOfMainForDeparture() {
		List<Integer> list = pricesOfMain.stream()
			.map(price -> Integer.parseInt(price.getText().substring(price.getText().indexOf("$") + 2)))
			.toList();
		System.out.println(list.get(0));
		return list.get(0);

	}

	public int getPriceOfMainForArrival() {
		List<Integer> list = pricesOfMain.stream()
			.map(price -> Integer.parseInt(price.getText().substring(price.getText().indexOf("$") + 2)))
			.toList();
		System.out.println(list.get(1));
		return list.get(1);
	}

	public void clickOnSelectWhoFlyingButton() {
		BrowserUtils.scrollDownWithPageDown();
		BrowserUtils.scrollDownWithPageDown();
		BrowserUtils.wait(1);
		selectWhoFlyingButton.click();
		BrowserUtils.scrollUpWithPageUp();
		BrowserUtils.scrollUpWithPageUp();
	}

	public int getCountOfAdult() {
		return Integer
			.parseInt(countOfAdultAndChildren.getText().substring(0, countOfAdultAndChildren.getText().indexOf(" ")));
	}

	public int getCountOfChildren() {
		return Integer.parseInt(countOfAdultAndChildren.getText()
			.substring(countOfAdultAndChildren.getText().indexOf("t") + 2,
					countOfAdultAndChildren.getText().lastIndexOf(" ")));
	}

	public String getDepartureCountryToArrivalCountry() {
		return flightPlaces.get(0).getText();
	}

	public String getArrivalCountryToDepartureCountry() {
		BrowserUtils.scrollDownWithPageDown();
		return flightPlaces.get(1).getText();
	}

}
