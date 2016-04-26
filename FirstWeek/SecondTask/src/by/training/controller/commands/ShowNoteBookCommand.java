package by.training.controller.commands;

import by.training.model.Request;
import by.training.model.Response;
import by.training.service.NoteBookService;
import by.training.service.ServiceFactory;
import by.training.view.NoteBookConsoleView;

/**
 * Created by Aliaksandr_Nestsiarovich on 4/22/2016.
 */
public class ShowNoteBookCommand implements Command {

    @Override
    public Response execute(Request req) {
        Response response = new Response();
        response.setMessage(NoteBookConsoleView.print(ServiceFactory.getInstance().getNoteBookService().getCatalog()));
        return response;
    }
}
