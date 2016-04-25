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
        request2.setCommandName("WRITE_TO_FILE");
        request2.setContent("C:/tmp/tmp.ser");

        Request request3 = new Request();
        request3.setCommandName("READ_FROM_FILE");
        request3.setContent("C:/tmp/tmp.ser");

        Request request4 = new Request();
        request4.setCommandName("SHOW_NOTEBOOK");

        CommandsInvoker invoker = new CommandsInvoker();
        Response response = invoker.execute(request);
        Response response2 = invoker.execute(request2);
        Response response3 = invoker.execute(request3);
        Response response4 = invoker.execute(request4);

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

        if (response3.getErrorMessage() == null) {
            System.out.println(response3.getMessage());
        } else {
            System.out.println(response3.getErrorMessage());
        }

        if (response4.getErrorMessage() == null) {
            System.out.println(response4.getMessage());
        } else {
            System.out.println(response4.getErrorMessage());
        }
    }
}
