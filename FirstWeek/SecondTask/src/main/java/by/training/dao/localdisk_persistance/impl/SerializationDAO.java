package by.training.dao.localdisk_persistance.impl;

import by.training.dao.exception.DAOException;
import by.training.dao.localdisk_persistance.FilesDAO;
import by.training.model.Library;
import by.training.service.ServiceFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.lang.invoke.MethodHandles;

/**
 * Created by Aliaksandr_Nestsiarovich on 4/26/2016.
 */
public class SerializationDAO implements FilesDAO {
    private static final Logger LOG = LogManager.getLogger(MethodHandles.lookup().lookupClass());

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

    public void writeToFile(String path) throws DAOException {
        LOG.trace(">> writeToFile(String path)");
        try (FileOutputStream fileOut = new FileOutputStream(path);
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(ServiceFactory.getInstance().getLibraryService().getLibrary());
        } catch (IOException e) {
            throw new DAOException("Input/Output exception!", e);
        }
        LOG.trace("<< writeToFile(String path)");
    }

}
