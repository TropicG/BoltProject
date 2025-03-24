package bg.sofia.fmi.uni.vehicle;

import bg.sofia.fmi.uni.driver.Driver;

import java.time.LocalDateTime;

public abstract class Vehicle {

    private String id;
    private String model;
    private boolean isTaken;
    private Driver driver;
    private LocalDateTime dataOfRent;

    public Vehicle(String id, String model) {
        this.id = id;
        this.model = model;
    }

    public void rent(Driver driver, LocalDateTime startRentTime) {

        if(isTaken) {
            System.out.println("The vehicle is already taken");
            return;
        }

        driver = driver;
        dataOfRent = startRentTime;
        isTaken = true;
    }

    public abstract void returnBack(LocalDateTime rentalEnd);

    public abstract double calculateRentalPrice(LocalDateTime startOfRent, LocalDateTime endOfRent);
}
