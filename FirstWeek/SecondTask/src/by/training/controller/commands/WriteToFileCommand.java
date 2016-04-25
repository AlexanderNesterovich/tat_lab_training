package by.training.controller.commands;

import by.training.controller.NoteBookProvider;
import by.training.model.Request;
import by.training.model.Response;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Created by Aliaksandr_Nestsiarovich on 4/22/2016.
 */
public class WriteToFileCommand implements Command {

    @Override
    public Response execute(Request req) {
        Response response = new Response();
        try
        {
            FileOutputStream fileOut = new FileOutputStream(req.getContent());
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(NoteBookProvider.getInstance());
            out.close();
            fileOut.close();
            response.setMessage("Serialized data is saved in " + req.getContent());
            return response;
        }catch(IOException i)
        {
            response.setErrorMessage("Serialization is failed");
            return response;
        }
    }
}
