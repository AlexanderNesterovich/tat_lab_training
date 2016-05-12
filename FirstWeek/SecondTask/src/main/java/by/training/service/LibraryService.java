package by.training.service;

import by.training.model.Book;
import by.training.model.Library;
import by.training.service.exception.ServiceException;

import java.util.List;
import java.util.Map;

/**
 * Created by Aliaksandr_Nestsiarovich on 4/28/2016.
 */
public interface LibraryService {
    List<Book> searchByContent(Map<String, String> args);

    List<Book> searchByDate(Map<String, String> args) throws ServiceException;

    void addBook(Map<String, String> args);

    void newLibrary();

    void readFromFile(Map<String, String> args) throws ServiceException;

    void writeToFile(Map<String, String> args) throws ServiceException;

    List<Book> getCatalog();

    Library getLibrary();
}
