package by.training.service;

import by.training.model.Note;
import by.training.model.NoteBook;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

/**
 * Created by Aliaksandr_Nestsiarovich on 4/28/2016.
 */
public interface NoteBookService {
    List<Note> searchByContent(String s);

    List<Note> searchByDate(String s) throws ParseException;

    void addNote(String content, Date date);

    void newNoteBook();

    void readFromFile(String name) throws IOException, ClassNotFoundException;

    void writeToFile(String name) throws IOException;

    List<Note> getCatalog();

    NoteBook getNotebook();
}
