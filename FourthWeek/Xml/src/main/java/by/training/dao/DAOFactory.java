package by.training.dao;

import by.training.dao.local_persistence.XmlDAO;

/**
 * Created by Aliaksandr_Nestsiarovich on 4/28/2016.
 */
public class DAOFactory {
    private static final DAOFactory factory = new DAOFactory();

    private final FilesDAO localFilesDao = new XmlDAO();

    private DAOFactory() {
    }

    public static DAOFactory getInstance() {
        return factory;
    }

    public FilesDAO getLocalFilesDao() {
        return localFilesDao;
    }

}
