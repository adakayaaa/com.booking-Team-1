package pages.car_rentals;


import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import pages.BasePage;
import utils.BrowserUtils;
import utils.DriverManager;

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


    public String getInarBookingHeaderText() {
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

    public void selectThePickupHour(String hour) {
        String classValue = "form-select";
        setElementValueByClassName(classValue,hour);
    }

    public void selectTheDropOffHour(String hour){
        pickupAndDropOffHourElements.get(1).click();
        Select select = new Select(pickupAndDropOffHourElements.get(1));
        select.selectByVisibleText(hour);
    }


    public void clickOnTheSearchButton() {
        BrowserUtils.wait(4.0);
        searchButtonLink.click();
        BrowserUtils.wait(2.0);
    }

    public void setElementValueByClassName(String className, String value) {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("document.querySelector('." + className + "').value='" + value + "'");
    }

    public void setPickupDate(String pickupDate) {
        String classValue = "headerSearchText > .headerDateInput";
        setElementValueByClassName(classValue, pickupDate);
        BrowserUtils.wait(4.0);
    }

    public void setDropOffDate(String pickupDate) {
        String classValue = "headerSearchText > .position-relative";
        setElementValueByClassName(classValue, pickupDate);
    }
    public String getErrorMessageInHomePage(){
        Alert alert  = driver.switchTo().alert();
        System.out.println(alert.getText());
        return alert.getText();
    }

}
