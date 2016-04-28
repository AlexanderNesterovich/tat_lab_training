package by.training.dao;

import by.training.dao.localdisk_persistance.FilesDao;
import by.training.dao.localdisk_persistance.impl.LocalFilesDao;

/**
 * Created by Aliaksandr_Nestsiarovich on 4/28/2016.
 */
public class DaoFactory {
    private static final DaoFactory factory = new DaoFactory();

    private final FilesDao localFilesDao = new LocalFilesDao();

    private DaoFactory() {
    }

    public static DaoFactory getInstance() {
        return factory;
    }

    public FilesDao getLocalFilesDao() {
        return localFilesDao;
    }

}
