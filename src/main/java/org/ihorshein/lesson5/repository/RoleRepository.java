package org.ihorshein.lesson5.repository;

import org.ihorshein.lesson5.model.Role;

import java.util.Optional;

public interface RoleRepository {
  /**
   * Saves a new role to the database.
   */
  Role create(Role role);

  /**
   * Finds a role by its ID.
   */
  Optional<Role> findById(Long id);
}
