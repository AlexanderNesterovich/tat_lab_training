package by.training.service;

import by.training.model.Note;
import by.training.model.NoteBook;
import by.training.service.exception.ServiceException;

import java.util.List;

/**
 * Created by Aliaksandr_Nestsiarovich on 4/28/2016.
 */
public interface NoteBookService {
    List<Note> searchByContent(String s);

    List<Note> searchByDate(String s) throws ServiceException;

    void addNote(String content, String strDate) throws ServiceException;

    void addNote(String content);

    void newNoteBook();

    void readFromFile(String name) throws ServiceException;

    void writeToFile(String name) throws ServiceException;

    List<Note> getCatalog();

    NoteBook getNotebook();
}
