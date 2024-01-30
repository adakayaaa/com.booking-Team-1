package pages.flights;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import pages.BasePage;
import utils.BrowserUtils;

import java.util.List;

public class FlightsExtraPage extends BasePage {

	@FindBy(xpath = "//div[text()='Extras For Your Flight']")
	private WebElement titleOfExtraPage;

	@FindBy(xpath = "//h1[@class='fw-bold m-0 w-100 d-flex justify-content-between']")
	private WebElement totalPriceWithTaxes;

	@FindBy(css = "select.fs-4")
	private WebElement selectMeal;

	@FindBy(css = "select.fs-4>option")
	private List<WebElement> namesOfMeals;

	@FindBy(xpath = "(//div[@class='d-flex flex-column justify-content-end-align-items-end']/span)[1]")
	private WebElement priceOfSelectedMeal;

	@FindBy(css = "button.btn-blue>span")
	private WebElement goToCheckoutButton;

	public String getTitleOfExtraPage() {
		return titleOfExtraPage.getText();
	}

	public Double getTotalPrice() {
		return Double
			.parseDouble(totalPriceWithTaxes.getText().substring(totalPriceWithTaxes.getText().indexOf("$") + 1));
	}

	public void setSelectMeal(String mealName) {
		List<String> listOfMeals = namesOfMeals.stream().map(meal -> meal.getAttribute("value")).toList();
		Select selectMeals = new Select(selectMeal);
		selectMeals.selectByIndex(listOfMeals.indexOf(mealName));
	}

	public double priceOfMeal() {
		return Double.parseDouble(priceOfSelectedMeal.getText().substring(1));
	}

	public void clickOnGoToCheckoutButton() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scroll(0,900)");
		BrowserUtils.wait(2);
		goToCheckoutButton.click();
		js.executeScript("window.scroll(0,-900)");
	}

}
