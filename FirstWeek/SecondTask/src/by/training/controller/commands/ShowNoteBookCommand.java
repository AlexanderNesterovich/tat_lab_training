package by.training.controller.commands;

import by.training.controller.NoteBookProvider;
import by.training.model.Note;
import by.training.model.Request;
import by.training.model.Response;
import by.training.service.NoteBookService;
import by.training.view.NoteBookConsoleView;

import java.util.List;

/**
 * Created by Aliaksandr_Nestsiarovich on 4/22/2016.
 */
public class ShowNoteBookCommand implements Command {

    @Override
    public Response execute(Request req) {
        Response response = new Response();
        NoteBookService service = new NoteBookService();
        response.setMessage(NoteBookConsoleView.print(service.getCatalog()));
        return response;
    }
}
