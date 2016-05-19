package by.training.dao;

import by.training.dao.localdisk_persistance.FilesDAO;
import by.training.dao.localdisk_persistance.impl.SerializationDAO;

/**
 * Created by Aliaksandr_Nestsiarovich on 4/28/2016.
 */
public class DAOFactory {
    private static final DAOFactory factory = new DAOFactory();

    private final FilesDAO localFilesDao = new SerializationDAO();

    private DAOFactory() {
    }

    public static DAOFactory getInstance() {
        return factory;
    }

    public FilesDAO getLocalFilesDao() {
        return localFilesDao;
    }

}
