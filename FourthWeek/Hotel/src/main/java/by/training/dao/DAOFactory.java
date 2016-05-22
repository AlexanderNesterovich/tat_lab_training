package by.training.dao;

import by.training.dao.mysql_impl.UserDaoImpl;

/**
 * Created by Aliaksandr_Nestsiarovich on 4/28/2016.
 */
public class DAOFactory {
    private static final DAOFactory factory = new DAOFactory();

    private final UserDao userDao = new UserDaoImpl();

    private DAOFactory() {
    }

    public static DAOFactory getInstance() {
        return factory;
    }

    public UserDao getUserDao() {
        return userDao;
    }

}
