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
    public double calculateRentalPrice(LocalDateTime startOfRent, LocalDateTime endOfRent) {

        Duration duration = Duration.between(startOfRent,endOfRent);

        long days = duration.toDays();
        long hours = duration.toHours() % 24;

        //in case if the owner only used for one hour
        if(hours == 0 && days == 0) {
            return pricePerHour;
        }

        return (days * pricePerDay) + (hours * pricePerHour);
    }
}
