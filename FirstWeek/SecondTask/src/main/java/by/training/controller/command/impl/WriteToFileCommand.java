package by.training.controller.command.impl;

import by.training.controller.command.Command;
import by.training.model.Request;
import by.training.model.Response;
import by.training.service.ServiceFactory;
import by.training.service.exception.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.invoke.MethodHandles;

/**
 * Created by Aliaksandr_Nestsiarovich on 4/22/2016.
 */
public class WriteToFileCommand implements Command {

    private static final Logger LOG = LogManager.getLogger(MethodHandles.lookup().lookupClass());

    @Override
    public Response execute(Request req) {
        LOG.trace(">> execute(Request req)");
        Response response = new Response();

        if (req.getArguments().isEmpty()) {
            LOG.warn("Not enough arguments for this command");
            response.setErrorMessage("Not enough arguments!");
            return response;
        }

        try {
            ServiceFactory.getInstance().getNoteBookService().writeToFile(req.getArguments());
            response.setMessage("File was successfully written!");
            LOG.trace("<< execute(Request req)");
            return response;
        } catch (ServiceException e) {
            LOG.error("Cannot write to file", e);
            response.setErrorMessage(e.getMessage());
            return response;
        }
    }
}
