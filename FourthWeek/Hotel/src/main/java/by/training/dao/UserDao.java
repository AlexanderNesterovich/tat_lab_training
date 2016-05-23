package by.training.dao;

import by.training.bean.Booking;
import by.training.bean.CreditCard;
import by.training.bean.Room;
import by.training.bean.User;
import by.training.dao.exception.DAOException;

import java.util.Date;
import java.util.List;

/**
 * Created by Aliaksandr_Nestsiarovich on 4/26/2016.
 */
public interface UserDao {

    void insertUser(User user) throws DAOException;
    void updateUser(User user) throws DAOException;
    User readUser(User user) throws DAOException;
    List<Room> readFreeRooms(Date dateIn, Date dateOut) throws DAOException;
    void insertBooking(Booking booking) throws DAOException;
    void insertCreditCard(CreditCard creditCard) throws DAOException;

}
