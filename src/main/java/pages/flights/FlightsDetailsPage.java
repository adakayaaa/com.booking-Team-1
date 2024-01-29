package pages.flights;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import utils.BrowserUtils;

import java.util.List;

public class FlightsDetailsPage extends BasePage {

    @FindBy(css = "h1.headerTitle")
    private WebElement titleOfDetailsPage;

    @FindBy(xpath = "//span[@class=\"flight-deperture-time\"]/..//span[2]")
    private List<WebElement> departureCountries;

    @FindBy(xpath = "//span[@class=\"flight-arrival-time\"]/..//span[2]")
    private List<WebElement> arrivalCountries;

    @FindBy(xpath = "//h1[@class=\"flight-title\"]/../span[3]")
    private List<WebElement> departureDates;

    @FindBy(xpath = "//h1[@class=\"flight-title\"]/../span[@class=\"text-muted fs-5\"]")
    private List<WebElement> tripTypes;
    @FindBy(css = ".listResultTabs>button")
    private List<WebElement> cheapestAndFastestAndAllButtons;
    @FindBy(css = ".siDetailTexts>.siPrice")
    private List<WebElement> flightPrices;
    @FindBy(xpath = "//div[@class='flight-duration']/span[1]")
    private List<WebElement> flightTimes;
    @FindBy(xpath = "(//div[@class='lsOptions p-0'])[1]/div/input")
    private List<WebElement> flightCabinTypes;
    @FindBy(xpath = "//div[@class='searchItem flightItem']//span[@class='siCancelOpSubtitle']")
    private List<WebElement> cabinClassOnTickets;

    public String getTitleOfDetailsPage() {
        return titleOfDetailsPage.getText();
    }

    public boolean isSelectedDepartureCountry(String departureCountry) {
        List<String> list = departureCountries.stream().map(WebElement::getText).toList();
        System.out.println(list);
        return departureCountries.stream().allMatch(country -> country.getText().contains(departureCountry));
    }

    public boolean isSelectedArrivalCountry(String arrivalCountry) {
        List<String> list = arrivalCountries.stream().map(WebElement::getText).toList();
        System.out.println(list);
        return arrivalCountries.stream().allMatch(country -> country.getText().contains(arrivalCountry));
    }

    public boolean isDepartureDate(String departureDay) {
        return departureDates.stream().allMatch(day -> day.getText().contains(departureDay));
    }

    public boolean isRoundType() {
        return tripTypes.stream().allMatch(trip -> trip.getText().contains("Round Trip"));
    }

    public void clickOnCheapestTab() {
        cheapestAndFastestAndAllButtons.get(0).click();
    }

    public void clickOnFastestTab() {
        cheapestAndFastestAndAllButtons.get(1).click();
    }

    public void clickOnAllTab() {
        cheapestAndFastestAndAllButtons.get(2).click();
    }

    public boolean isSortedFromCheapestToHighest() {
        List<Integer> prices = flightPrices.stream().map(price -> Integer.parseInt(price.getText().substring(1))).toList();
        for (int i = 0; i < prices.size() - 1; i++) {
            if (prices.get(i) > prices.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    public boolean isSortableFromFastestToSlowest() {
        List<Double> listOfHours = flightTimes.stream().map(hour -> Double.parseDouble(hour.getText().substring(0, hour.getText().indexOf(" ")))).toList();
        for (int i = 0; i < listOfHours.size() - 1; i++) {
            if (listOfHours.get(i) > listOfHours.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    public void clickOnAllCabinTypes() {
        BrowserUtils.scrollDownWithPageDown();
        flightCabinTypes.get(0).click();
        flightCabinTypes.get(1).click();
        flightCabinTypes.get(2).click();
    }

    public boolean isFirstClassCabin(String classType) {
        flightCabinTypes.get(0).click();
        BrowserUtils.scrollUpWithPageUp();
        if (cabinClassOnTickets.isEmpty()) {
            return true;
        } else {
            return cabinClassOnTickets.stream().allMatch(ticket -> ticket.getText().contains(classType));
        }
    }

    public boolean isEconomyCabin(String classType) {
        flightCabinTypes.get(1).click();
        BrowserUtils.scrollUpWithPageUp();

        if (cabinClassOnTickets.isEmpty()) {
            return true;
        } else {
            return cabinClassOnTickets.stream().allMatch(ticket -> ticket.getText().contains(classType));
        }
    }

    public boolean isBusinessCabin(String classType) {
        flightCabinTypes.get(2).click();
        BrowserUtils.scrollUpWithPageUp();

        if (cabinClassOnTickets.isEmpty()) {
            return true;
        } else {
            return cabinClassOnTickets.stream().allMatch(ticket -> ticket.getText().contains(classType));
        }
    }

}