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

}
