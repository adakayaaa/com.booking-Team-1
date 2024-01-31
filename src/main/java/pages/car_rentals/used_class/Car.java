package pages.car_rentals.used_class;

import pages.BasePage;

public class Car extends BasePage {
    private  String carName;
    private int priceOfCar;

    public Car(){

    }
    public Car(String carName,int priceOfCar){
        this.carName=carName;
        this.priceOfCar=priceOfCar;
    }

    public String getHotelName() {
        return carName;
    }

    public int getPriceOfHotel() {
        return priceOfCar;
    }
}
