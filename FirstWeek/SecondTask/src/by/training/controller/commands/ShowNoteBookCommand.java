package by.training.controller.commands;

import by.training.controller.NoteBookProvider;
import by.training.model.Note;
import by.training.model.Request;
import by.training.model.Response;

import java.util.List;

/**
 * Created by Aliaksandr_Nestsiarovich on 4/22/2016.
 */
public class ShowNoteBookCommand implements Command {

    @Override
    public Response execute(Request req) {
        Response response = new Response();
        List<Note> list = NoteBookProvider.getInstance().getNotes();
        StringBuffer tmp = new StringBuffer();
        for (Note n : list) {
            tmp.append("content: " + n.getNote() + "\n");
            tmp.append("date: " + n.getDate() + "\n");
        }
        response.setMessage(tmp.toString());
        return response;
    }
}
