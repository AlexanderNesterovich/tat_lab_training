package by.training.dao;

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

    void storeUser(User user) throws DAOException;
    void updateUser(User user) throws DAOException;
    User getUser(User user) throws DAOException;
    List<Room> getFreeRooms(Date dateIn, Date dateOut) throws DAOException;
    void bookRoom(User user, Date dateIn, Date dateOut) throws DAOException;
    void addCreditCard(User user, CreditCard creditCard) throws DAOException;

}
