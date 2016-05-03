package by.training.dao.localdisk_persistance.impl;

import by.training.dao.exception.DAOException;
import by.training.dao.localdisk_persistance.FilesDao;
import by.training.model.NoteBook;
import by.training.service.ServiceFactory;

import java.io.*;

/**
 * Created by Aliaksandr_Nestsiarovich on 4/26/2016.
 */
public class LocalFilesDao implements FilesDao {

    public NoteBook readFromFile(String path) throws DAOException {
        try (FileInputStream fileIn = new FileInputStream(path);
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
            return (NoteBook) in.readObject();
        } catch (ClassNotFoundException e) {
            throw new DAOException("Class not found!", e);
        } catch (IOException e) {
            throw new DAOException("Input/Output exception!", e);
        }
    }

    public void writeToFile(String path) throws DAOException {
        try (FileOutputStream fileOut = new FileOutputStream(path);
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(ServiceFactory.getInstance().getNoteBookService().getNotebook());
        } catch (IOException e) {
            throw new DAOException("Input/Output exception!", e);
        }
    }

}
