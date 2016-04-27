package by.training.dao;

import by.training.model.NoteBook;
import by.training.service.ServiceFactory;

import java.io.*;

/**
 * Created by Aliaksandr_Nestsiarovich on 4/26/2016.
 */
public class WindowsFilesDao implements FilesDao{

    private String path = "C:/tmp/";
    private String ext = ".ser";

    public NoteBook readFromFile(String name) throws IOException, ClassNotFoundException {
        try(FileInputStream fileIn = new FileInputStream(path + name + ext);
            ObjectInputStream in = new ObjectInputStream(fileIn)) {
            return (NoteBook) in.readObject();
        }
    }

    public void writeToFile(String name) throws IOException {
        try(FileOutputStream fileOut = new FileOutputStream(path + name + ext);
            ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(ServiceFactory.getInstance().getNoteBookService().getNotebook());
        }
    }

}
