package by.training.service.exception;

/**
 * Created by Aliaksandr_Nestsiarovich on 03.05.2016.
 */
public class ServiceException extends Exception {

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Exception e) {
        super(message, e);
    }

}
