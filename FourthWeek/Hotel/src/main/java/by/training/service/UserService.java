package by.training.service;

import by.training.bean.Booking;
import by.training.bean.CreditCard;
import by.training.bean.Room;
import by.training.bean.User;
import by.training.service.exception.ServiceException;

import java.util.Date;
import java.util.List;

/**
 * Created by Aliaksandr_Nestsiarovich on 4/28/2016.
 */
public interface UserService {

    User loginUser(User user) throws ServiceException;
    void editUserInfo(User user) throws ServiceException;
    void registerUser(User user) throws ServiceException;
    List<Room> getAvailableRooms(Booking booking) throws ServiceException;
    void addBooking(Booking booking) throws ServiceException;
    void addCreditCard(CreditCard card) throws ServiceException;

}
