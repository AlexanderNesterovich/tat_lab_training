package by.training.Service;

import by.training.Controller.NoteBookProvider;
import by.training.Model.Note;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    public List<Note> searchByDate(Date d) {
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
