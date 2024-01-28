package utils;


import pages.HomePage;
import pages.car_rentals.CarRentalsCheckoutPage;
import pages.car_rentals.CarRentalsDetailsPage;
import pages.car_rentals.CarRentalsFilteringPage;
import pages.car_rentals.CarRentalsHomePage;
import pages.flights.*;
import pages.hotels.*;

public class Pages {
    private HomePage homePage;
    private FlightsHomePage flightsHomePage;
    private FlightsBookingPage flightsBookingPage;
    private FlightsCheckoutPage flightsCheckoutPage;
    private FlightsDetailsPage flightsDetailsPage;
    private FlightsExtraPage flightsExtraPage;
    private FlightsResultPage flightsResultPage;
    private FlightsFilteringPage flightsFilteringPage;
    private CarRentalsCheckoutPage carRentalsCheckoutPage;
    private CarRentalsHomePage carRentalsHomePage;
    private CarRentalsDetailsPage carRentalsDetailsPage;
    private CarRentalsFilteringPage carRentalsFilteringPage;

    private HotelsHomePage hotelsHomePage;
    private HotelsCheckoutPage hotelsCheckoutPage;
    private HotelsBookingPage hotelsBookingPage;
    private HotelsFilteringPage hotelsFilteringPage;
    private HotelsDetailsPage hotelsDetailsPage;

    public Pages() {
        this.homePage = new HomePage();
        this.flightsHomePage = new FlightsHomePage();
        this.flightsBookingPage = new FlightsBookingPage();
        this.flightsCheckoutPage = new FlightsCheckoutPage();
        this.flightsDetailsPage = new FlightsDetailsPage();
        this.flightsExtraPage = new FlightsExtraPage();
        this.flightsResultPage = new FlightsResultPage();
        this.flightsFilteringPage = new FlightsFilteringPage();
        this.carRentalsCheckoutPage = new CarRentalsCheckoutPage();
        this.carRentalsHomePage = new CarRentalsHomePage();
        this.carRentalsDetailsPage = new CarRentalsDetailsPage();
        this.carRentalsFilteringPage = new CarRentalsFilteringPage();
        this.hotelsHomePage = new HotelsHomePage();
        this.hotelsCheckoutPage = new HotelsCheckoutPage();
        this.hotelsBookingPage = new HotelsBookingPage();
        this.hotelsFilteringPage = new HotelsFilteringPage();
        this.hotelsDetailsPage = new HotelsDetailsPage();
    }

    public FlightsBookingPage getFlightsBookingPage() {
        return flightsBookingPage;
    }

    public FlightsCheckoutPage getFlightsCheckoutPage() {
        return flightsCheckoutPage;
    }

    public FlightsDetailsPage getFlightsDetailsPage() {
        return flightsDetailsPage;
    }

    public FlightsExtraPage getFlightsExtraPage() {
        return flightsExtraPage;
    }

    public FlightsResultPage getFlightsResultPage() {
        return flightsResultPage;
    }

    public FlightsFilteringPage getFlightsFilteringPage() {
        return flightsFilteringPage;
    }

    public CarRentalsCheckoutPage getCarRentalsCheckoutPage() {
        return carRentalsCheckoutPage;
    }

    public CarRentalsHomePage getCarRentalsHomePage() {
        return carRentalsHomePage;
    }

    public CarRentalsDetailsPage getCarRentalsDetailsPage() {
        return carRentalsDetailsPage;
    }

    public CarRentalsFilteringPage getCarRentalsFilteringPage() {
        return carRentalsFilteringPage;
    }

    public HotelsHomePage getHotelsHomePage() {
        return hotelsHomePage;
    }

    public HotelsCheckoutPage getHotelsCheckoutPage() {
        return hotelsCheckoutPage;
    }

    public HotelsBookingPage getHotelsBookingPage() {
        return hotelsBookingPage;
    }

    public HotelsFilteringPage getHotelsFilteringPage() {
        return hotelsFilteringPage;
    }

    public HotelsDetailsPage getHotelsDetailsPage() {
        return hotelsDetailsPage;
    }

    public HomePage getHomePage() {
        return homePage;
    }

    public FlightsHomePage getFlightsHomePage() {
        return flightsHomePage;
    }
}
