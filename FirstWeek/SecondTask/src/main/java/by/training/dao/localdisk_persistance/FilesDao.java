package by.training.dao.localdisk_persistance;

import by.training.dao.exception.DAOException;
import by.training.model.NoteBook;

/**
 * Created by Aliaksandr_Nestsiarovich on 4/26/2016.
 */
public interface FilesDao {

    NoteBook readFromFile(String name) throws DAOException;

    void writeToFile(String name) throws DAOException;


}
