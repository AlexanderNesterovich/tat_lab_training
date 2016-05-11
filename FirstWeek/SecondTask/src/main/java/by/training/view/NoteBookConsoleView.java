package by.training.view;

import by.training.model.Book;
import by.training.model.Library;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by Aliaksandr_Nestsiarovich on 4/22/2016.
 */
public class NoteBookConsoleView {

    public static String print(Library nb) {
        return print(nb.getNotes());
    }

    public static String print(List<Book> list) {
        StringBuffer tmp = new StringBuffer();
        for (Book n : list) {
            tmp.append(print(n));
        }
        return tmp.toString();
    }

    public static String print(Book n) {
        StringBuffer tmp = new StringBuffer();
        tmp.append("content: " + n.getTitle() + "\n");
        DateFormat outputFormatter = new SimpleDateFormat("yyyy/MM/dd");
        tmp.append("date: " + outputFormatter.format(n.getPublicationDate()) + "\n");
        return tmp.toString();
    }

}
