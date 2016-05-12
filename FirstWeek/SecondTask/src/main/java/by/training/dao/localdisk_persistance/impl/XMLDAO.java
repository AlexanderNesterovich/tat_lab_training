package by.training.dao.localdisk_persistance.impl;

import by.training.dao.exception.DAOException;
import by.training.dao.localdisk_persistance.FilesDAO;
import by.training.model.Library;

/**
 * Created by Aliaksandr_Nestsiarovich on 5/12/2016.
 */
public class XMLDAO implements FilesDAO {
    @Override
    public Library readFromFile(String name) throws DAOException {
        return null;
    }

    @Override
    public void writeToFile(String name) throws DAOException {

    }
}
