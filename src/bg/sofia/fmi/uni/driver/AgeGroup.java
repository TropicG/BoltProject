package bg.sofia.fmi.uni.driver;

public enum AgeGroup {

    JUNIOR(10),
    EXPIRIENCED(0),
    SENIOR(15);

    private final int startingDeposit;

    AgeGroup(final int startingDeposit) {
        this.startingDeposit = startingDeposit;
    }
}
