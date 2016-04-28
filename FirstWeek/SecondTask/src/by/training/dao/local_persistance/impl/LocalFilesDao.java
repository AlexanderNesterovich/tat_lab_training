package by.training.dao.local_persistance.impl;

import by.training.dao.local_persistance.FilesDao;
import by.training.model.NoteBook;
import by.training.service.ServiceFactory;

import java.io.*;

/**
 * Created by Aliaksandr_Nestsiarovich on 4/26/2016.
 */
public class LocalFilesDao implements FilesDao {

    public NoteBook readFromFile(String path) throws IOException, ClassNotFoundException {
        try (FileInputStream fileIn = new FileInputStream(path);
            ObjectInputStream in = new ObjectInputStream(fileIn)) {
            return (NoteBook) in.readObject();
        }
    }

    public void writeToFile(String path) throws IOException {
        try (FileOutputStream fileOut = new FileOutputStream(path);
            ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(ServiceFactory.getInstance().getNoteBookService().getNotebook());
        }
    }

}
