package by.training.dao.localdisk_persistance;

import by.training.dao.exception.DAOException;
import by.training.model.Library;

/**
 * Created by Aliaksandr_Nestsiarovich on 4/26/2016.
 */
public interface FilesDAO {

    Library readFromFile(String name) throws DAOException;

    void writeToFile(String name) throws DAOException;


}
