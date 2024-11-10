package org.ihorshein.lesson4.repository;

import org.ihorshein.lesson4.model.User;
import org.ihorshein.lesson4.util.DbConnection;
import org.ihorshein.lesson4.util.Hash;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Optional;

public class UserRepositoryMysql implements UserRepository {
  @Override
  public User create(User user) {
    String query = "INSERT INTO user SET email = ?, phoneNumber = ?, password = ?";

    try (Connection connection = DbConnection.connectionMysql();
         PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

      statement.setString(1, user.getEmail());
      statement.setString(2, user.getPhoneNumber().isEmpty() ? null : user.getPhoneNumber());
      statement.setString(3, Hash.toSha1(user.getPassword()));

      if (statement.executeUpdate() != 1) {
        throw new RuntimeException("Unable to insert a new user.");
      }

      try (ResultSet resultCreate = statement.getGeneratedKeys()) {
        if (!resultCreate.next()) {
          throw new RuntimeException("Failed to get the added user ID.");
        }

        user.setUserId(resultCreate.getLong(1));

        return user;
      }
    } catch (SQLIntegrityConstraintViolationException e) {
      throw new RuntimeException("A user with such email or phone number already exists.", e);
    } catch (SQLException e) {
      throw new RuntimeException("Request failed.", e);
    }
  }

  @Override
  public Optional<User> findById(Long id) {
    String query = "SELECT email, phoneNumber, password FROM user WHERE userId = ?";

    try (Connection connection = DbConnection.connectionMysql();
        PreparedStatement statement = connection.prepareStatement(query)) {

      statement.setLong(1, id);

      try (ResultSet result = statement.executeQuery()) {
        if (result.next()) {
          return Optional.of(new User(
            id,
            result.getString("email"),
            result.getString("phoneNumber"),
            result.getString("password")
          ));
        }

        return Optional.empty();
      }
    } catch (SQLException e) {
      throw new RuntimeException("Request failed.", e);
    }
  }
}
