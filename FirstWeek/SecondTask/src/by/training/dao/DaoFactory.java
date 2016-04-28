package by.training.dao;

import by.training.dao.local_persistance.FilesDao;
import by.training.dao.local_persistance.impl.LocalFilesDao;
import by.training.dao.parser.Parser;
import by.training.dao.parser.impl.TxtParser;

/**
 * Created by Aliaksandr_Nestsiarovich on 4/28/2016.
 */
public class DaoFactory {
    private static final DaoFactory factory = new DaoFactory();

    private final FilesDao localFilesDao = new LocalFilesDao();
    private final Parser txtParser = new TxtParser();

    private DaoFactory() {
    }


    public static DaoFactory getInstance() {
        return factory;
    }

    public FilesDao getLocalFilesDao() {
        return localFilesDao;
    }

    public Parser getTxtParser() {
        return txtParser;
    }
}
