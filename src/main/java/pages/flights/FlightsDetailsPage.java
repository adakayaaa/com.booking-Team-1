package pages.flights;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

import javax.xml.xpath.XPath;
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
    public String getTitleOfDetailsPage(){
        return titleOfDetailsPage.getText();
    }

    public boolean isSelectedDepartureCountry(String departureCountry){
        return departureCountries.stream().allMatch(country -> country.getText().contains(departureCountry));
    }
    public boolean isSelectedArrivalCountry(String arrivalCountry){
        return arrivalCountries.stream().allMatch(country -> country.getText().contains(arrivalCountry));
    }

    public boolean isDepartureDate(String departureDay){
        return departureDates.stream().allMatch(day ->day.getText().contains(departureDay));
    }

    public boolean isRoundType(){
        return tripTypes.stream().allMatch(trip -> trip.getText().contains("Round Trip"));
    }

}
