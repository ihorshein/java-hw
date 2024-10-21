package org.ihorshein.lesson5.repository;

import org.ihorshein.lesson5.model.User;

import java.util.Optional;

public class UserRepositoryMysql extends RepositoryMysql implements UserRepository {
  @Override
  public User create(User user) {
    return addDb(user);
  }

  @Override
  public User update(User user) {
    return this.updateDb(user);
  }

  @Override
  public Optional<User> findById(Long id) {
    return Optional.ofNullable(
      find(User.class, "select tu from User tu join fetch tu.roles where tu.id=" + id)
        .getFirst());
  }
}
