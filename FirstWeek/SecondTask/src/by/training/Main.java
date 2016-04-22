package by.training;

import by.training.controller.CommandsInvoker;
import by.training.model.Request;
import by.training.model.Response;

public class Main {

    public static void main(String[] args) {
        Request request = new Request();
        request.setCommandName("ADD_NOTE");
        request.setContent("blablablabla");

        CommandsInvoker invoker = new CommandsInvoker();
        Response response = invoker.execute(request);

        if(response.getErrorMessage() != null){
            System.out.println(response.getMessage());
        }else{
            System.out.println(response.getErrorMessage());
        }
    }
}