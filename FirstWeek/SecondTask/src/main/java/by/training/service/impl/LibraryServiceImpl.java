package by.training.service.impl;

import by.training.dao.DaoFactory;
import by.training.dao.NoteBookProvider;
import by.training.dao.exception.DAOException;
import by.training.dao.localdisk_persistance.FilesDao;
import by.training.model.*;
import by.training.service.LibraryService;
import by.training.service.exception.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.invoke.MethodHandles;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by Aliaksandr_Nestsiarovich on 4/22/2016.
 */
public class LibraryServiceImpl implements LibraryService {

    private static final Logger LOG = LogManager.getLogger(MethodHandles.lookup().lookupClass());
    private FilesDao filesDao = DaoFactory.getInstance().getLocalFilesDao();
    private DateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public List<Book> searchByTitle(Map<String, String> args) {
        LOG.trace(">> searchByTitle(String s)");
        LOG.debug("Argument: " + getStringArgument(args, "keyword"));
        List<Book> tmp = new ArrayList<>();
        for (Book n : getCatalog()) {
            if (n.getTitle().contains(args.get("keyword"))) {
                tmp.add(n);
            }
        }
        LOG.trace("<< searchByTitle(String s)");
        return tmp;
    }

    @Override
    public List<Book> searchByDate(Map<String, String> args) throws ServiceException {
        LOG.trace(">> searchByDate(String s)");
        LOG.debug("Argument: " + getStringArgument(args, "date"));
        List<Book> tmp = new ArrayList<>();
        for (Book n : getCatalog()) {
            if (n.getPublicationDate().compareTo(getDateArgument(args, "date")) == 0) {
                tmp.add(n);
            }
        }
        LOG.trace("<< searchByDate(String s)");
        return tmp;
    }

    @Override
    public void addBook(Map<String, String> args) throws ServiceException {
        LOG.trace(">> addBook(String content)");
        LOG.debug("Argument: " + args);

        Book book = new Book();

        book.setTitle(getStringArgument(args, "title"));
        book.setAuthor(getStringArgument(args, "author"));
        book.setIsbn(getStringArgument(args, "ISBN"));

        book.setPublicationDate(getDateArgument(args, "publDate"));
        book.setEditionDate(getDateArgument(args, "editionDate"));

        book.setLanguague(Language.fromFriendlyName(getStringArgument(args, "lang")));
        book.setGenre(Genre.fromFriendlyName(getStringArgument(args, "genre")));

        book.setPageCount(getIntArgument(args, "pageCount"));

        NoteBookProvider.getInstance().addBook(book);

        LOG.trace("<< addBook(String content)");
    }

    @Override
    public void addParagraph(Map<String, String> args) throws ServiceException {
        for (Book n : getCatalog()) {
            if (n.getTitle().contains(getStringArgument(args, "book"))) {
                Paragraph p = new Paragraph();
                p.setTitle(getStringArgument(args, "title"));
                p.setPage(getIntArgument(args, "page"));
                n.addParagraph(p);
                return;
            }
        }
        throw new ServiceException("Book not found!");
    }

    @Override
    public void newLibrary() {
        LOG.trace(">> newLibrary()");
        NoteBookProvider.getNew();
        LOG.trace("<< newLibrary()");
    }

    @Override
    public void readFromFile(Map<String, String> args) throws ServiceException {
        LOG.trace(">> readFromFile(String name)");
        LOG.debug("Argument: " + args.get("path"));
        try {
            NoteBookProvider.setNew(filesDao.readFromFile(args.get("path")));
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage(), e);
        }
        LOG.trace("<< readFromFile(String name)");
    }

    @Override
    public void writeToFile(Map<String, String> args) throws ServiceException {
        LOG.trace(">> writeToFile(String name)");
        LOG.debug("Argument: " + args.get("path"));
        try {
            filesDao.writeToFile(args.get("path"));
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage(), e);
        }
        LOG.trace("<< writeToFile(String name)");
    }

    @Override
    public List<Book> getCatalog() {
        LOG.trace(">> getCatalog()");
        List<Book> result = NoteBookProvider.getInstance().getBooks();
        LOG.trace("<< getCatalog()");
        return result;
    }

    @Override
    public Library getLibrary() {
        LOG.trace(">> getLibrary()");
        Library library = NoteBookProvider.getInstance();
        LOG.trace("<< getLibrary()");
        return library;
    }

    private String getStringArgument(Map<String, String> arguments, String key) {
        if (arguments.containsKey(key)) {
            return arguments.get(key);
        } else {
            LOG.warn("Incorrect Argument!");
            return "Warning: Not Assigned";
        }
    }

    private Date getDateArgument(Map<String, String> arguments, String key) {
        if (arguments.containsKey(key)) {
            String tmp = arguments.get(key);
            Date d = null;
            try {
                d = format.parse(tmp);
            } catch (ParseException e) {
                LOG.warn("Incorrect Date!");
                return new Date(0000, 0, 0);
            }
            return d;
        } else {
            return new Date(0000, 0, 0);
        }
    }

    private int getIntArgument(Map<String, String> arguments, String key) {
        if (arguments.containsKey(key)) {
            String original = arguments.get(key);
            int tmp;
            try {
                tmp = Integer.parseInt(original);
            } catch (NumberFormatException e) {
                LOG.warn("Incorrect Date Format!");
                return 0;
            }
            if (tmp > 0) {
                return tmp;
            }
            return 0;
        } else {
            return 0;
        }
    }

}
