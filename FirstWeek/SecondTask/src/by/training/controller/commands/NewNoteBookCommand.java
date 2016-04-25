package by.training.controller.commands;

import by.training.controller.NoteBookProvider;
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
        ServiceFactory.getNoteBookService().newNoteBook();
        response.setMessage("Notebook created successfully!");
        return response;
    }
}
