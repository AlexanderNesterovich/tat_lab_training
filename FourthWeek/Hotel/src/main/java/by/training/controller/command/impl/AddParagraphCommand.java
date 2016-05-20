package by.training.controller.command.impl;

import by.training.controller.command.Command;
import by.training.model.Request;
import by.training.model.Response;
import by.training.service.LibraryService;
import by.training.service.ServiceFactory;
import by.training.service.exception.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.invoke.MethodHandles;

/**
 * Created by Aliaksandr_Nestsiarovich on 4/22/2016.
 */
public class AddParagraphCommand implements Command {
    private static final Logger LOG = LogManager.getLogger(MethodHandles.lookup().lookupClass());

    @Override
    public Response execute(Request req) {
        LOG.trace(">> execute(Request req)");
        Response response = new Response();
        LibraryService service = ServiceFactory.getInstance().getLibraryService();

        if (req.getArguments().isEmpty()) {
            LOG.warn("Not enough arguments for this command");
            response.setErrorMessage("Not enough arguments!");
            return response;
        }

        try {
            service.addParagraph(req.getArguments());
        } catch (ServiceException e) {
            LOG.error(e.getMessage(), e);
            response.setErrorMessage(e.getMessage());
            return response;
        }

        response.setMessage("Paragraph added successfully!");
        LOG.trace("<< execute(Request req)");
        return response;
    }
}
