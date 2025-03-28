package bg.sofia.fmi.uni;

import bg.sofia.fmi.uni.driver.Driver;
import bg.sofia.fmi.uni.exceptions.InvalidTimeException;
import bg.sofia.fmi.uni.exceptions.VehicleNotTakenException;
import bg.sofia.fmi.uni.exceptions.VehicleTakenException;
import bg.sofia.fmi.uni.vehicle.Vehicle;

import java.time.LocalDateTime;

public class RentalService {

    public void rentVehicle(Driver driver, Vehicle vehicle, LocalDateTime startOfRent) throws VehicleTakenException {
        vehicle.rent(driver,startOfRent);
    }

    public double returnVehicle(Vehicle vehicle, LocalDateTime endOfRent) throws InvalidTimeException, VehicleNotTakenException {
        return vehicle.returnBack(endOfRent);
    }

}
