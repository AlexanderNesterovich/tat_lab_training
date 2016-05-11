package by.training.controller.command.impl;

import by.training.controller.command.Command;
import by.training.model.Book;
import by.training.model.Request;
import by.training.model.Response;
import by.training.service.ServiceFactory;
import by.training.service.exception.ServiceException;
import by.training.view.NoteBookConsoleView;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.invoke.MethodHandles;
import java.util.List;

/**
 * Created by Aliaksandr_Nestsiarovich on 4/22/2016.
 */
public class SearchByDateCommand implements Command {
    private static final Logger LOG = LogManager.getLogger(MethodHandles.lookup().lookupClass());

    @Override
    public Response execute(Request req) {
        if (LOG.isTraceEnabled()) {
            LOG.trace(">> execute(Request req)");
        }
        Response response = new Response();
        if (req.getArguments().isEmpty()) {
            response.setErrorMessage("Not enough arguments!");
            LOG.error("Not enough arguments for this command");
            return response;
        }

        List<Book> list;
        try {
            list = ServiceFactory.getInstance().getNoteBookService().searchByDate(req.getArguments());
        } catch (ServiceException e) {
            response.setMessage(e.getMessage());
            LOG.error(e.getMessage(), e);
            return response;
        }

        if (list.size() > 0) {
            response.setMessage(NoteBookConsoleView.print(list));
            if (LOG.isTraceEnabled()) {
                LOG.trace("<< execute(Request req)");
            }
            return response;
        } else {
            LOG.warn("0 results");
            response.setErrorMessage("Not found!");
            return response;
        }
    }
}
