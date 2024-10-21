package org.ihorshein.lesson5.repository;

import org.ihorshein.lesson5.model.User;

import java.util.Optional;

public interface UserRepository {
  /**
   * Saves a new user to the database.
   */
  User create(User user);

  /**
   * Updates an existing user in the database.
   */
  User update(User user);

  /**
   * Finds a user by their ID.
   */
  Optional<User> findById(Long id);
}
