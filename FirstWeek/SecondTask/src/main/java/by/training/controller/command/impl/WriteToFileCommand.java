package by.training.controller.command.impl;

import by.training.controller.command.Command;
import by.training.model.Request;
import by.training.model.Response;
import by.training.service.ServiceFactory;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by Aliaksandr_Nestsiarovich on 4/22/2016.
 */
public class WriteToFileCommand implements Command {

    @Override
    public Response execute(Request req) {
        Response response = new Response();

        if (req.getArguments().length == 0) {
            response.setErrorMessage("Not enough arguments!");
            return response;
        }

        try {
            ServiceFactory.getInstance().getNoteBookService().writeToFile(req.getArguments()[0]);
            response.setMessage("File was successfully written!");
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
