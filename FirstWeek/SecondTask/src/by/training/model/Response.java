package by.training.model;

/**
 * Created by Aliaksandr_Nestsiarovich on 4/22/2016.
 */
public class Response {

    private String errorMessage;
    private String message;

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
