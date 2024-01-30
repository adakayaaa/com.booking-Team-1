package pages.car_rentals;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

import java.util.List;

public class CarRentalsDetailsPage extends BasePage {

    @FindBy(css = ".carRentalItemDetails > h3")
    private WebElement brandOfSelectedCarInDetailsPage;

    @FindBy(css = ".carRentalItemDetails > .d-flex > .fs-4")
    private WebElement pickedUpLocationOfSelectedCar;

    @FindBy(css = ".my-4 > .p-2> .fs-4")
    private List<WebElement> categoryAndTransmissionsOfSelectedCar;

    @FindBy(xpath = "//span[1]/text()[5]")
    private WebElement priceOfSelectedCar;

    @FindBy(css = ".mt-5 > .fw-bold > span")
    private List<WebElement> totalPrice;

    @FindBy(css = ".check-option ")
    private List<WebElement> insuranceButtons;

    @FindBy(css = " .fs-3.mt-4.fw-bold")
    private List<WebElement> totalCoverPrice;

    @FindBy(css = ".btn-blue")
    private WebElement goToBookButton;


    public String getBrandOfSelectedCarInDetailsPage(){
        return brandOfSelectedCarInDetailsPage.getText();
    }

    public String getPickedUpLocationOfSelectedCar(){
        return pickedUpLocationOfSelectedCar.getText();
    }

    public String getTransmissionOfSelectedCar(){
        return categoryAndTransmissionsOfSelectedCar.get(1).getText();
    }

    public String getCategoryOfTheSelectedCar() {
        return categoryAndTransmissionsOfSelectedCar.get(3).getText();
    }

    public double getPriceOfSelectedCar(){
        return Double.parseDouble(priceOfSelectedCar.getText());
    }

    public double getTotalPrice(){
        return Double.parseDouble(totalPrice.get(1).getText().substring(1));
    }

    public void clickOnTheWhatIsCovered(){
        insuranceButtons.get(1).click();
    }

    public double getTotalCoverPrice(){
        return Double.parseDouble(totalCoverPrice.get(1).getText().substring(1));
    }

    public void clickOnTheGoToBookButton(){
        goToBookButton.click();
    }



}