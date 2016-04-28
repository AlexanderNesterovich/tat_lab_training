package by.training.controller;

import by.training.controller.command.Command;
import by.training.controller.command.impl.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Aliaksandr_Nestsiarovich on 4/28/2016.
 */
public class CommandHelper {
    private Map<CommandName, Command> commandList = new HashMap<>();

    public CommandHelper() {
        commandList.put(CommandName.ADD_NOTE, new AddNoteCommand());
        commandList.put(CommandName.SEARCH_BY_CONTENT, new SearchByContentCommand());
        commandList.put(CommandName.SEARCH_BY_DATE, new SearchByDateCommand());
        commandList.put(CommandName.SHOW_NOTEBOOK, new ShowNoteBookCommand());
        commandList.put(CommandName.NEW_NOTEBOOK, new NewNoteBookCommand());
        commandList.put(CommandName.WRITE_TO_FILE, new WriteToFileCommand());
    }

    public Command getCommand(String commandName) {
        CommandName commandEnum = CommandName.valueOf(commandName);
        Command command = commandList.get(commandEnum);
        return command;
    }
}