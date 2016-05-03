package by.training.controller.command.impl;

import by.training.controller.command.Command;
import by.training.model.Request;
import by.training.model.Response;
import by.training.service.ServiceFactory;
import by.training.service.exception.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by Aliaksandr_Nestsiarovich on 4/22/2016.
 */
public class WriteToFileCommand implements Command {

    public static final Logger logger = LogManager.getLogger(WriteToFileCommand.class.getName());

    @Override
    public Response execute(Request req) {
        Response response = new Response();

        if (req.getArguments().length == 0) {
            response.setErrorMessage("Not enough arguments!");
            return response;
        }

        try {
            ServiceFactory.getInstance().getNoteBookService().writeToFile(req.getArguments()[0]);
            response.setMessage("File was successfully written!");
            return response;
        } catch (ServiceException e) {
            logger.error("Catching ServiceException", e);
            response.setErrorMessage("File not found!");
            return response;
        }
    }
}
