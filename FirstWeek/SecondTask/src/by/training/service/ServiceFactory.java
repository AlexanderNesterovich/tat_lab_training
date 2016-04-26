package by.training.service;

/**
 * Created by Aliaksandr_Nestsiarovich on 4/25/2016.
 */
public class ServiceFactory {

    private static final ServiceFactory factory = new ServiceFactory();

    private final NoteBookService noteBookService = new NoteBookService();

    private ServiceFactory(){}


    public static ServiceFactory getInstance(){
        return factory;
    }

    public NoteBookService getNoteBookService(){
        return noteBookService;
    }

}
