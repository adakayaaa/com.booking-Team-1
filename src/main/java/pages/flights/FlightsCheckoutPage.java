package pages.flights;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class FlightsCheckoutPage extends BasePage {

	@FindBy(xpath = "(//label[@class='fs-4 fw-normal mb-3'])[1]")
	private WebElement titleOfCardholder;

	public String getTitleOfCardHolder() {
		return titleOfCardholder.getText();
	}

}
