package by.training.Controller;

import by.training.Controller.Commands.*;
import by.training.Model.Request;
import by.training.Model.Response;

import java.util.Map;

/**
 * Created by Aliaksandr_Nestsiarovich on 4/22/2016.
 */
public class CommandsInvoker {

    private Map<String, Command> commandMap;

    public CommandsInvoker() {
        commandMap.put("ADD_NOTE", new AddNoteCommand());
        commandMap.put("READ_FROM_FILE", new ReadFromFileCommand());
        commandMap.put("SEARCH_BY_CONTENT", new SearchByContentCommand());
        commandMap.put("SEARCH_BY_DATE", new SearchByDateCommand());
        commandMap.put("SHOW_NOTEBOOK", new ShowNoteBookCommand());
        commandMap.put("NEW_NOTEBOOK", new NewNoteBookCommand());
    }

    public Response execute(Request request) {
        String commandName = request.getCommandName();
        Command command = commandMap.get(request.getCommandName());
        Response response = command.execute(request);
        return response;
    }
}
