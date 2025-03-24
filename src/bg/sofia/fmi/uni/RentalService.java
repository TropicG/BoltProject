package bg.sofia.fmi.uni;

import bg.sofia.fmi.uni.driver.Driver;
import bg.sofia.fmi.uni.vehicle.Vehicle;

import java.time.LocalDateTime;

public class RentalService {

    public void rentVehicle(Driver driver, Vehicle vehicle, LocalDateTime startOfRent) {
        vehicle.rent(driver,startOfRent);
    }

    public double returnVehicle(Vehicle vehicle, LocalDateTime endOfRent) {
        return vehicle.returnBack(endOfRent);
    }

}
