package by.training.model;

/**
 * Created by Aliaksandr_Nestsiarovich on 4/22/2016.
 */
public class Request {

    private String originalLine;
    private String[] args;

    public Request(String originalLine, String... args) {
        this.originalLine = originalLine;
        this.args = args;
    }

    public String getCommandName() {
        return args[0];
    }

    public String[] getArguments() {
        return args;
    }

}
