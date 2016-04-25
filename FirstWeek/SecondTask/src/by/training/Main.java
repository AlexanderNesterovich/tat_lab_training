package by.training;

import by.training.controller.CommandsInvoker;
import by.training.model.Request;
import by.training.model.Response;

public class Main {

    public static void main(String[] args) {
        Request request = new Request();
        request.setCommandName("ADD_NOTE");
        request.setContent("blabla");

        Request request2 = new Request();
        request2.setCommandName("SEARCH_BY_CONTENT");
        request2.setContent("blabla");

        CommandsInvoker invoker = new CommandsInvoker();
        Response response = invoker.execute(request);
        Response response2 = invoker.execute(request2);

        if (response.getErrorMessage() == null) {
            System.out.println(response.getMessage());
        }else{
            System.out.println(response.getErrorMessage());
        }

        if (response2.getErrorMessage() == null) {
            System.out.println(response2.getMessage());
        } else {
            System.out.println(response2.getErrorMessage());
        }
    }
}
