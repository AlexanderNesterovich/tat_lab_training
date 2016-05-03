package by.training.controller.command.impl;

import by.training.controller.command.Command;
import by.training.model.Request;
import by.training.model.Response;
import by.training.service.NoteBookService;
import by.training.service.ServiceFactory;
import by.training.service.exception.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by Aliaksandr_Nestsiarovich on 4/22/2016.
 */
public class AddNoteCommand implements Command {
    private static final Logger logger = LogManager.getLogger(AddNoteCommand.class.getName());
    @Override
    public Response execute(Request req) {
        Response response = new Response();
        NoteBookService service = ServiceFactory.getInstance().getNoteBookService();

        if (req.getArguments().length == 0) {
            logger.error("Not enough arguments for this command");
            response.setErrorMessage("Not enough arguments!");
            return response;
        }

        if (req.getArguments().length == 1) {
            service.addNote(req.getArguments()[0]);
        }

        if (req.getArguments().length >= 2) {
            try {
                service.addNote(req.getArguments()[0], req.getArguments()[1]);
            } catch (ServiceException e) {
                logger.error("Malformed date", e);
                response.setErrorMessage("Malformed date!");
                return response;
            }
        }

        response.setMessage("Note added successfully!");
        return response;
    }
}
