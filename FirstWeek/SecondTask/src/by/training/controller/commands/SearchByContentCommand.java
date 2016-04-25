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
public class SearchByContentCommand implements Command {

    @Override
    public Response execute(Request req) {
        Response response = new Response();
        NoteBookService service = new NoteBookService();
        List<Note> list = service.searchByContent(req.getContent());
        if (list.size() > 0) {
            StringBuffer tmp = new StringBuffer();
            response.setMessage(NoteBookConsoleView.print(list));
            return response;
        }else{
            response.setMessage("not found");
            return response;
        }
    }
}
