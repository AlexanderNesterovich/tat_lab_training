package by.training.service;

import by.training.service.impl.UserServiceImpl;

/**
 * Created by Aliaksandr_Nestsiarovich on 4/25/2016.
 */
public class ServiceFactory {

    private static final ServiceFactory factory = new ServiceFactory();

    private final UserService userService = new UserServiceImpl();

    private ServiceFactory() {
    }


    public static ServiceFactory getInstance() {
        return factory;
    }

    public UserService getUserService() {
        return userService;
    }

}
