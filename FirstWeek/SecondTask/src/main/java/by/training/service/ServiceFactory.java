package by.training.service;

import by.training.service.impl.NoteBookServiceImpl;

/**
 * Created by Aliaksandr_Nestsiarovich on 4/25/2016.
 */
public class ServiceFactory {

    private static final ServiceFactory factory = new ServiceFactory();

    private final NoteBookService noteBookService = new NoteBookServiceImpl();

    private ServiceFactory() {
    }


    public static ServiceFactory getInstance() {
        return factory;
    }

    public NoteBookService getNoteBookService() {
        return noteBookService;
    }

}
