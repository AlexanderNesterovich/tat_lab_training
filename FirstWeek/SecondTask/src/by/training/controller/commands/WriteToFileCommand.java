package by.training.controller.commands;

import by.training.controller.NoteBookProvider;
import by.training.model.Request;
import by.training.model.Response;
import by.training.service.ServiceFactory;

import java.io.*;

/**
 * Created by Aliaksandr_Nestsiarovich on 4/22/2016.
 */
public class WriteToFileCommand implements Command {

    @Override
    public Response execute(Request req) {
        Response response = new Response();
        try {
            ServiceFactory.getNoteBookService().writeToFile(req.getContent());
            response.setMessage("File was succesfully written!");
            return response;
        } catch (FileNotFoundException e) {
            response.setErrorMessage("File not found!");
            return response;
        } catch (IOException e) {
            response.setErrorMessage("Cannot write to file!");
            return response;
        }
    }
}
