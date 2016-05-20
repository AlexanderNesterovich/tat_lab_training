package by.training.controller.exception;

/**
 * Created by Aliaksandr_Nestsiarovich on 4/28/2016.
 */
public class UnsupportedCommandException extends Exception {

    public UnsupportedCommandException(String message) {
        super(message);
    }

    public UnsupportedCommandException(String message, Exception e) {
        super(message, e);
    }

}
