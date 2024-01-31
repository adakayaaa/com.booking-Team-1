package pages.car_rentals;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import pages.BasePage;

import java.util.List;

public class CarRentalsHomePage extends BasePage {

    @FindBy(linkText = "inarbooking")
    private WebElement inarBookingHeader;

    @FindBy(css = ".headerListItem:nth-child(3)")
    private WebElement carRentalsLink;

    @FindBy(css = ".headerTitle")
    private WebElement headerTitleMessage;

    @FindBy(css = "[placeholder = 'Enter Pickup Location']")
    private WebElement pickupLocation;


    @FindBy(css = ".form-select")
    private List<WebElement> pickupAndDropOffHourElements;

    @FindBy(xpath = "//*[text() = 'Search Cars']")
    private WebElement searchButtonLink;

    public String getInarBookingHeaderText(){
        return inarBookingHeader.getText();
    }

    public void clickOnTheCarRentalsLink() {
        carRentalsLink.click();
    }

    public String getHeaderTitleMessage() {
        return headerTitleMessage.getText();
    }

    public void enterThePickupLocation(String location) {
        pickupLocation.sendKeys(location);
    }

    public void selectThePickupHour(String hour){
        Select select = new Select(pickupAndDropOffHourElements.get(0));
        select.selectByVisibleText(hour);
    }

    public void selectTheDropOffHour(String hour){

        Select select = new Select(pickupAndDropOffHourElements.get(1));
        select.selectByVisibleText(hour);
    }



    public void clickOnTheSearchButton() {
        searchButtonLink.click();
    }


}
