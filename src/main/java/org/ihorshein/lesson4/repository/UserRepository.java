package org.ihorshein.lesson4.repository;

import org.ihorshein.lesson4.model.User;

import java.util.Optional;

public interface UserRepository {
  User create(User user);

  Optional<User> findById(Long id);
}
