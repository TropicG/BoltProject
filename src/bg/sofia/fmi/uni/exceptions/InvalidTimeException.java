package bg.sofia.fmi.uni.exceptions;

public class InvalidTimeException extends Exception{

    public InvalidTimeException(String message) {
        super(message);
    }

    public InvalidTimeException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
