package by.training.controller;

import by.training.controller.command.Command;
import by.training.controller.exception.UnsupportedCommandException;
import by.training.model.Request;
import by.training.model.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.invoke.MethodHandles;

/**
 * Created by Aliaksandr_Nestsiarovich on 4/22/2016.
 */
public class CommandInvoker {

    private static final Logger LOG = LogManager.getLogger(MethodHandles.lookup().lookupClass());
    private CommandHelper helper = new CommandHelper();

    public CommandInvoker() {
    }

    public Response execute(Request request) {
        LOG.trace(">> execute(Request request)");
        String commandName = request.getCommandName();
        Command command;
        Response response;
        try {
            command = helper.getCommand(commandName);
        } catch (UnsupportedCommandException e) {
            LOG.error("Unsupported command", e);
            response = new Response();
            response.setErrorMessage(e.getMessage());
            return response;
        }
        response = command.execute(request);
        LOG.trace("<< execute(Request request)");
        return response;
    }
}
