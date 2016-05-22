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
        commandList.put(CommandName.REGISTER_USER, new RegisterUserCommand());
        commandList.put(CommandName.UPDATE_USER, new UpdateUserCommand());
        commandList.put(CommandName.LOGIN_USER, new LoginUserCommand());
        commandList.put(CommandName.GET_FREE_ROOMS, new GetFreeRoomsCommand());
        commandList.put(CommandName.BOOK_ROOM, new BookRoomCommand());
        commandList.put(CommandName.ADD_CREDIT_CARD, new AddCreditCardCommand());
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