package org.ihorshein.lesson5.repository;

import org.ihorshein.lesson5.model.Role;

import java.util.Optional;

public class RoleRepositoryMysql extends RepositoryMysql implements RoleRepository {
  @Override
  public Role create(Role role) {
    return addDb(role);
  }

  @Override
  public Optional<Role> findById(Long id) {
    return Optional.ofNullable(
      find(Role.class, "select tr from Role tr where tr.id=" + id)
        .getFirst());
  }
}
