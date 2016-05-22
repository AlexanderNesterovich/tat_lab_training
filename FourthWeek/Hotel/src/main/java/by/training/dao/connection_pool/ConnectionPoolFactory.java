package by.training.dao.connection_pool;

/**
 * Created by Alexander Nesterovich on 21.05.2016.
 */
public class ConnectionPoolFactory {

        private static final ConnectionPoolFactory factory = new ConnectionPoolFactory();

        private final ConnectionPool connectionPool = new ConnectionPool();

        private ConnectionPoolFactory() {
        }


        public static ConnectionPoolFactory getInstance() {
            return factory;
        }

        public ConnectionPool getConnectionPool() {
            return connectionPool;
        }


}
