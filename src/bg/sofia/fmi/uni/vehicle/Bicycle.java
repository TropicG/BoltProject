package bg.sofia.fmi.uni.vehicle;

import java.time.Duration;
import java.time.LocalDateTime;

public final class Bicycle extends Vehicle {

    private double pricePerDay;
    private double pricePerHour;

    public Bicycle(String id, String model, double pricePerDay, double pricePerHour) {
        super(id,model);
        this.pricePerDay = pricePerDay;
        this.pricePerHour = pricePerHour;
    }

    @Override
    public double returnBack(LocalDateTime rentalEnd) {

        if(rentalEnd == null) {
            return 0.0d;
        }

        if(!isTaken) {
            System.out.println("This vehicle is not taken");
            return 0.0d;
        }

        if(dataOfRent.isAfter(rentalEnd)) {
            System.out.println("Not proper time");
            return 0.0d;
        }

        Duration duration = Duration.between(dataOfRent, rentalEnd);

        if(duration.toDays() >= 7) {
            System.out.println("You cannot take the vehicle for more than 1 week");
            return 0.0d;
        }


        return calculateRentalPrice(dataOfRent, rentalEnd);
    }

    @Override
    public double calculateRentalPrice(LocalDateTime startOfRent, LocalDateTime endOfRent) {

        if(startOfRent.isAfter(endOfRent)) {
            System.out.println("Unproper time");
            return 0.0d;
        }

        Duration duration = Duration.between(startOfRent,endOfRent);

        long days = duration.toDays();
        long hours = duration.toHours() % 24;

        //in case if the owner only used for one hour
        if(hours == 0 && days == 0) {
            return pricePerHour;
        }

        System.out.println(days);
        System.out.println(hours);

        return (days * pricePerDay) + (hours * pricePerHour);
    }
}
