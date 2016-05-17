package by.training.hotel;

/**
 * Created by Alexander Nesterovich on 18.05.2016.
 */
public class Room {

    private String type;
    private String number;
    private String price;

    public Room(String number, String type, String price) {
        this.type = type;
        this.number = number;
        this.price = price;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
