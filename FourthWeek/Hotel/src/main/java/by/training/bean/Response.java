package by.training.bean;

import java.util.Objects;

/**
 * Created by Aliaksandr_Nestsiarovich on 4/22/2016.
 */
public class Response {

    private String errorMessage = "";
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Response response = (Response) o;
        return Objects.equals(errorMessage, response.errorMessage) &&
                Objects.equals(message, response.message);
    }

    @Override
    public String toString() {
        return "Response{" +
                "errorMessage='" + errorMessage + '\'' +
                ", message='" + message + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(errorMessage, message);
    }
}
