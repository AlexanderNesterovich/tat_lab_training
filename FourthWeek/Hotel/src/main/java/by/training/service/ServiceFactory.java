package by.training.service;

import by.training.service.impl.LibraryServiceImpl;

/**
 * Created by Aliaksandr_Nestsiarovich on 4/25/2016.
 */
public class ServiceFactory {

    private static final ServiceFactory factory = new ServiceFactory();

    private final LibraryService libraryService = new LibraryServiceImpl();

    private ServiceFactory() {
    }


    public static ServiceFactory getInstance() {
        return factory;
    }

    public LibraryService getLibraryService() {
        return libraryService;
    }

}
