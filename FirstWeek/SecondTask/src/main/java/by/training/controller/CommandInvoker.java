package by.training.controller;

import by.training.controller.command.Command;
import by.training.controller.exception.UnsupportedCommandException;
import by.training.model.Request;
import by.training.model.Response;

/**
 * Created by Aliaksandr_Nestsiarovich on 4/22/2016.
 */
public class CommandInvoker {
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
            return response;
        }
        response = command.execute(request);
        return response;
    }
}