package bg.sofia.fmi.uni.vehicle;

import java.time.Duration;
import java.time.LocalDateTime;

public final class Car extends Vehicle {

    private final FuelType fuelType;
    private final int numberOfSeats;
    private final double pricePerWeek;
    private final double pricePerDay;
    private final double pricePerHour;

    public Car(String id, String model, FuelType fuelType,
                int numberOfSeats,
               double pricePerWeek, double pricePerDay, double pricePerHour) {

        super(id, model);
        this.fuelType = fuelType;
        this.numberOfSeats = numberOfSeats;
        this.pricePerWeek = pricePerWeek;
        this.pricePerDay = pricePerDay;
        this.pricePerHour = pricePerHour;
    }

    @Override
    public double calculateRentalPrice(LocalDateTime startOfRent, LocalDateTime endOfRent){

        Duration duration = Duration.between(startOfRent,endOfRent);

        long weeks = duration.toDays() / 7;
        long days = duration.toDays() % 7;
        long hours = duration.toHours() % 24;

        //in case if the owner only used for one hour
        if(hours == 0 && days == 0) {
            return pricePerHour;
        }

        //formula to calculate how much will the rent cost for the Car
        return (weeks * pricePerWeek) + ((days * pricePerDay) + (fuelType.getFuelType() * days)) + (hours * pricePerHour)
                + super.getDriver().ageGroup().getAgeGroup() + (numberOfSeats * 5);
    }
}
