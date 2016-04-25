package by.training.service;

import by.training.controller.NoteBookProvider;
import by.training.model.Note;

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
        List<Note> tmp = new ArrayList<Note>();
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
        List<Note> tmp = new ArrayList<Note>();
        for(Note n: getCatalog()) {
            if (n.getDate().compareTo(d) == 0) {
                tmp.add(n);
            }
        }
        return tmp;
    }



    public List<Note> getCatalog() {
        return NoteBookProvider.getInstance().getNotes();
    }

}
