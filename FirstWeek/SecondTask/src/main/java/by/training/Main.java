package by.training;

import by.training.controller.CommandsInvoker;
import by.training.model.Request;
import by.training.model.Response;
import by.training.view.parser.Parser;
import by.training.view.parser.impl.TxtParser;

public class Main {

    public static void main(String[] args) {
        Parser parser = new TxtParser();
        parser.parseByPath("C:/tmp/script.txt");

        CommandsInvoker invoker = new CommandsInvoker();
        Response response;
        for (Request req : parser.getRequestList()) {
            response = invoker.execute(req);
            if (response.getMessage() == null) {
                System.out.println(response.getErrorMessage());
            } else {
                System.out.println(response.getMessage() + " " + response.getErrorMessage());
            }
        }

    }
}
