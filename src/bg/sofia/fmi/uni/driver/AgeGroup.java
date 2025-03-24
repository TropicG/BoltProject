package bg.sofia.fmi.uni.driver;

public enum AgeGroup {

    JUNIOR(10),
    EXPERIENCED(0),
    SENIOR(15);

    private final int startingDeposit;

    AgeGroup(final int startingDeposit) {
        this.startingDeposit = startingDeposit;
    }

    public int getAgeGroup() {
        return startingDeposit;
    }
}
