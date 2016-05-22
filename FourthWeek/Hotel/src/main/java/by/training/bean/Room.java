package by.training.bean;

/**
 * Created by Alexander Nesterovich on 20.05.2016.
 */
public class Room {

    private int id;
    private String roomNumber;
    private int floor;
    private int keyNumber;
    private RoomType type;

    public int getKeyNumber() {
        return keyNumber;
    }

    public void setKeyNumber(int keyNumber) {
        this.keyNumber = keyNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public RoomType getType() {
        return type;
    }

    public void setType(RoomType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", roomNumber='" + roomNumber + '\'' +
                ", floor=" + floor +
                ", keyNumber=" + keyNumber +
                ", type=" + type +
                '}';
    }

}
