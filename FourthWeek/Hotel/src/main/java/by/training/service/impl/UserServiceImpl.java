package by.training.service.impl;

import by.training.bean.Booking;
import by.training.bean.CreditCard;
import by.training.bean.Room;
import by.training.bean.User;
import by.training.dao.DAOFactory;
import by.training.dao.UserDao;
import by.training.dao.exception.DAOException;
import by.training.service.UserService;
import by.training.service.exception.ServiceException;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Date;
import java.util.List;

/**
 * Created by Aliaksandr_Nestsiarovich on 4/22/2016.
 */
public class UserServiceImpl implements UserService {

    UserDao userDao = DAOFactory.getInstance().getUserDao();

    @Override
    public User loginUser(User user) throws ServiceException {
        User dbUser = null;
        try {
            dbUser = userDao.getUser(user);
        } catch (DAOException e) {
            throw new ServiceException("Incorrect username", e);
        }
        if (user.getToken() != null && user.getToken().equals(dbUser.getToken())) {
            return dbUser;
        }
        String[] salt = dbUser.getPassword().split("\\.", 2);
        System.out.println("salt 0:" + salt[0]);
        System.out.println("salt 1:" + salt[1]);
        String inputPassword = getSecurePassword(user.getPassword(), salt[1]);
        String dbPassword = salt[0];
        System.out.println(inputPassword);
        System.out.println(dbPassword);

        if (inputPassword.equals(dbPassword)) {
            return dbUser;
        }else{
            throw new ServiceException("Incorrect password");
        }
    }

    @Override
    public void updateUser(User user) throws ServiceException {
        try {
            userDao.updateUser(user);
        } catch (DAOException e) {
            throw new ServiceException("cannot update", e);
        }
    }

    @Override
    public void registerUser(User user) throws ServiceException {
        try {
            InternetAddress emailAddr = new InternetAddress(user.getLogin());
            emailAddr.validate();
        } catch (AddressException e) {
            throw new ServiceException("Invalid email!", e);
        }
        String salt = getSalt();
        String securePassword = getSecurePassword(user.getPassword(), salt);
        user.setPassword(securePassword + "." + salt.toString());
        user.setToken(generateToken());
        try {
            userDao.storeUser(user);
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Room> getFreeRooms(Booking booking) throws ServiceException {
        try {
            return userDao.getFreeRooms(booking.getDateIn(), booking.getDateOut());
        } catch (DAOException e) {
            throw new ServiceException("Something happened", e);
        }
    }

    @Override
    public void bookRoom(User user, Booking booking) throws ServiceException {

    }

    @Override
    public User getUserInfo(User user) throws ServiceException {
        return null;
    }

    @Override
    public void addCreditCard(User user, CreditCard card) throws ServiceException {
        try {
            userDao.addCreditCard(user, card);
        } catch (DAOException e) {
            throw new ServiceException("Something happened", e);
        }
    }

    //security
    private String generateToken() {
        return getSalt();
    }

    private String getSalt() {
        String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        int len = 30;
        SecureRandom rnd = new SecureRandom();
        StringBuilder sb = new StringBuilder(len);
        for( int i = 0; i < len; i++ )
            sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
        return sb.toString();
    }

    private String getSecurePassword(String passwordToHash, String salt)
    {
        String generatedPassword = null;
        try {
            // Create MessageDigest instance for MD5
            MessageDigest md = MessageDigest.getInstance("MD5");
            //Add password bytes to digest
            md.update(salt.getBytes());
            //Get the hash's bytes
            byte[] bytes = md.digest(passwordToHash.getBytes());

            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++)
            {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = sb.toString();
        }
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return generatedPassword;
    }
}
