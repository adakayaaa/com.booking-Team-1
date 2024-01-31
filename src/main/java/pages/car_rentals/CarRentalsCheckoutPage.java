package pages.car_rentals;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

import java.util.List;

public class CarRentalsCheckoutPage extends BasePage {

    @FindBy(css = ".carRentalItemDetails > h3")
    private WebElement brandOfSelectedCarInCheckoutPage;

    @FindBy(css = ".carRentalItemDetails > .d-flex > .fs-4")
    private WebElement pickedUpLocationOfSelectedCarInCheckoutPage;

    @FindBy(css = ".my-4 > .p-2> .fs-4")
    private List<WebElement> categoryAndTransmissionsOfSelectedCarInCheckoutPage;

    public String getBrandOfSelectedCarInCheckoutPage(){
       return brandOfSelectedCarInCheckoutPage.getText();
    }
    public String getPickedUpLocationOfSelectedCarInCheckoutPage(){
        return pickedUpLocationOfSelectedCarInCheckoutPage.getText();
    }
    public String getTransmissionsOfSelectedCarInCheckoutPage(){
        return categoryAndTransmissionsOfSelectedCarInCheckoutPage.get(1).getText();
    }
    public String getCategoryOfSelectedCarInCheckoutPage(){
        return categoryAndTransmissionsOfSelectedCarInCheckoutPage.get(3).getText();
    }



}
