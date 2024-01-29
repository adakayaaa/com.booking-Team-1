package pages.car_rentals;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

import java.util.List;

public class CarRentalsFilteringPage extends BasePage {
    @FindBy(css = "[placeholder='Enter pickup location']")
    private WebElement pickupLocationTextField;
    @FindBy(css = ".position-relative")
    private List<WebElement> pickedUpAndDrpOffDates;

    @FindBy(css = ".lsCheckboxInput")
    private List<WebElement> checkBoxes;

    @FindBy(css = ".fs-1")
    private List<WebElement> pricesOfTheFilteredCars;

    @FindBy(css = ".search-btn-car-rental > button")
    private WebElement filteringPageSearchButton;
    public void enterPickupLocation(String pick_up_location){
        pickupLocationTextField.sendKeys(pick_up_location);
    }

    public String getEnteredPickupLocation() {
        return pickupLocationTextField.getAttribute("value");
    }

    public boolean arePickedUpDatesMatch(String expectedDate) {
        return pickedUpAndDrpOffDates.get(0).getAttribute("value").equals(expectedDate);
    }

    public boolean areDropOffUpDatesMatch(String expectedDate) {
        return pickedUpAndDrpOffDates.get(1).getAttribute("value").equals(expectedDate);
    }

    public void selectTheCheckBoxWithParameter(String boxValue) {
        checkBoxes.stream().forEach(box -> {
            if (box.getAttribute("value").equals(boxValue)) {
                box.click();
            }
        });
    }


    public boolean isTheCheckBoxSelected(String boxValue) {
        boolean isSelected = false;
        for (int i = 0; i < checkBoxes.size(); i++) {
            if (checkBoxes.get(i).getAttribute("value").equals(boxValue)){
               isSelected =  checkBoxes.get(i).isSelected();
            }
        }

        return isSelected;
    }

    public boolean areThePricesOfTheFilteredCarsInTheSelectedPriceRage(String priceRange){
        String[] bordersOfPrices = priceRange.split("-");
        double minPrice = Double.parseDouble(bordersOfPrices[0]);
        double maxPrice = Double.parseDouble(bordersOfPrices[1]);
        List<String> strOfPricesOfFilteredCars = pricesOfTheFilteredCars.stream().map(WebElement::getText).toList();
        List<Double> doubleOfPricesOfFilteredCars =
                strOfPricesOfFilteredCars.stream().map(priceInString -> Double.parseDouble(priceInString.substring(1))).toList();
        return checkPrices(doubleOfPricesOfFilteredCars, minPrice, maxPrice);
    }

    public boolean checkPrices(List<Double> doubleOfPricesOfFilteredCars, double minPrice, double maxPrice){
        for (double price : doubleOfPricesOfFilteredCars){
            if(price > maxPrice || price < minPrice){
                return false;
            }
        }

        return true;
    }
    public void clickOnTheFilteringPageSearchButton(){
        filteringPageSearchButton.click();
    }

}
