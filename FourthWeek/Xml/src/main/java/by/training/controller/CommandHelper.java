package by.training.controller;

import by.training.controller.command.Command;
import by.training.controller.command.impl.*;
import by.training.controller.exception.UnsupportedCommandException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.invoke.MethodHandles;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Aliaksandr_Nestsiarovich on 4/28/2016.
 */
class CommandHelper {
    private static final Logger LOG = LogManager.getLogger(MethodHandles.lookup().lookupClass());
    private Map<CommandName, Command> commandList = new HashMap<>();

    public CommandHelper() {
        commandList.put(CommandName.ADD_BOOK, new AddBookCommand());
        commandList.put(CommandName.SEARCH_BY_TITLE, new SearchByTitleCommand());
        commandList.put(CommandName.SEARCH_BY_DATE, new SearchByPublicationDateCommand());
        commandList.put(CommandName.SHOW_LIBRARY, new ShowLibraryCommand());
        commandList.put(CommandName.NEW_LIBRARY, new NewLibraryCommand());
        commandList.put(CommandName.WRITE_TO_FILE, new WriteToFileCommand());
        commandList.put(CommandName.READ_FROM_FILE, new ReadFromFileCommand());
        commandList.put(CommandName.ADD_PARAGRAPH, new AddParagraphCommand());
    }

    public Command getCommand(String commandName) throws UnsupportedCommandException {
        LOG.trace(">> getCommand(String commandName)");
        CommandName commandEnum;
        try {
            commandEnum = CommandName.valueOf(commandName);
        } catch (IllegalArgumentException e) {
            throw new UnsupportedCommandException("Malformed command string!", e);
        }
        Command command = commandList.get(commandEnum);
        LOG.trace("<< getCommand(String commandName)");
        return command;
    }
}