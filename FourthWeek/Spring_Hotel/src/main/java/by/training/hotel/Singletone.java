package by.training.hotel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alexander Nesterovich on 18.05.2016.
 */
public class Singletone {

    private static List<Customer> list = new ArrayList<Customer>();
    private static List<Room> rooms = new ArrayList<Room>();

    public static void registerUser(Customer cust) {
        cust.setType("User");
        list.add(cust);
    }

    public static boolean loginUser(Customer cust) {
        for(Customer c: list) {
            if(cust.getEmail().equals(c.getEmail()) && cust.getPassword().equals(c.getPassword())) {
                return true;
            }
        }
        return false;
    }

    public static List<Room> getFreeRooms() {
        rooms.add(new Room("102","two beds", "100 per night"));
        rooms.add(new Room("103","two beds", "120 per night"));
        rooms.add(new Room("104","two beds", "130 per night"));
        rooms.add(new Room("105","two beds", "90 per night"));
        rooms.add(new Room("106","two beds", "30 per night"));
        rooms.add(new Room("107","two beds", "50 per night"));
        rooms.add(new Room("108","two beds", "20 per night"));
        rooms.add(new Room("109","two beds", "10 per night"));
        return rooms;
    }
}
