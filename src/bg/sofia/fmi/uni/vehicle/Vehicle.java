package bg.sofia.fmi.uni.vehicle;

import bg.sofia.fmi.uni.driver.Driver;
import bg.sofia.fmi.uni.exceptions.InvalidTimeException;
import bg.sofia.fmi.uni.exceptions.VehicleNotTakenException;
import bg.sofia.fmi.uni.exceptions.VehicleTakenException;

import java.security.InvalidParameterException;
import java.time.LocalDateTime;

public abstract sealed class Vehicle permits Bicycle, Car, Caravan {

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

    public void rent(Driver driver, LocalDateTime startRentTime) throws VehicleTakenException {

        if(driver == null || startRentTime == null) {
            throw new InvalidParameterException("Not proper arguments");
        }

        if(isTaken) {
            throw new VehicleTakenException("The vehicle is already taken");
        }

        this.driver = driver;
        dataOfRent = startRentTime;
        isTaken = true;
    }

    public Driver getDriver() {
        return driver;
    }

    public double returnBack(LocalDateTime rentalEnd) throws VehicleNotTakenException, InvalidTimeException {
        if(rentalEnd == null) {
            throw new InvalidParameterException("Not proper arguments");
        }

        if(!isTaken) {
            System.out.println("This vehicle is taken");
            throw new VehicleNotTakenException("The vehicle is not taken so that it can be returned back");
        }

        if(dataOfRent.isAfter(rentalEnd)) {
            throw new InvalidTimeException("You have given wrong time");
        }

        return calculateRentalPrice(dataOfRent, rentalEnd);
    }

    public abstract double calculateRentalPrice(LocalDateTime startOfRent, LocalDateTime endOfRent);
}
