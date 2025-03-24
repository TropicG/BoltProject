package bg.sofia.fmi.uni.exceptions;

public class VehicleNotTakenException extends Exception{

    public VehicleNotTakenException(String message) {
        super(message);
    }

    public VehicleNotTakenException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
