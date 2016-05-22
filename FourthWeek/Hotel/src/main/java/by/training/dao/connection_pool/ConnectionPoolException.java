package by.training.dao.connection_pool;

/**
 * Created by Alexander Nesterovich on 21.05.2016.
 */
public class ConnectionPoolException extends Exception {
    private static final long serialVersionUID = 1L;
    public ConnectionPoolException(String message, Exception e){
        super(message, e);
    }
}
