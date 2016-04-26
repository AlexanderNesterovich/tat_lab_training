package by.training.dao;

import by.training.model.NoteBook;

import java.io.IOException;

/**
 * Created by Aliaksandr_Nestsiarovich on 4/26/2016.
 */
public interface FilesDao {

    public NoteBook readFromFile(String name) throws IOException, ClassNotFoundException;
    public void writeToFile(String name) throws IOException;


}
