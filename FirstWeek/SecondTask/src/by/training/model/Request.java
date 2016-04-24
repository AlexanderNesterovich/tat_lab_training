package by.training.model;

/**
 * Created by Aliaksandr_Nestsiarovich on 4/22/2016.
 */
public class Request {

    private String content;
    private String commandName;

    public String getCommandName() {
        return commandName;
    }

    public void setCommandName(String commandName) {
        this.commandName = commandName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
