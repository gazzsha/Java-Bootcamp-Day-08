package edu.school21.repository;

import edu.school21.entity.User;

import javax.sql.DataSource;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepositoryJdbcImpl implements UserRepository<User> {

    private final DataSource dataSource;

    public UserRepositoryJdbcImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<User> findAll() throws SQLException {
        List<User> userList = null;
        final String SQLQuery = "SELECT * FROM users";
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SQLQuery);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (!resultSet.next()) {
                return userList;
            }
            userList = new ArrayList<>();
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt(1));
                user.setEmail(resultSet.getString(2));
                userList.add(user);
            }
        }
        return userList;
    }

    @Override
    public void save(User entity) throws SQLException {
        final String SQLQuery = "INSERT INTO users(email) VALUES (?)";
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SQLQuery);
            preparedStatement.setString(1, entity.getEmail());
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public void update(User entity) throws SQLException {
        final String SQLQuery = "UPDATE users SET email = ? WHERE id = ?";
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SQLQuery);
            preparedStatement.setInt(1, entity.getId());
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public void delete(Integer id) throws SQLException {
        final String SQLQuery = "DELETE FROM users WHERE id = ?";
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SQLQuery);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public Optional<User> findByEmail(String email) throws SQLException {
        final String SQLQuery = "SELECT * FROM users WHERE email = ?";
        User user = null;
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SQLQuery);
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getInt(1));
                user.setEmail(resultSet.getString(2));
            }
        }
        return Optional.ofNullable(user);
    }

    @Override
    public Optional<User> findByID(Integer id) throws SQLException {
        final String SQLQuery = "SELECT * FROM users WHERE id = ?";
        User user = null;
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SQLQuery);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getInt(1));
                user.setEmail(resultSet.getString(2));
            }
        }
        return Optional.ofNullable(user);
    }
}
