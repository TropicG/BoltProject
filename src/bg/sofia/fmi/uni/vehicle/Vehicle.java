package bg.sofia.fmi.uni.vehicle;

import bg.sofia.fmi.uni.driver.Driver;

import java.time.LocalDateTime;

public abstract sealed class Vehicle permits Bicycle {

    private String id;
    private String model;
    protected boolean isTaken;
    private Driver driver;
    protected LocalDateTime dataOfRent;

    public Vehicle(String id, String model) {
        this.id = id;
        this.model = model;
        this.isTaken = false;
    }

    public void rent(Driver driver, LocalDateTime startRentTime) {

        if(driver == null || startRentTime == null) {
            System.out.println("NULL");
        }

        if(isTaken) {
            System.out.println("The vehicle is already taken");
            return;
        }

        driver = driver;
        dataOfRent = startRentTime;
        isTaken = true;
    }

    public abstract double returnBack(LocalDateTime rentalEnd);

    public abstract double calculateRentalPrice(LocalDateTime startOfRent, LocalDateTime endOfRent);
}
