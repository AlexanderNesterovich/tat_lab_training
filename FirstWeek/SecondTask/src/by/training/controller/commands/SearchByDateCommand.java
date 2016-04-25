package by.training.controller.commands;

import by.training.model.Note;
import by.training.model.Request;
import by.training.model.Response;
import by.training.service.NoteBookService;
import by.training.view.NoteBookConsoleView;

import java.text.ParseException;
import java.util.List;

/**
 * Created by Aliaksandr_Nestsiarovich on 4/22/2016.
 */
public class SearchByDateCommand implements Command {

    @Override
    public Response execute(Request req) {
        Response response = new Response();
        NoteBookService service = new NoteBookService();
        List<Note> list;

        try {
            list = service.searchByDate(req.getContent());
        } catch (ParseException e) {
            response.setMessage("Incorrect Date Input!");
            return response;
        }

        if (list.size() > 0) {
            response.setMessage(NoteBookConsoleView.print(list));
            return response;
        }else{
            response.setErrorMessage("Not found!");
            return response;
        }
    }
}
