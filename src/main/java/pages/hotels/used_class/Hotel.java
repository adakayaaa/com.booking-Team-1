package pages.hotels.used_class;


import pages.BasePage;

public class Hotel extends BasePage {
    private  String hotelName;
    private int priceOfHotel;

    public Hotel(){

    }
    public Hotel(String hotelName,int priceOfHotel){
        this.hotelName=hotelName;
        this.priceOfHotel=priceOfHotel;
    }

    public String getHotelName() {
        return hotelName;
    }

    public int getPriceOfHotel() {
        return priceOfHotel;
    }
}
