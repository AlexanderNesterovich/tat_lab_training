package by.training.controller.command.impl;

import by.training.bean.*;
import by.training.controller.command.Command;
import by.training.service.ServiceFactory;
import by.training.service.UserService;
import by.training.service.exception.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Date;
import java.util.List;

/**
 * Created by Aliaksandr_Nestsiarovich on 4/22/2016.
 */
public class GetFreeRoomsCommand implements Command {
    private static final Logger LOG = LogManager.getLogger(GetFreeRoomsCommand.class);

    @Override
    public Response execute(Request req) {
        LOG.trace(">> execute(Request req)");
        Response response = new Response();
        UserService service = ServiceFactory.getInstance().getUserService();

        if (req.getArguments().isEmpty()) {
            LOG.warn("Not enough arguments for this command");
            response.setErrorMessage("Not enough arguments!");
            return response;
        }

        try {
            Booking booking = new Booking();
            booking.setDateIn(new Date("2015/12/01"));
            booking.setDateOut(new Date("2015/12/07"));

            List<Room> rooms = service.getAvailableRooms(booking);
        } catch (ServiceException e) {
            LOG.error(e.getMessage(), e);
            response.setErrorMessage(e.getMessage());
            return response;
        }

        response.setMessage("Got free rooms successfully!");
        LOG.trace("<< execute(Request req)");
        return response;
    }
}
