package by.training.controller.command;

import by.training.model.Request;
import by.training.model.Response;

/**
 * Created by Aliaksandr_Nestsiarovich on 4/22/2016.
 */
public interface Command {

    Response execute(Request req);

}
