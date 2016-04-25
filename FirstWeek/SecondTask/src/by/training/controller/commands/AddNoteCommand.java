package by.training.controller.commands;

import by.training.controller.NoteBookProvider;
import by.training.model.Note;
import by.training.model.Request;
import by.training.model.Response;

/**
 * Created by Aliaksandr_Nestsiarovich on 4/22/2016.
 */
public class AddNoteCommand implements Command {

    @Override
    public Response execute(Request req) {
        NoteBookProvider.getInstance().addNote(new Note(req.getContent()));
        Response response = new Response();
        response.setMessage("Note added successfully");
        return response;
    }
}
