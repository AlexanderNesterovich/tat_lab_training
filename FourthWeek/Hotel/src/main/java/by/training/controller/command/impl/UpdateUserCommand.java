package by.training.controller.command.impl;

import by.training.bean.Request;
import by.training.bean.Response;
import by.training.bean.Role;
import by.training.bean.User;
import by.training.controller.command.Command;
import by.training.service.ServiceFactory;
import by.training.service.UserService;
import by.training.service.exception.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by Aliaksandr_Nestsiarovich on 4/22/2016.
 */
public class UpdateUserCommand implements Command {
    private static final Logger LOG = LogManager.getLogger(UpdateUserCommand.class);

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
            user.setRole(Role.USER);
            user.setLogin("myemail@gmail.com");
            user.setPassword("123456789");
            user.setFirstName("Alex");
            user.setLastName("Petttt");
            user.setMidName("Aswerrwe");
            user.setAddress("Rafieva");
            user.setPassport("MC123123123123");
            user.setPhoneNumber("+375293123123");
            service.updateUser(user);
        } catch (ServiceException e) {
            LOG.error(e.getMessage(), e);
            response.setErrorMessage(e.getMessage());
            return response;
        }

        response.setMessage("User update successfully!");
        LOG.trace("<< execute(Request req)");
        return response;
    }
}
