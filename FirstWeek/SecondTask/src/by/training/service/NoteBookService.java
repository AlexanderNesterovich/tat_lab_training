package by.training.service;

import by.training.dao.FilesDao;
import by.training.dao.WindowsFilesDao;
import by.training.model.Note;

import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Created by Aliaksandr_Nestsiarovich on 4/22/2016.
 */
public class NoteBookService {

    private FilesDao filesDao = new WindowsFilesDao();

    public List<Note> searchByContent(String s) {
        List<Note> tmp = new ArrayList<>();
        for(Note n: getCatalog()) {
            if (n.getNote().equals(s)) {
                tmp.add(n);
            }
        }
        return tmp;
    }

    public List<Note> searchByDate(String s) throws ParseException {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date d = format.parse(s);
        List<Note> tmp = new ArrayList<>();
        for(Note n: getCatalog()) {
            if (format.parse(format.format(n.getDate())).compareTo(d) == 0) {
                tmp.add(n);
            }
        }
        return tmp;
    }

    public void addNote(String content, Date date) {
        NoteBookProvider.getInstance().addNote(new Note(content));
    }

    public void newNoteBook() {
        NoteBookProvider.getNew();
    }

    public void readFromFile(String name) throws IOException, ClassNotFoundException {
        NoteBookProvider.setNew(filesDao.readFromFile(name));
    }

    public void writeToFile(String name) throws IOException {
        filesDao.writeToFile(name);
    }

    public List<Note> getCatalog() {
        return NoteBookProvider.getInstance().getNotes();
    }

}
