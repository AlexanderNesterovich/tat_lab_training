package by.training.controller.commands;

import by.training.controller.NoteBookProvider;
import by.training.model.NoteBook;
import by.training.model.Request;
import by.training.model.Response;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * Created by Aliaksandr_Nestsiarovich on 4/22/2016.
 */
public class ReadFromFileCommand implements Command {

    @Override
    public Response execute(Request req) {

        NoteBook noteBook;
        Response response = new Response();
        try {
            FileInputStream fileIn = new FileInputStream(req.getContent());
            ObjectInputStream in = new ObjectInputStream(fileIn);
            noteBook = (NoteBook) in.readObject();
            in.close();
            fileIn.close();
            NoteBookProvider.setNew(noteBook);
            response.setMessage("Serialized data is read from: " + req.getContent());
            return response;
        } catch (IOException i) {
            response.setErrorMessage("Cannot read from file: " + req.getContent());
            return response;
        } catch (ClassNotFoundException e) {
            response.setErrorMessage("Class not found");
            return response;
        }
    }
}
