package by.training.controller.commands;

import by.training.model.Note;
import by.training.model.Request;
import by.training.model.Response;
import by.training.service.NoteBookService;
import by.training.service.ServiceFactory;
import by.training.view.NoteBookConsoleView;

import java.util.List;

/**
 * Created by Aliaksandr_Nestsiarovich on 4/22/2016.
 */
public class SearchByContentCommand implements Command {

    @Override
    public Response execute(Request req) {
        Response response = new Response();
        List<Note> list = ServiceFactory.getInstance().getNoteBookService().searchByContent(req.getArguments()[1]);
        if (list.size() > 0) {
            StringBuffer tmp = new StringBuffer();
            response.setMessage(NoteBookConsoleView.print(list));
            return response;
        }else{
            response.setMessage("Not found!");
            return response;
        }
    }
}
