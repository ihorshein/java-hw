package org.ihorshein.lesson4.service;

import org.ihorshein.lesson4.model.User;
import org.ihorshein.lesson4.model.UserRegistrationDto;
import org.ihorshein.lesson4.model.UserResponseDto;
import org.ihorshein.lesson4.util.UserValidator;
import org.ihorshein.lesson4.repository.UserRepository;

public class UserServiceImpl implements UserService {
  private final UserRepository userRepository;

  public UserServiceImpl(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public UserResponseDto registerUser(UserRegistrationDto userRegistrationDto) {
    UserValidator.checkRegistration(userRegistrationDto);

    User userNew = this.userRepository.create(new User(
      null,
      userRegistrationDto.getEmail(),
      userRegistrationDto.getPhoneNumber(),
      userRegistrationDto.getPassword()
    ));

    return new UserResponseDto(userNew.getUserId(), userNew.getEmail(), userNew.getPhoneNumber());
  }

  @Override
  public UserResponseDto getUserById(Long userId) {
    return this.userRepository
      .findById(userId)
      .map((user) -> new UserResponseDto(user.getUserId(), user.getEmail(), user.getPhoneNumber()))
      .orElseThrow();
  }
}
