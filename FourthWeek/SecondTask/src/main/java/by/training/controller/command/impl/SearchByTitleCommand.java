package by.training.controller.command.impl;

import by.training.controller.command.Command;
import by.training.model.Book;
import by.training.model.Request;
import by.training.model.Response;
import by.training.service.ServiceFactory;
import by.training.view.NoteBookConsoleView;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.invoke.MethodHandles;
import java.util.List;

/**
 * Created by Aliaksandr_Nestsiarovich on 4/22/2016.
 */
public class SearchByTitleCommand implements Command {
    private static final Logger LOG = LogManager.getLogger(MethodHandles.lookup().lookupClass());

    @Override
    public Response execute(Request req) {
        LOG.trace(">> execute(Request req)");

        Response response = new Response();
        System.out.println(req);
        if (req.getArguments().isEmpty()) {
            LOG.warn("Not enough arguments for this command");
            response.setErrorMessage("Not enough arguments!");
            return response;
        }

        List<Book> list = ServiceFactory.getInstance().getLibraryService().searchByTitle(req.getArguments());
        if (list.size() > 0) {
            StringBuffer tmp = new StringBuffer();
            response.setMessage(NoteBookConsoleView.print(list));
            LOG.trace("<< execute(Request req)");
            return response;
        } else {
            LOG.warn("0 results");
            response.setMessage("Not found!");
            return response;
        }
    }
}
