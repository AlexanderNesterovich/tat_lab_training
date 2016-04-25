package by.training.service;

import by.training.controller.NoteBookProvider;
import by.training.model.Note;
import by.training.model.NoteBook;
import by.training.model.Response;

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
        DateFormat format = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH);
        Date d = format.parse(s);
        List<Note> tmp = new ArrayList<>();
        for(Note n: getCatalog()) {
            if (n.getDate().compareTo(d) == 0) {
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

    public void readFromFile(String path) throws IOException, ClassNotFoundException {
        try(FileInputStream fileIn = new FileInputStream(path);
            ObjectInputStream in = new ObjectInputStream(fileIn)) {
            NoteBook noteBook;
            noteBook = (NoteBook) in.readObject();
            NoteBookProvider.setNew(noteBook);
        }
    }

    public void writeToFile(String path) throws IOException {
        try(FileOutputStream fileOut = new FileOutputStream(path);
            ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(NoteBookProvider.getInstance());
        }
    }

    public List<Note> getCatalog() {
        return NoteBookProvider.getInstance().getNotes();
    }

}
