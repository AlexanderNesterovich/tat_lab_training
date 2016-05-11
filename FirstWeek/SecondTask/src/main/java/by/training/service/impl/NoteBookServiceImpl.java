package by.training.service.impl;

import by.training.dao.DaoFactory;
import by.training.dao.NoteBookProvider;
import by.training.dao.exception.DAOException;
import by.training.dao.localdisk_persistance.FilesDao;
import by.training.model.Book;
import by.training.model.Library;
import by.training.service.NoteBookService;
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
public class NoteBookServiceImpl implements NoteBookService {

    private static final Logger LOG = LogManager.getLogger(MethodHandles.lookup().lookupClass());
    private FilesDao filesDao = DaoFactory.getInstance().getLocalFilesDao();

    @Override
    public List<Book> searchByContent(Map<String, String> args) {
        LOG.trace(">> searchByContent(String s)");
        LOG.debug("Argument: " + args.get("path"));
        List<Book> tmp = new ArrayList<>();
        for (Book n : getCatalog()) {
            if (n.getTitle().contains(args.get("path"))) {
                tmp.add(n);
            }
        }
        LOG.trace("<< searchByContent(String s)");
        return tmp;
    }

    @Override
    public List<Book> searchByDate(Map<String, String> args) throws ServiceException {
        LOG.trace(">> searchByDate(String s)");
        LOG.debug("Argument: " + args.get("path"));
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date d = format.parse(args.get("path"));
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
        NoteBookProvider.getInstance().addNote(new Book.Builder().build());
        LOG.trace("<< addBook(String content)");
    }

    @Override
    public void newNoteBook() {
        LOG.trace(">> newNoteBook()");
        NoteBookProvider.getNew();
        LOG.trace("<< newNoteBook()");
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
    public Library getNotebook() {
        LOG.trace(">> getNotebook()");
        Library library = NoteBookProvider.getInstance();
        LOG.trace("<< getNotebook()");
        return library;
    }

}
