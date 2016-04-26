package by.training.controller.commands;

import by.training.model.Request;
import by.training.model.Response;
import by.training.service.ServiceFactory;

import java.io.IOException;

/**
 * Created by Aliaksandr_Nestsiarovich on 4/22/2016.
 */
public class ReadFromFileCommand implements Command {

    @Override
    public Response execute(Request req) {
        Response response = new Response();
        try {
            ServiceFactory.getInstance().getNoteBookService().readFromFile(req.getArguments()[1]);
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
