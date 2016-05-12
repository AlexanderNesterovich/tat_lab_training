package by.training.service.impl;

import by.training.dao.DaoFactory;
import by.training.dao.NoteBookProvider;
import by.training.dao.exception.DAOException;
import by.training.dao.localdisk_persistance.FilesDao;
import by.training.model.Book;
import by.training.model.Library;
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
    public List<Book> searchByContent(Map<String, String> args) {
        LOG.trace(">> searchByContent(String s)");
        LOG.debug("Argument: " + getStringArgument(args, "keyword"));
        List<Book> tmp = new ArrayList<>();
        for (Book n : getCatalog()) {
            if (n.getTitle().contains(args.get("keyword"))) {
                tmp.add(n);
            }
        }
        LOG.trace("<< searchByContent(String s)");
        return tmp;
    }

    @Override
    public List<Book> searchByDate(Map<String, String> args) throws ServiceException {
        LOG.trace(">> searchByDate(String s)");
        LOG.debug("Argument: " + getStringArgument(args, "date"));
        try {
            List<Book> tmp = new ArrayList<>();
            for (Book n : getCatalog()) {
                if (format.parse(format.format(n.getPublicationDate())).compareTo(d) == 0) {
                    tmp.add(n);
                }
            }
            LOG.trace("<< searchByDate(String s)");
            return tmp;
        } catch (ParseException e) {
            throw new ServiceException("Failed Search by date! Incorrect date format!", e);
        }

    }

    @Override
    public void addBook(Map<String, String> args) {
        LOG.trace(">> addBook(String content)");
        LOG.debug("Argument: " + args);
        Book book = new Book();
        book.setTitle(getStringArgument(args, "title"));
        book.setLanguague(getStringArgument(args, "lang"));
        book.setAuthor(getStringArgument(args, "author"));
        book.setGenre(getStringArgument(args, "genre"));
        book.setPublicationDate(getDateArgument(args, "publDate"));
        book.setEditionDate(getDateArgument(args, "editionDate"));
        book.setIsbn(getStringArgument(args, "ISBN"));
        book.setPageCount(getIntArgument(args, "pageCount"));

        NoteBookProvider.getInstance().addBook(new Book());
        LOG.trace("<< addBook(String content)");
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
        List<Book> result = NoteBookProvider.getInstance().getNotes();
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
            String tmp = arguments.get(key);
            int tmp;
            try {
                tmp = Integer.parseInt(tmp);
            } catch (NumberFormatException e) {
                LOG.warn("Incorrect Date!");
                return 0;
            }
            if (isbn > 0) {
                return isbn;
            }
            return 0;
        } else {
            return 0;
        }
    }

}
