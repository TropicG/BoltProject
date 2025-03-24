package bg.sofia.fmi.uni.vehicle;

import bg.sofia.fmi.uni.driver.Driver;
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

    public void rent(Driver driver, LocalDateTime startRentTime)  {

        if(driver == null || startRentTime == null) {
          //  throw new InvalidParameterException("Not proper arguments");
        }

        if(isTaken) {
         //   throw new VehicleTakenException("The vehicle is already taken");
        }

        this.driver = driver;
        dataOfRent = startRentTime;
        isTaken = true;
    }

    public Driver getDriver() {
        return driver;
    }

    public double returnBack(LocalDateTime rentalEnd) {
        if(rentalEnd == null) {
            return 0.0d;
        }

        if(!isTaken) {
            System.out.println("This vehicle is istaken");
            return 0.0d;
        }

        if(dataOfRent.isAfter(rentalEnd)) {
            System.out.println("Not proper time");
            return 0.0d;
        }

        return calculateRentalPrice(dataOfRent, rentalEnd);
    }

    public abstract double calculateRentalPrice(LocalDateTime startOfRent, LocalDateTime endOfRent);
}
