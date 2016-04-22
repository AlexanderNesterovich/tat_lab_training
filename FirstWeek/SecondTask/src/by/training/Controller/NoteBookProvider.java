package by.training.controller;

import by.training.model.NoteBook;

/**
 * Created by Aliaksandr_Nestsiarovich on 4/22/2016.
 */
public class NoteBookProvider {

    private static NoteBook instance = null;

    private NoteBookProvider() {}

    public static NoteBook getInstance() {
        if (instance == null) {
            instance = new NoteBook();
        }
        return instance;
    }

}