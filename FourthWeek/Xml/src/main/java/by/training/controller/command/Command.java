package by.training.controller.command;

import by.training.bean.Request;
import by.training.bean.Response;

/**
 * Created by Aliaksandr_Nestsiarovich on 4/22/2016.
 */
public interface Command {

    Response execute(Request req);

}
