package pages.car_rentals;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

import java.util.List;

public class CarRentalsFilteringPage extends BasePage {

    private String brandOfSelectedCar;

    private double priceOfSelectedCar;

    @FindBy(css = "[placeholder='Enter pickup location']")
    private WebElement pickupLocationTextField;
    @FindBy(css = ".position-relative")
    private List<WebElement> pickedUpAndDropOffDates;

    @FindBy(css = ".lsCheckboxInput")
    private List<WebElement> checkBoxes;

    @FindBy(css = ".search-btn-car-rental > button")
    private WebElement filteringPageSearchButton;

    @FindBy(css = ".fs-1")
    private List<WebElement> pricesOfTheFilteredCars;

    @FindBy(css = ".my-4 > .p-2> .fs-4")
    private List<WebElement> categoryAndTransmissionsOfFilteredCars;

    @FindBy(css = ".carRentalItemDetails > .d-flex > .fs-4")
    private List<WebElement> pickedUpLocationOfFilteredCars;

    @FindBy(css = ".lrb-btn")
    private List<WebElement> heighestAndLowestButtons;

    @FindBy(css = ".mt-2.btn-blue")
    private List<WebElement> viewDealButtons;

    @FindBy(css = ".carRentalItemDetails > h3")
    private List<WebElement> brandsOfCars;



    public void enterPickupLocation(String pick_up_location){
        pickupLocationTextField.sendKeys(pick_up_location);
    }

    public String getEnteredPickupLocation() {
        return pickupLocationTextField.getAttribute("value");
    }

    public boolean arePickedUpDatesMatch(String expectedDate) {
        return pickedUpAndDropOffDates.get(0).getAttribute("value").equals(expectedDate);
    }

    public boolean areDropOffUpDatesMatch(String expectedDate) {
        return pickedUpAndDropOffDates.get(1).getAttribute("value").equals(expectedDate);
    }

    public void selectTheCheckBoxWithParameter(String boxValue) {
        checkBoxes.stream().forEach(box -> {
            if (box.getAttribute("value").equals(boxValue)) {
                actions.moveToElement(box).click();
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
        List<Double> doubleOfPricesOfFilteredCars = getPricesOfFilteredCars(pricesOfTheFilteredCars);
        return checkPrices(doubleOfPricesOfFilteredCars, minPrice, maxPrice);
    }

    public List<Double> getPricesOfFilteredCars(List<WebElement> pricesOfTheFilteredCars) {
        List<String> strOfPricesOfFilteredCars = pricesOfTheFilteredCars.stream().map(WebElement::getText).toList();
        return strOfPricesOfFilteredCars.stream().map(priceInString -> Double.parseDouble(priceInString.substring(1))).toList();
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
       actions.moveToElement(filteringPageSearchButton).click();
    }

    public boolean areTransmissionsOfFilteredCarsMatch(String expectedTransmission) {
        for (int i = 1; i < categoryAndTransmissionsOfFilteredCars.size(); i += 5) {
            if (!categoryAndTransmissionsOfFilteredCars.get(i).getText().equals(expectedTransmission)) {
                return false;
            }
        }
        return true;
    }

    public boolean areCategoriesOfFilteredCarsMatch(String expectedCategory) {
        for (int i = 3; i < categoryAndTransmissionsOfFilteredCars.size(); i += 5) {
            if (!categoryAndTransmissionsOfFilteredCars.get(i).getText().equals(expectedCategory)) {
                return false;
            }
        }
        return true;
    }

    public boolean arePickedUpLocationsOfFilteredCarsMatch(String expectedLocations) {
        List<String> filteredLocation = pickedUpLocationOfFilteredCars.stream().map(WebElement::getText).toList();
        return filteredLocation.stream().allMatch(expectedLocations::equals);
    }

    public void clickOnTheHeighestButton() {
        heighestAndLowestButtons.get(1).click();
    }

    public void clickOnTheLowestButton() {
        heighestAndLowestButtons.get(0).click();
    }

    public boolean areAllPricesArrangedFromHeighestToLowest() {
        List<Double> filteredPrices = getPricesOfFilteredCars(pricesOfTheFilteredCars);
        for (int i = 0; i < filteredPrices.size() - 1; i++) {
            if (filteredPrices.get(i) < filteredPrices.get(i + 1)) {
                return false;
            }
        }
        return true;
    }


    public boolean areAllPricesArrangedFromLowestToHeighest() {
        List<Double> filteredPrices = getPricesOfFilteredCars(pricesOfTheFilteredCars);
        for (int i = 0; i < filteredPrices.size() - 1; i++) {
            if (filteredPrices.get(i) > filteredPrices.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    public void clickOnTheViewDealButton(int index){
        brandOfSelectedCar = brandsOfCars.get(index).getText();
        priceOfSelectedCar = getPricesOfFilteredCars(pricesOfTheFilteredCars).get(index);
        viewDealButtons.get(index).click();
    }

    public String getBrandOfSelectedCarInFilteringPage(){
        return brandOfSelectedCar;
    }

    public double getPriceOfSelectedCarInFilteringPage(){
        return priceOfSelectedCar;
    }

}
