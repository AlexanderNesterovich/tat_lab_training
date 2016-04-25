package by.training.controller.commands;

import by.training.controller.NoteBookProvider;
import by.training.model.NoteBook;
import by.training.model.Request;
import by.training.model.Response;
import by.training.service.ServiceFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * Created by Aliaksandr_Nestsiarovich on 4/22/2016.
 */
public class ReadFromFileCommand implements Command {

    @Override
    public Response execute(Request req) {
        Response response = new Response();
        try {
            ServiceFactory.getNoteBookService().readFromFile(req.getContent());
            response.setMessage("File was succesfully read!");
            return response;
        } catch (IOException e) {
            response.setErrorMessage("Cannot read file!");
            return response;
        } catch (ClassNotFoundException e) {
            response.setErrorMessage("Cannot find class!");
            return response;
        }

    }
}
