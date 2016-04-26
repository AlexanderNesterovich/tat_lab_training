package by.training.controller.commands;

import by.training.model.Note;
import by.training.model.Request;
import by.training.model.Response;
import by.training.service.NoteBookService;
import by.training.service.ServiceFactory;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
