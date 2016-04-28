package by.training.controller.command;

import by.training.model.Note;
import by.training.model.Request;
import by.training.model.Response;
import by.training.service.ServiceFactory;
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

        if(req.getArguments().length == 0) {
            response.setErrorMessage("Not enough arguments!");
            return response;
        }

        List<Note> list;
        try {
            list = ServiceFactory.getInstance().getNoteBookService().searchByDate(req.getArguments()[0]);
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
