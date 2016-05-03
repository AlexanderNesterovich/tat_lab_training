package by.training.controller;

import by.training.controller.command.Command;
import by.training.controller.exception.UnsupportedCommandException;
import by.training.model.Request;
import by.training.model.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by Aliaksandr_Nestsiarovich on 4/22/2016.
 */
public class CommandInvoker {

    public static final Logger logger = LogManager.getLogger(CommandInvoker.class.getName());
    private CommandHelper helper = new CommandHelper();

    public CommandInvoker() {
    }

    public Response execute(Request request) {
        String commandName = request.getCommandName();
        Command command;
        Response response;
        try {
            command = helper.getCommand(commandName);
        } catch (UnsupportedCommandException e) {
            response = new Response();
            response.setErrorMessage("Unsupported Command!");
            logger.error("Unsupported command");
            return response;
        }
        response = command.execute(request);
        return response;
    }
}
