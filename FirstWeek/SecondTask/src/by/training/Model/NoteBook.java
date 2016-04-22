package by.training.Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aliaksandr_Nestsiarovich on 4/22/2016.
 */
public class NoteBook {

    List<Note> bookList = new ArrayList<Note>();

    public void addNote(Note note) {
        bookList.add(note);
    }

    public void removeNote(Note note) {
        bookList.remove(note);
    }

    public List<Note> getNotes() {
        return bookList;
    }

}
