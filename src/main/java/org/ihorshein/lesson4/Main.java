package org.ihorshein.lesson4;

import org.ihorshein.lesson4.model.UserRegistrationDto;
import org.ihorshein.lesson4.repository.UserRepositoryMysql;
import org.ihorshein.lesson4.service.UserService;
import org.ihorshein.lesson4.service.UserServiceImpl;

/**
 * <a href="https://docs.google.com/document/d/1h5LO4ZXB6HZi-vqGs1VUSUd_lhE8osS3JJ1e5pG9_Bo/edit?tab=t.0">
 *   Lesson 4 HW
 * </a>
 */
public final class Main {
  public static void main(String[] args) {
    UserRegistrationDto userRegistrationDto = new UserRegistrationDto();
    userRegistrationDto.setEmail("john.doe@gmail.com");
    userRegistrationDto.setPhoneNumber("+380999379992");
    userRegistrationDto.setPassword("password");
    userRegistrationDto.setPasswordRepeat("password");

    UserService userService = new UserServiceImpl(new UserRepositoryMysql());

    System.out.println(userService.getUserById(
      userService.registerUser(userRegistrationDto).userId()
    ));
  }
}
