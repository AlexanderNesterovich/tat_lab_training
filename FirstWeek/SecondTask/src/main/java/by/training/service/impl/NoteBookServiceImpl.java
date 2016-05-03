package by.training.service.impl;

import by.training.dao.DaoFactory;
import by.training.dao.NoteBookProvider;
import by.training.dao.exception.DAOException;
import by.training.dao.localdisk_persistance.FilesDao;
import by.training.model.Note;
import by.training.model.NoteBook;
import by.training.service.NoteBookService;
import by.training.service.exception.ServiceException;

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

    private FilesDao filesDao = DaoFactory.getInstance().getLocalFilesDao();

    @Override
    public List<Note> searchByContent(String s) {
        List<Note> tmp = new ArrayList<>();
        for (Note n : getCatalog()) {
            if (n.getNote().contains(s)) {
                tmp.add(n);
            }
        }
        return tmp;
    }

    @Override
    public List<Note> searchByDate(String s) throws ServiceException {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date d = format.parse(s);
            List<Note> tmp = new ArrayList<>();
            for (Note n : getCatalog()) {
                if (format.parse(format.format(n.getDate())).compareTo(d) == 0) {
                    tmp.add(n);
                }
            }
            return tmp;
        } catch (ParseException e) {
            throw new ServiceException("Failed Search by date! Incorrect date format!", e);
        }

    }

    @Override
    public void addNote(String content, String strDate) throws ServiceException {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = format.parse(strDate);
            NoteBookProvider.getInstance().addNote(new Note(content, date));
        } catch (ParseException e) {
            throw new ServiceException("Failed to parse date!", e);
        }

    }

    @Override
    public void addNote(String content) {
        NoteBookProvider.getInstance().addNote(new Note(content, new Date()));
    }

    @Override
    public void newNoteBook() {
        NoteBookProvider.getNew();
    }

    @Override
    public void readFromFile(String name) throws ServiceException {
        try {
            NoteBookProvider.setNew(filesDao.readFromFile(name));
        } catch (DAOException e) {
            throw new ServiceException("Cannot read from file!", e);
        }
    }

    @Override
    public void writeToFile(String name) throws ServiceException {
        try {
            filesDao.writeToFile(name);
        } catch (DAOException e) {
            throw new ServiceException("Cannot write to file!", e);
        }
    }

    @Override
    public List<Note> getCatalog() {
        return NoteBookProvider.getInstance().getNotes();
    }

    @Override
    public NoteBook getNotebook() {
        return NoteBookProvider.getInstance();
    }

}
