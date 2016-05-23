package by.training.controller.command.impl;

import by.training.bean.*;
import by.training.controller.command.Command;
import by.training.service.ServiceFactory;
import by.training.service.UserService;
import by.training.service.exception.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by Aliaksandr_Nestsiarovich on 4/22/2016.
 */
public class BookRoomCommand implements Command {
    private static final Logger LOG = LogManager.getLogger(BookRoomCommand.class);

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
            User user = new User();
            user.setLogin("myemail@gmail.com");
            Booking booking = new Booking();
            booking.setUser(user);
            service.addBooking(booking);
        } catch (ServiceException e) {
            LOG.error(e.getMessage(), e);
            response.setErrorMessage(e.getMessage());
            return response;
        }

        response.setMessage("Room booked successfully!");
        LOG.trace("<< execute(Request req)");
        return response;
    }
}
