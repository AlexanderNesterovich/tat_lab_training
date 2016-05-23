package by.training.dao.mysql_impl;

import by.training.bean.*;
import by.training.dao.UserDao;
import by.training.dao.connection_pool.ConnectionPool;
import by.training.dao.connection_pool.ConnectionPoolException;
import by.training.dao.connection_pool.ConnectionPoolFactory;
import by.training.dao.exception.DAOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Aliaksandr_Nestsiarovich on 4/26/2016.
 */
public class UserDaoImpl implements UserDao {

    private static final Logger LOG = LogManager.getLogger(UserDaoImpl.class);
    //something ioc, for example spring DI
    private ConnectionPool cp;

    {
        this.cp = ConnectionPoolFactory.getInstance().getConnectionPool();
        try {
            cp.initPoolData();
        } catch (ConnectionPoolException e) {
            LOG.fatal("failed initialization");
        }
    }


    @Override
    public void insertUser(User user) throws DAOException {

        String firstQuery = "INSERT INTO user (login, password_hash, role_id, token)"
                + " values (?, ?, (SELECT role_id from role WHERE name=?), ?)";

        String secondQuery = "INSERT INTO user_data (user_id, firstname, lastname, midname, address, passport, phone_number)"
                + " values ((SELECT user_id from user WHERE login=?), ?, ?, ?, ?, ?, ?)";

        try (Connection connection = cp.takeConnection()) {

            connection.setAutoCommit(false);

            try (PreparedStatement firstStatement = connection.prepareStatement(firstQuery);
                 PreparedStatement secondStatement = connection.prepareStatement(secondQuery)) {

                firstStatement.setString (1, user.getLogin());
                firstStatement.setString (2, user.getPassword());
                firstStatement.setString (3, user.getRole().toString());
                firstStatement.setString (4, user.getToken());
                firstStatement.executeUpdate();

                secondStatement.setString (1, user.getLogin());
                secondStatement.setString (2, user.getFirstName());
                secondStatement.setString (3, user.getLastName());
                secondStatement.setString (4, user.getMidName());
                secondStatement.setString (5, user.getAddress());
                secondStatement.setString (6, user.getPassport());
                secondStatement.setString (7, user.getPhoneNumber());
                secondStatement.executeUpdate();
                connection.commit();

            } catch(SQLException e) {
                connection.rollback();
                connection.setAutoCommit(true);
                throw new DAOException("Statement problem", e);
            }
            connection.setAutoCommit(true);
        } catch (SQLException e) {
            throw new DAOException("Connection Problem", e);
        } catch (ConnectionPoolException e) {
            throw new DAOException("Connection Pool Problem", e);
        }

    }

    @Override
    public void updateUser(User user) throws DAOException {

        String query = "UPDATE user_data SET firstname = ?, lastname = ?, midname = ?, address = ?, passport = ?, phone_number = ? WHERE user_id = (SELECT user_id from user WHERE login=?)";

        try (Connection connection = cp.takeConnection()) {
            try (PreparedStatement secondStatement = connection.prepareStatement(query)) {

                secondStatement.setString (1, user.getFirstName());
                secondStatement.setString (2, user.getLastName());
                secondStatement.setString (3, user.getMidName());
                secondStatement.setString (4, user.getAddress());
                secondStatement.setString (5, user.getPassport());
                secondStatement.setString (6, user.getPhoneNumber());
                secondStatement.setString (7, user.getLogin());
                secondStatement.executeUpdate();

            } catch(SQLException e) {
                throw new DAOException("Statement problem", e);
            }

        } catch (SQLException e) {
            throw new DAOException("Connection Problem", e);
        } catch (ConnectionPoolException e) {
            throw new DAOException("Connection Pool Problem", e);
        }

    }

    @Override
    public User readUser(User inputUser) throws DAOException {
        String query = "SELECT u.user_id, u.login, u.password_hash, u.token, ud.firstname, ud.lastname, ud.midname, ud.address, ud.passport, ud.phone_number, r.name as role_name\n" +
                "FROM user as u JOIN user_data as ud \n" +
                "ON u.user_id = ud.user_id\n" +
                "JOIN role as r ON r.role_id = u.role_id\n" +
                "WHERE login = ?";

        try (Connection connection = cp.takeConnection()) {
            try (PreparedStatement statement = connection.prepareStatement(query)) {

                statement.setString (1, inputUser.getLogin());
                User user = new User();
                try(ResultSet rs =statement.executeQuery()) {
                    while(rs.next()) {
                        user.setLogin(inputUser.getLogin());
                        user.setId(rs.getInt("user_id"));
                        user.setPassport(rs.getString("passport"));
                        user.setFirstName(rs.getString("firstname"));
                        user.setLastName(rs.getString("lastname"));
                        user.setMidName(rs.getString("midname"));
                        user.setAddress(rs.getString("address"));
                        user.setPhoneNumber(rs.getString("phone_number"));
                        user.setToken(rs.getString("token"));
                        user.setPassword(rs.getString("password_hash"));
                        user.setRole(Role.valueOf(rs.getString("role_name")));
                    }
                }
                return user;


            } catch(SQLException e) {
                throw new DAOException("Statement problem", e);
            }

        } catch (SQLException e) {
            throw new DAOException("Connection Problem", e);
        } catch (ConnectionPoolException e) {
            throw new DAOException("Connection Pool Problem", e);
        }
    }

