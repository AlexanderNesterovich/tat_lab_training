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
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Aliaksandr_Nestsiarovich on 4/22/2016.
 */
public class UserServiceImpl implements UserService {

    private static final Logger LOG = LogManager.getLogger(UserServiceImpl.class);

    UserDao userDao = DAOFactory.getInstance().getUserDao();

    public User loginUser(User user) throws ServiceException {
        LOG.trace(">> loginUser(User user)");
        User dbUser = null;

        if(user.getLogin() == null) {
            LOG.warn("Null email");
            throw new ServiceException("Invalid email!");
        }

        try {
            InternetAddress emailAddr = new InternetAddress(user.getLogin());
            emailAddr.validate();
        } catch (AddressException e) {
            LOG.warn("Invalid email");
            throw new ServiceException("Invalid email!", e);
        }

        try {
            dbUser = userDao.readUser(user);
        } catch (DAOException e) {
            LOG.warn("Sql exception");
            throw new ServiceException(e.getMessage(), e);
        }

        if (user.getToken() != null && user.getToken().equals(dbUser.getToken())) {
            LOG.trace("<< loginUser(User user) token");
            return dbUser;
        }

        String[] salt = dbUser.getPassword().split("\\.", 2);
        String inputPassword = getSecurePassword(user.getPassword(), salt[1]);
        String dbPassword = salt[0];

        if (inputPassword.equals(dbPassword)) {
            LOG.trace("<< loginUser(User user) password");
            return dbUser;
        }else{
            LOG.warn("Sql exception");
            throw new ServiceException("Incorrect password");
        }
    }

    public void editUserInfo(User user) throws ServiceException {
        LOG.trace(">> editUserInfo(User user)");
        try {
            userDao.updateUser(user);
        } catch (DAOException e) {
            LOG.warn("Sql exception");
            throw new ServiceException(e.getMessage(), e);
        }
        LOG.trace("<< editUserInfo(User user)");
    }

    public void registerUser(User user) throws ServiceException {
        Pattern pattern = Pattern.compile("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{6,20})");
        if(user.getLogin() == null || user.getPassword() == null) {
            throw new ServiceException("Field not filled!");
        }

        try {
            InternetAddress emailAddr = new InternetAddress(user.getLogin());
            emailAddr.validate();
        } catch (AddressException e) {
            throw new ServiceException("Invalid email!", e);
        }

        Matcher matcher = pattern.matcher(user.getPassword());
        if (!matcher.matches()) {
            throw new ServiceException("Invalid password!");
        }

        String salt = getSalt();
        String securePassword = getSecurePassword(user.getPassword(), salt);
        user.setPassword(securePassword + "." + salt.toString());
        user.setToken(generateToken());
        try {
            userDao.insertUser(user);
        } catch (DAOException e) {
            LOG.warn("Sql exception");
            e.printStackTrace();
        }
    }

    public List<Room> getAvailableRooms(Booking booking) throws ServiceException {

        if(booking.getDateIn() == null || booking.getDateOut() == null) {
            throw new ServiceException("Fields not filled");
        }

        if(booking.getDateIn().after(booking.getDateOut()) || booking.getDateIn().before(new Date())) {
            throw new ServiceException("Incorrect dates");
        }

        try {
            return userDao.readFreeRooms(booking.getDateIn(), booking.getDateOut());
        } catch (DAOException e) {
            LOG.warn("Sql exception");
            throw new ServiceException(e.getMessage(), e);
        }
    }

    public void addBooking(Booking booking) throws ServiceException {

        if(booking.getDateIn() == null || booking.getDateOut() == null || booking.getUser() == null) {
            throw new ServiceException("Fields not filled");
        }

        if(booking.getDateIn().after(booking.getDateOut()) || booking.getDateIn().before(new Date())) {
            throw new ServiceException("Incorrect dates");
        }

        if(booking.getRoom().getId() == 0 || booking.getUser().getId() == 0) {
            throw new ServiceException("Cant find user info");
        }

        try {
            userDao.insertBooking(booking);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    public void addCreditCard(CreditCard card) throws ServiceException {

        if(card.getExpire() == null || card.getNumber() == 0) {
            throw new ServiceException("Fields not filled");
        }

        if(!creditCardValidation(Long.toString(card.getNumber())) || card.getExpire().before(new Date())) {
            throw new ServiceException("Invalid credit card!");
        }
        try {
            userDao.insertCreditCard(card);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    private boolean creditCardValidation(String ccNumber)
    {
        int sum = 0;
        boolean alternate = false;
        for (int i = ccNumber.length() - 1; i >= 0; i--)
        {
            int n = Integer.parseInt(ccNumber.substring(i, i + 1));
            if (alternate)
            {
                n *= 2;
                if (n > 9)
                {
                    n = (n % 10) + 1;
                }
            }
            sum += n;
            alternate = !alternate;
        }
        return (sum % 10 == 0);
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
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(salt.getBytes());
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
