package Logos.entities;

import java.sql.ResultSet;
import java.sql.SQLException;

public class User {
    String role;
    String password;
    String email;
    String firstName;
    String secondName;
    int id;

    public User(String firstName, String secondName, String email, String password) {
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.secondName = secondName;
        this.role = "USER";
    }

    public static User of(ResultSet resultSet) throws SQLException {
        User user = new User(resultSet.getString("first_name"), resultSet.getString("second_name"), resultSet.getString("email"), resultSet.getString("password"));
        user.setId(resultSet.getInt("id"));
        return user;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