    @Override
    public List<Room> readFreeRooms(Date dateIn, Date dateOut) throws DAOException {
        String query = "SELECT room.room_id, room_number, floor, key_number, size, view, type.name as type_name, service_pack.name as sp_name, price " +
                "FROM room JOIN type ON room.type_id = type.type_id " +
                "JOIN service_pack ON type.service_pack_id = service_pack.service_pack_id " +
                "WHERE room.room_id NOT IN(SELECT booking.room_id FROM booking " +
                "WHERE booking.date_in <= ? AND booking.date_out >= ? )";

        try (Connection connection = cp.takeConnection()) {
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                List<Room> roomList = new ArrayList<>();
                statement.setDate (1, new java.sql.Date(dateOut.getTime()));
                statement.setDate (2, new java.sql.Date(dateIn.getTime()));
                try(ResultSet rs = statement.executeQuery()) {
                    while(rs.next()) {
                        Room room = new Room();
                        room.setId(rs.getInt("room_id"));
                        room.setRoomNumber(rs.getString("room_number"));
                        room.setFloor(rs.getInt("floor"));
                        room.setKeyNumber(rs.getInt("key_number"));
                        RoomType type = new RoomType();
                        type.setName(rs.getString("type_name"));
                        type.setSize(rs.getInt("size"));
                        type.setView(rs.getString("view"));
                        RoomServicePack sp = new RoomServicePack();
                        sp.setName(rs.getString("sp_name"));
                        sp.setPrice(rs.getInt("price"));
                        type.setRoomServicePack(sp);
                        room.setType(type);
                        roomList.add(room);
                    }
                }
                return roomList;
            } catch(SQLException e) {
                throw new DAOException("Statement problem", e);
            }

        } catch (SQLException e) {
            throw new DAOException("Connection Problem", e);
        } catch (ConnectionPoolException e) {
            throw new DAOException("Connection Pool Problem", e);
        }
    }

    @Override
    public void insertBooking(Booking booking) throws DAOException {

        String firstQuery = "SELECT room.room_id, room_number, floor, key_number, size, view, type.name as type_name, service_pack.name as sp_name, price " +
                "FROM room JOIN type ON room.type_id = type.type_id " +
                "JOIN service_pack ON type.service_pack_id = service_pack.service_pack_id " +
                "WHERE room.room_id NOT IN(SELECT booking.room_id FROM booking " +
                "WHERE booking.date_in <= ? AND booking.date_out >= ? )";

        String secondQuery = "INSERT INTO booking (`date_in`, `date_out`, `user_id`, `room_id`) " +
                "VALUES (?, ?, ?, ?);";

        try (Connection connection = cp.takeConnection()) {
            connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            connection.setAutoCommit(false);

            try (PreparedStatement firstStatement = connection.prepareStatement(firstQuery);
                 PreparedStatement secondStatement = connection.prepareStatement(secondQuery)) {

                List<Room> roomList = new ArrayList<>();
                firstStatement.setDate (1, new java.sql.Date(booking.getDateOut().getTime()));
                firstStatement.setDate (2, new java.sql.Date(booking.getDateIn().getTime()));
                try(ResultSet rs = firstStatement.executeQuery()) {
                    while(rs.next()) {
                        Room room = new Room();
                        room.setId(rs.getInt("room_id"));
                        roomList.add(room);
                    }
                }

                for(Room room: roomList) {
                    if(room.getId() == booking.getRoom().getId()) {
                        secondStatement.setDate (1, new java.sql.Date(booking.getDateIn().getTime()));
                        secondStatement.setDate (2, new java.sql.Date(booking.getDateOut().getTime()));
                        secondStatement.setInt (3, booking.getUser().getId());
                        secondStatement.setInt (4, booking.getRoom().getId());
                        secondStatement.executeUpdate();
                        connection.commit();
                        return;
                    }
                }

                connection.setAutoCommit(true);
                throw new DAOException("Free Room not found!");

            } catch(SQLException e) {
                connection.rollback();
                connection.setAutoCommit(true);
                throw new DAOException("Statement problem", e);
            }
        } catch (SQLException e) {
            throw new DAOException("Connection Problem", e);
        } catch (ConnectionPoolException e) {
            throw new DAOException("Connection Pool Problem", e);
        }

    }

    @Override
    public void insertCreditCard(CreditCard creditCard) throws DAOException {
        String query = "INSERT INTO credit_card (number, expire, user_id, credit_card_type)"
                + " values (?, ?, (SELECT user_id from user WHERE login=?), (SELECT id from credit_card_type WHERE name=?))";

        try (Connection connection = cp.takeConnection()) {
            try (PreparedStatement firstStatement = connection.prepareStatement(query)) {

                firstStatement.setLong (1, creditCard.getNumber());
                firstStatement.setDate (2, new java.sql.Date(creditCard.getExpire().getTime()));
                firstStatement.setString (3, creditCard.getUser().getLogin());
                firstStatement.setString (4, creditCard.getType().toString());
                firstStatement.executeUpdate();

            } catch(SQLException e) {
                throw new DAOException("Statement problem", e);
            }
        } catch (SQLException e) {
            throw new DAOException("Connection Problem", e);
        } catch (ConnectionPoolException e) {
            throw new DAOException("Connection Pool Problem", e);
        }
    }

}
