import java.sql.*;
import java.util.ArrayList;
import java.util.List;

class UserDao {
    private static final String SELECT_FROM_USER = "SELECT * FROM user";
    private static final String INSERT_INTO_USER =
            "INSERT INTO user(first_name, second_name, email, password) values(?, ?, ?, ?)";
    private static final String DELETE_FROM_USER = "DELETE FROM user WHERE email = ?";
    private static Connection connection;

    public UserDao(){
        try {
            connection = ConnectionUtil.getConnection();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void insert(String firsName, String secondName, String email, String password) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO_USER);
        preparedStatement.setString(1, firsName);
        preparedStatement.setString(2, secondName);
        preparedStatement.setString(3, email);
        preparedStatement.setString(4, password);

        preparedStatement.executeUpdate();
    }

    public static List<User> getAll() throws SQLException {
        ResultSet resultSet = connection.createStatement().executeQuery(SELECT_FROM_USER);

        List<User> users = new ArrayList<>();

        while (resultSet.next()){
            users.add(User.of(resultSet));
        }
        return users;
    }

    public static User getUser(String email, String password) throws SQLException {
        User user = null;
        List<User> users = getAll();
        for (User u: users) {
            if (u.email.equals(email) & u.password.equals(password)){
                user = u;
            }
        };
        return user;
    }

    public static void delete(String email) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(DELETE_FROM_USER);
        preparedStatement.setString(1, email);

        preparedStatement.executeUpdate();
    }

}
