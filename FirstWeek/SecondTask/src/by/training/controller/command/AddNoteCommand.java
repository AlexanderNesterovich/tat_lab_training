package by.training.controller.command;

import by.training.model.Request;
import by.training.model.Response;
import by.training.service.ServiceFactory;
import by.training.service.impl.NoteBookService;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Aliaksandr_Nestsiarovich on 4/22/2016.
 */
public class AddNoteCommand implements Command {

    @Override
    public Response execute(Request req) {
        Response response = new Response();

        if(req.getArguments().length == 0) {
            response.setErrorMessage("Not enough arguments!");
            return response;
        }

        Date date = new Date();
        if(req.getArguments().length == 2) {
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            try {
                date = format.parse(req.getArguments()[1]);
            } catch (ParseException e) {
                response.setErrorMessage("Malformed Date!");
            }
        }

        NoteBookService service = ServiceFactory.getInstance().getNoteBookService();
        service.addNote(req.getArguments()[0], date);
        response.setMessage("Note added successfully!");
        return response;
    }
}
