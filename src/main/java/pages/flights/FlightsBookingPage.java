package pages.flights;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import utils.BrowserUtils;

import javax.swing.text.html.CSS;
import java.util.List;

public class FlightsBookingPage extends BasePage {
    @FindBy(css = "div.display-6")
    private WebElement whosFlyingTitle;

    @FindBy(css = "div.fw-semibold")
    private WebElement flightPlaces;

    @FindBy(xpath = "//span[@class=\"fs-3 mx-3\"]")
    private WebElement typeOfTrip;

    public String getTitleOfBookingPage(){
        return whosFlyingTitle.getText();
    }

    public String getFromDepartureCountryToArrivalCountry(){
        return flightPlaces.getText().substring(0,flightPlaces.getText().indexOf("-")-1);
    }
    public String getFromArrivalCountryToDepartureCountry(){
        return flightPlaces.getText().substring(flightPlaces.getText().indexOf("-")+2);
    }

    public String getTextOfTripType(){
        return typeOfTrip.getText();
    }


}
