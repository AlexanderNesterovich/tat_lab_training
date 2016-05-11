package by.training.controller.command.impl;

import by.training.controller.command.Command;
import by.training.model.Request;
import by.training.model.Response;
import by.training.service.NoteBookService;
import by.training.service.ServiceFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.invoke.MethodHandles;

/**
 * Created by Aliaksandr_Nestsiarovich on 4/22/2016.
 */
public class AddBookCommand implements Command {
    private static final Logger LOG = LogManager.getLogger(MethodHandles.lookup().lookupClass());

    @Override
    public Response execute(Request req) {
        LOG.trace(">> execute(Request req)");
        Response response = new Response();
        NoteBookService service = ServiceFactory.getInstance().getNoteBookService();

        if (req.getArguments().isEmpty()) {
            LOG.warn("Not enough arguments for this command");
            response.setErrorMessage("Not enough arguments!");
            return response;
        }

        if (req.getArguments().size() == 1) {
            service.addBook(req.getArguments());
        }

        if (req.getArguments().size() >= 2) {
            service.addBook(req.getArguments());
        }

        response.setMessage("Book added successfully!");
        LOG.trace("<< execute(Request req)");
        return response;
    }
}
