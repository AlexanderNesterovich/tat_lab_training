package by.training.controller.commands;

import by.training.model.Request;
import by.training.model.Response;
import by.training.service.NoteBookService;
import by.training.service.ServiceFactory;

import java.util.Date;

/**
 * Created by Aliaksandr_Nestsiarovich on 4/22/2016.
 */
public class AddNoteCommand implements Command {

    @Override
    public Response execute(Request req) {
        Response response = new Response();
        NoteBookService service = ServiceFactory.getInstance().getNoteBookService();
        service.addNote(req.getArguments()[1], new Date());
        response.setMessage("Note added successfully!");
        return response;
    }
}
