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
        commandList.put(CommandName.READ_FROM_FILE, new ReadFromFileCommand());
    }

    public Command getCommand(String commandName) throws UnsupportedCommandException {
        CommandName commandEnum;
        try {
            commandEnum = CommandName.valueOf(commandName);
        } catch (IllegalArgumentException e) {
            throw new UnsupportedCommandException();
        }
        Command command = commandList.get(commandEnum);
        return command;
    }
}