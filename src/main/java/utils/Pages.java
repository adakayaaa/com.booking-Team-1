package utils;


import pages.HomePage;
import pages.flights.FlightsHomePage;

//TODO
public class Pages {
    private HomePage homePage;
    private FlightsHomePage flightsHomePage;

    public Pages() {
        this.homePage = new HomePage();
        this.flightsHomePage=new FlightsHomePage();
    }

    public HomePage getHomePage() {
        return homePage;
    }

    public FlightsHomePage getFlightsHomePage() {
        return flightsHomePage;
    }
}
