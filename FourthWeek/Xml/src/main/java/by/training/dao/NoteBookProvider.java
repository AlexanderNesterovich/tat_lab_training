package by.training.dao;

import by.training.bean.Library;

import java.util.Date;

/**
 * Created by Aliaksandr_Nestsiarovich on 4/22/2016.
 */
public class NoteBookProvider {

    private static Library instance = null;

    private NoteBookProvider() {
    }

    public static Library getInstance() {
        if (instance == null) {
            instance = new Library();
        }
        return instance;
    }

    public static Library getNew(String name, Date date) {
        instance = new Library(name, date);
        return instance;
    }

    public static void setNew(Library nb) {
        instance = nb;
    }

}
