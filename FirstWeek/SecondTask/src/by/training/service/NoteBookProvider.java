package by.training.service;

import by.training.model.NoteBook;

/**
 * Created by Aliaksandr_Nestsiarovich on 4/22/2016.
 */
class NoteBookProvider {

    private static NoteBook instance = null;

    private NoteBookProvider() {}

    public static NoteBook getInstance() {
        if (instance == null) {
            instance = new NoteBook();
        }
        return instance;
    }

    public static NoteBook getNew() {
        instance = new NoteBook();
        return instance;
    }

    public static void setNew(NoteBook nb) {
        instance = nb;
    }

}
