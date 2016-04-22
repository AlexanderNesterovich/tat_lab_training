package by.training.Controller.Commands;

import by.training.Model.Request;
import by.training.Model.Response;

/**
 * Created by Aliaksandr_Nestsiarovich on 4/22/2016.
 */
public interface Command {

    public Response execute(Request req);

}
