package by.andersen.repository;


import by.andersen.config.DbConfig;
import by.andersen.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
@Repository
public class UserRepository {
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public void saveUser(User user) {
        try {
            Connection connection = DriverManager.getConnection(DbConfig.DB_URL, DbConfig.DB_USERNAME, DbConfig.DB_PASSWORD);
            PreparedStatement statement = connection.prepareStatement("INSERT INTO user (`id`, `username`, `password`) VALUES (?, ?, ?)");
            statement.setLong(1, user.getId());
            statement.setString(2, user.getUsername());
            statement.setString(3, user.getPassword());
            statement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public Long getLatestUserId() {
        try {
            Connection connection = DriverManager.getConnection(DbConfig.DB_URL, DbConfig.DB_USERNAME, DbConfig.DB_PASSWORD);
            ResultSet resultSet = connection.createStatement().executeQuery("select MAX(id) as id from user");
            resultSet.next();
            return resultSet.getLong("id");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
