package bg.sofia.fmi.uni.vehicle;

import java.time.Duration;
import java.time.LocalDateTime;

public final class Caravan extends Vehicle{

    private final FuelType fuelType;
    private final int numberOfSeats;
    private final int numberOfBeds;
    private final double pricePerWeek;
    private final double pricePerDay;
    private final double pricePerHour;

    public Caravan(String id, String model, FuelType fuelType,
                   int numberOfSeats, int numberOfBeds,
                   double pricePerWeek, double pricePerDay, double pricePerHour) {
        super(id, model);
        this.fuelType = fuelType;
        this.numberOfSeats = numberOfSeats;
        this.numberOfBeds = numberOfBeds;
        this.pricePerWeek = pricePerWeek;
        this.pricePerDay = pricePerDay;
        this.pricePerHour = pricePerHour;
    }

    @Override
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

    @Override
    public double calculateRentalPrice(LocalDateTime startOfRent, LocalDateTime endOfRent){

        if(startOfRent.isAfter(endOfRent)) {
            System.out.println("Unproper time");
            return 0.0d;
        }

        Duration duration = Duration.between(startOfRent,endOfRent);

        long weeks = duration.toDays() / 7;
        long days = duration.toDays() % 7;
        long hours = duration.toHours() % 24;

        //in case if the owner only used for one hour
        if(days == 0 && weeks == 0 && hours > 0) {
            System.out.println("Bad time duration");
            return 0.0d;
        }

        return (weeks * pricePerWeek) + (days * pricePerDay * fuelType.getFuelType()) + (hours * pricePerHour) + super.getDriver().ageGroup().ordinal() + (numberOfBeds * 10) + (numberOfSeats * 5);
    }
}
