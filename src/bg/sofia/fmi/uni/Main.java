package bg.sofia.fmi.uni;

import bg.sofia.fmi.uni.driver.AgeGroup;
import bg.sofia.fmi.uni.driver.Driver;
import bg.sofia.fmi.uni.vehicle.Bicycle;
import bg.sofia.fmi.uni.vehicle.Car;
import bg.sofia.fmi.uni.vehicle.FuelType;
import bg.sofia.fmi.uni.vehicle.Vehicle;

import java.time.LocalDateTime;

public class Main {


    public static void main(String[] args) {

        //basic testing
        RentalService rentalService = new RentalService();
        LocalDateTime rentStart = LocalDateTime.of(2024, 10, 10, 0, 0, 0);
        Driver experiencedDriver = new Driver(AgeGroup.EXPERIENCED);

        Vehicle electricCar = new Car("1", "Tesla Model 3", FuelType.ELECTRICITY, 4, 1000, 150, 10);
        rentalService.rentVehicle(experiencedDriver, electricCar, rentStart);
        double priceToPay = rentalService.returnVehicle(electricCar, rentStart.plusDays(5)); // 770.0
        System.out.println(priceToPay);

        Vehicle dieselCar = new Car("2", "Toyota Auris", FuelType.DIESEL, 4, 500, 80, 5);
        rentalService.rentVehicle(experiencedDriver, dieselCar, rentStart);
        priceToPay = rentalService.returnVehicle(dieselCar, rentStart.plusDays(5)); // 80*5 + 3*5 + 4*5 = 435.0
        System.out.println(priceToPay);
    }
}
