package pages.flights;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;


public class FlightsHomePage extends BasePage {
    @FindBy(xpath = "(//div[@class='headerList']/div)[2]")
    private WebElement flightTab;
    @FindBy(css = "h1.headerTitle")
    private WebElement flightTabTitle;

    public void clickOnFlightTab() {
        flightTab.click();
    }

    public String getTitleOfFlightTab() {
        return flightTabTitle.getText();
    }
}
