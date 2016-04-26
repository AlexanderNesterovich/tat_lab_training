package by.training.view;

import by.training.model.Note;
import by.training.model.NoteBook;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Aliaksandr_Nestsiarovich on 4/22/2016.
 */
public class NoteBookConsoleView {

    public static String print(NoteBook nb) {
        return print(nb.getNotes());
    }

    public static String print(List<Note> list) {
        StringBuffer tmp = new StringBuffer();
        for(Note n: list) {
            tmp.append(print(n));
        }
        return tmp.toString();
    }

    public static String print(Note n) {
        StringBuffer tmp = new StringBuffer();
        tmp.append("content: " + n.getNote() + "\n");
        DateFormat outputFormatter = new SimpleDateFormat("yyyy/MM/dd");
        tmp.append("date: " + outputFormatter.format(n.getDate()) + "\n");
        return tmp.toString();
    }

}
