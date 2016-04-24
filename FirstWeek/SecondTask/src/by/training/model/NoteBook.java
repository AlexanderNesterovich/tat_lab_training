package by.training.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    @Override
    public String toString() {
        return "NoteBook{" +
                "bookList=" + bookList +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NoteBook noteBook = (NoteBook) o;
        return Objects.equals(bookList, noteBook.bookList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookList);
    }
}
