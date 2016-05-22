package by.training.dao.local_persistence;

import by.training.dao.exception.DAOException;
import by.training.dao.FilesDAO;
import by.training.bean.Library;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;

/**
 * Created by Aliaksandr_Nestsiarovich on 4/26/2016.
 */
public class SerializationDAO implements FilesDAO {
    private static final Logger LOG = LogManager.getLogger(SerializationDAO.class);

    public Library readFromFile(String path) throws DAOException {
        LOG.trace(">> readFromFile(String path)");
        try (FileInputStream fileIn = new FileInputStream(path);
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
            Library result = (Library) in.readObject();
            LOG.trace("<< readFromFile(String path)");
            return result;
        } catch (ClassNotFoundException e) {
            throw new DAOException("Class not found!", e);
        } catch (IOException e) {
            throw new DAOException("Input/Output exception!", e);
        }

    }

    public void writeToFile(Library lib, String path) throws DAOException {
        LOG.trace(">> writeToFile(String path)");
        try (FileOutputStream fileOut = new FileOutputStream(path);
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(lib);
        } catch (IOException e) {
            throw new DAOException("Input/Output exception!", e);
        }
        LOG.trace("<< writeToFile(String path)");
    }

}
