package org.ihorshein.lesson4.service;

import org.ihorshein.lesson4.model.UserRegistrationDto;
import org.ihorshein.lesson4.model.UserResponseDto;

public interface UserService {
  /**
   * Handles the registration of a new user.
   */
  UserResponseDto registerUser(UserRegistrationDto userRegistrationDto);

  /**
   * Retrieves a user by their ID.
   */
  UserResponseDto getUserById(Long userId);

}
