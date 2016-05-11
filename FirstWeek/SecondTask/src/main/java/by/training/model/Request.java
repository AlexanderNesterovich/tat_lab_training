package by.training.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Aliaksandr_Nestsiarovich on 4/22/2016.
 */
public class Request {

    private String originalLine;
    private String commandName;
    private Map<String, String> args = new HashMap<>();

    public Request(String originalLine) {
        this.originalLine = originalLine;
    }

    public String getCommandName() {
        return commandName;
    }

    public void setCommandName(String command) {
        this.commandName = command;
    }

    public void addArgument(String key, String value) {
        args.put(key, value);
    }

    public Map getArguments() {
        return args;
    }

    @Override
    public String toString() {
        return "Request{" +
                "originalLine='" + originalLine + '\'' +
                ", commandName='" + commandName + '\'' +
                ", args=" + args +
                '}';
    }

}
