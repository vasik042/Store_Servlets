package Logos.daos;

import Logos.ConnectionUtil;
import Logos.entities.User;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    private static final String SELECT_FROM_USER = "SELECT * FROM user";
    private static final String INSERT_INTO_USER =
            "INSERT INTO user(first_name, second_name, email, password) values(?, ?, ?, ?)";
    private static final String DELETE_FROM_USER = "DELETE FROM user WHERE email = ?";
    private static Connection connection;

    private static Logger log = Logger.getLogger(UserDao.class);

    public UserDao(){
        PropertyConfigurator.configure("log4j.properties");
        try {
            connection = ConnectionUtil.getConnection();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void insert(String firsName, String secondName, String email, String password) throws SQLException {
        log.info("Try to create new user");
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO_USER);
        preparedStatement.setString(1, firsName);
        preparedStatement.setString(2, secondName);
        preparedStatement.setString(3, email);
        preparedStatement.setString(4, password);
        preparedStatement.executeUpdate();
        log.info("Created new user");
    }

    public static List<User> getAll() throws SQLException {
        log.info("Try to get all users");
        ResultSet resultSet = connection.createStatement().executeQuery(SELECT_FROM_USER);

        List<User> users = new ArrayList<>();

        while (resultSet.next()){
            users.add(User.of(resultSet));
        }
        return users;
    }

    public static User getUser(String email, String password) throws SQLException {
        log.info("Try to get user");
        User user = null;
        List<User> users = getAll();
        for (User u: users) {
            if (u.getEmail().equals(email) & u.getPassword().equals(password)){
                user = u;
            }
        };
        return user;
    }

    public static void delete(String email) throws SQLException {
        log.info("Try to delete user");
        PreparedStatement preparedStatement = connection.prepareStatement(DELETE_FROM_USER);
        preparedStatement.setString(1, email);

        preparedStatement.executeUpdate();
    }

}
