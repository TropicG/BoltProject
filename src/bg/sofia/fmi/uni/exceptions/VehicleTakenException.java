package bg.sofia.fmi.uni.exceptions;

public class VehicleTakenException extends Exception{

    public VehicleTakenException(String message) {
        super(message);
    }

    public VehicleTakenException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
