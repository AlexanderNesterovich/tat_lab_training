package by.training.service;

/**
 * Created by Aliaksandr_Nestsiarovich on 4/25/2016.
 */
public class ServiceFactory {

    private static NoteBookService noteBookService = new NoteBookService();

    private ServiceFactory(){}

    public static NoteBookService getNoteBookService(){
        return noteBookService;
    }

}
