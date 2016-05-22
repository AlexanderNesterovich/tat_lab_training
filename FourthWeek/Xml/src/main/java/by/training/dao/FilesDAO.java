package by.training.dao;

import by.training.dao.exception.DAOException;
import by.training.bean.Library;

/**
 * Created by Aliaksandr_Nestsiarovich on 4/26/2016.
 */
public interface FilesDAO {

    Library readFromFile(String path) throws DAOException;

    void writeToFile(Library lib, String path) throws DAOException;


}
