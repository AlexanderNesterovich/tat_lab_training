package by.training.view;

import by.training.model.Book;
import by.training.model.Library;
import by.training.model.Paragraph;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.invoke.MethodHandles;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by Aliaksandr_Nestsiarovich on 4/22/2016.
 */
public class NoteBookConsoleView {


    private static final Logger LOG = LogManager.getLogger(MethodHandles.lookup().lookupClass());
    public static String print(Library nb) {
        return print(nb.getBooks());
    }

    public static String print(List<Book> list) {
        StringBuffer tmp = new StringBuffer();
        for (Book n : list) {
            tmp.append(print(n));
        }
        return tmp.toString();
    }

    public static String print(Book n) {
        LOG.trace(">> print(Book n)");
        StringBuffer tmp = new StringBuffer();
        DateFormat outputFormatter = new SimpleDateFormat("yyyy/MM/dd");
        tmp.append("Title: " + n.getTitle() + "\n");
        tmp.append("Author: " + n.getAuthor() + "\n");
        tmp.append("Genre: " + n.getGenre() + "\n");
        tmp.append("ISBN: " + n.getIsbn() + "\n");
        tmp.append("Lang: " + n.getLanguague() + "\n");
        tmp.append("PageCount: " + n.getPageCount() + "\n");
        tmp.append("Publication Date: " + outputFormatter.format(n.getPublicationDate()) + "\n");
        tmp.append("Edition Date: " + outputFormatter.format(n.getEditionDate()) + "\n");
        for (Paragraph p : n.getParagraphList()) {
            tmp.append(" Paragraph: " + p.getTitle() + "\n");
            tmp.append(" Page: " + p.getPage() + "\n");
        }
        tmp.append("\n");
        LOG.trace("<< print(Book n)");
        return tmp.toString();
    }

}
