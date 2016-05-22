package by.training.bean;

/**
 * Created by Alexander Nesterovich on 21.05.2016.
 */
public class RoomType {

    private String name;
    private String view;
    private int size;
    private RoomServicePack roomServicePack;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getView() {
        return view;
    }

    public void setView(String view) {
        this.view = view;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public RoomServicePack getRoomServicePack() {
        return roomServicePack;
    }

    public void setRoomServicePack(RoomServicePack roomServicePack) {
        this.roomServicePack = roomServicePack;
    }

}
