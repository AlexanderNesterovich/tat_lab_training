package by.training.controller.command.impl;

import by.training.controller.command.Command;
import by.training.model.Request;
import by.training.model.Response;
import by.training.service.ServiceFactory;

/**
 * Created by Aliaksandr_Nestsiarovich on 4/22/2016.
 */
public class NewNoteBookCommand implements Command {

    @Override
    public Response execute(Request req) {
        Response response = new Response();
        ServiceFactory.getInstance().getNoteBookService().newNoteBook();
        response.setMessage("Notebook created successfully!");
        return response;
    }
}
