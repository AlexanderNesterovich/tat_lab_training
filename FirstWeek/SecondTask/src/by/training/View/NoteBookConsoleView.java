package by.training.view;

import by.training.model.Note;
import by.training.model.NoteBook;

import java.util.List;

/**
 * Created by Aliaksandr_Nestsiarovich on 4/22/2016.
 */
public class NoteBookConsoleView {

    public static void print(Note n) {
        System.out.println(n.toString());
    }

    public static void print(NoteBook nb) {
        print(nb.getNotes());
    }

    public static void print(List<Note> list) {
        for(Note n: list) {
            print(n);
        }
    }

}
