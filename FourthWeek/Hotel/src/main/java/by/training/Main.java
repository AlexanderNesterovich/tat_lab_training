package by.training;

import by.training.bean.Request;
import by.training.bean.Response;
import by.training.controller.CommandInvoker;
import by.training.view.parser.Parser;
import by.training.view.parser.impl.TxtParser;

public class Main {

    public static void main(String[] args) {
        Parser parser = new TxtParser();
        parser.parseByPath("C:/tmp/testingDB.txt");

        CommandInvoker invoker = new CommandInvoker();
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
