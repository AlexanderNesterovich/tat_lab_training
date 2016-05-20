package by.training.dao.exception;

/**
 * Created by Aliaksandr_Nestsiarovich on 03.05.2016.
 */
public class DAOException extends Exception {

    public DAOException(String message) {
        super(message);
    }

    public DAOException(String message, Exception e) {
        super(message, e);
    }
}
