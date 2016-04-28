package by.training.service.impl;

import by.training.dao.local_persistance.FilesDao;
import by.training.dao.local_persistance.impl.LocalFilesDao;
import by.training.model.Note;
import by.training.model.NoteBook;
import by.training.service.NoteBookProvider;
import by.training.service.NoteBookServicei;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Aliaksandr_Nestsiarovich on 4/22/2016.
 */
public class NoteBookService implements NoteBookServicei {

    private FilesDao filesDao = new LocalFilesDao();

    public List<Note> searchByContent(String s) {
        List<Note> tmp = new ArrayList<>();
        for(Note n: getCatalog()) {
            if (n.getNote().contains(s)) {
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
        NoteBookProvider.getInstance().addNote(new Note(content, date));
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

    public NoteBook getNotebook() {
        return NoteBookProvider.getInstance();
    }

}
