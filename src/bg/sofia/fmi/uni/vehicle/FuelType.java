package bg.sofia.fmi.uni.vehicle;

public enum FuelType {

    DIESEL(3),
    PETROL(3),
    HYBRID(1),
    ELECTRICITY(0),
    HYDROGEN(0);

    private final int fuelType;

    FuelType(int fuelType) {
        this.fuelType = fuelType;
    }
}
