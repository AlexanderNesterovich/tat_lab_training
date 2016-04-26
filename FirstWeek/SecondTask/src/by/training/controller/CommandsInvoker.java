package by.training.controller;

import by.training.controller.commands.*;
import by.training.model.Request;
import by.training.model.Response;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Aliaksandr_Nestsiarovich on 4/22/2016.
 */
public class CommandsInvoker {
    private Map<String, Command> commandMap = new HashMap<>();

    public CommandsInvoker() {
        commandMap.put("ADD_NOTE", new AddNoteCommand());
        commandMap.put("READ_FROM_FILE", new ReadFromFileCommand());
        commandMap.put("SEARCH_BY_CONTENT", new SearchByContentCommand());
        commandMap.put("SEARCH_BY_DATE", new SearchByDateCommand());
        commandMap.put("SHOW_NOTEBOOK", new ShowNoteBookCommand());
        commandMap.put("NEW_NOTEBOOK", new NewNoteBookCommand());
        commandMap.put("WRITE_TO_FILE", new WriteToFileCommand());
    }

    public Response execute(Request request) {
        Response response = new Response();
        if (commandMap.containsKey(request.getCommandName())) {
            Command command = commandMap.get(request.getCommandName());
            response = command.execute(request);
            return response;
        }
        response.setErrorMessage("Unsupported Command: " + request.getCommandName());
        return response;
    }
}
