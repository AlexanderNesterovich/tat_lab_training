package by.training.service.impl;

import by.training.dao.DaoFactory;
import by.training.dao.NoteBookProvider;
import by.training.dao.exception.DAOException;
import by.training.dao.localdisk_persistance.FilesDao;
import by.training.model.Note;
import by.training.model.NoteBook;
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

/**
 * Created by Aliaksandr_Nestsiarovich on 4/22/2016.
 */
public class NoteBookServiceImpl implements NoteBookService {

    private static final Logger LOG = LogManager.getLogger(MethodHandles.lookup().lookupClass());
    private FilesDao filesDao = DaoFactory.getInstance().getLocalFilesDao();

    @Override
    public List<Note> searchByContent(String s) {
        LOG.trace(">> searchByContent(String s)");
        LOG.debug("Argument: " + s);
        List<Note> tmp = new ArrayList<>();
        for (Note n : getCatalog()) {
            if (n.getNote().contains(s)) {
                tmp.add(n);
            }
        }
        LOG.trace("<< searchByContent(String s)");
        return tmp;
    }

    @Override
    public List<Note> searchByDate(String s) throws ServiceException {
        LOG.trace(">> searchByDate(String s)");
        LOG.debug("Argument: " + s);
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date d = format.parse(s);
            List<Note> tmp = new ArrayList<>();
            for (Note n : getCatalog()) {
                if (format.parse(format.format(n.getDate())).compareTo(d) == 0) {
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
    public void addNote(String content, String strDate) throws ServiceException {
        LOG.trace(">> addNote(String content, String strDate)");
        LOG.debug("Argument1: " + content + "\n" + "Argument2: " + strDate);
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = format.parse(strDate);
            NoteBookProvider.getInstance().addNote(new Note(content, date));
        } catch (ParseException e) {
            throw new ServiceException("Failed to parse date!", e);
        }
        LOG.trace("<< addNote(String content, String strDate)");

    }

    @Override
    public void addNote(String content) {
        LOG.trace(">> addNote(String content)");
        LOG.debug("Argument: " + content);
        NoteBookProvider.getInstance().addNote(new Note(content, new Date()));
        LOG.trace("<< addNote(String content)");
    }

    @Override
    public void newNoteBook() {
        LOG.trace(">> newNoteBook()");
        NoteBookProvider.getNew();
        LOG.trace("<< newNoteBook()");
    }

    @Override
    public void readFromFile(String name) throws ServiceException {
        LOG.trace(">> readFromFile(String name)");
        LOG.debug("Argument: " + name);
        try {
            NoteBookProvider.setNew(filesDao.readFromFile(name));
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage(), e);
        }
        LOG.trace("<< readFromFile(String name)");
    }

    @Override
    public void writeToFile(String name) throws ServiceException {
        LOG.trace(">> writeToFile(String name)");
        LOG.debug("Argument: " + name);
        try {
            filesDao.writeToFile(name);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage(), e);
        }
        LOG.trace("<< writeToFile(String name)");
    }

    @Override
    public List<Note> getCatalog() {
        LOG.trace(">> getCatalog()");
        List<Note> result = NoteBookProvider.getInstance().getNotes();
        LOG.trace("<< getCatalog()");
        return result;
    }

    @Override
    public NoteBook getNotebook() {
        LOG.trace(">> getNotebook()");
        NoteBook noteBook = NoteBookProvider.getInstance();
        LOG.trace("<< getNotebook()");
        return noteBook;
    }

}
