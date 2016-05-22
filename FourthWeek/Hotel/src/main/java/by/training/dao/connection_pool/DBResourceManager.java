package by.training.dao.connection_pool;

/**
 * Created by Alexander Nesterovich on 21.05.2016.
 */
import java.util.ResourceBundle;
public class DBResourceManager {
    private final static DBResourceManager instance = new DBResourceManager();

    private ResourceBundle bundle = ResourceBundle.getBundle("db");

    public static DBResourceManager getInstance() {
        return instance;
    }
    public String getValue(String key){
        return bundle.getString(key);
    }
}
