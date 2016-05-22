package by.training.controller.command.impl;

import by.training.controller.command.Command;
import by.training.bean.Request;
import by.training.bean.Response;
import by.training.service.ServiceFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.invoke.MethodHandles;

/**
 * Created by Aliaksandr_Nestsiarovich on 4/22/2016.
 */
public class NewLibraryCommand implements Command {
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
        ServiceFactory.getInstance().getLibraryService().newLibrary(req.getArguments());
        response.setMessage("Notebook created successfully!");
        LOG.trace("<< execute(Request req)");
        return response;
    }
}
