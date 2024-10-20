package org.ihorshein.lesson4.util;

import org.ihorshein.lesson4.model.UserRegistrationDto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserValidatorTest {

  @Test
  void checkRegistration_emailEmpty() {
    UserRegistrationDto userRegistrationDto = new UserRegistrationDto();

    assertThrows(
      RuntimeException.class,
      () -> UserValidator.checkRegistration(userRegistrationDto),
      "You should specify an email address."
    );
  }

  @Test
  void checkRegistration_emailBlank() {
    UserRegistrationDto userRegistrationDto = new UserRegistrationDto();
    userRegistrationDto.setEmail("    ");

    assertThrows(
      RuntimeException.class,
      () -> UserValidator.checkRegistration(userRegistrationDto),
      "You should specify an email address."
    );
  }

  @Test
  void checkRegistration_emailInvalid() {
    UserRegistrationDto userRegistrationDto = new UserRegistrationDto();
    userRegistrationDto.setEmail("john.doe.gmail.com");

    assertThrows(
      RuntimeException.class,
      () -> UserValidator.checkRegistration(userRegistrationDto),
      "Email is not valid."
    );
  }

  @Test
  void checkRegistration_passwordEmpty() {
    UserRegistrationDto userRegistrationDto = new UserRegistrationDto();
    userRegistrationDto.setEmail("john.doe@gmail.com");

    assertThrows(
      RuntimeException.class,
      () -> UserValidator.checkRegistration(userRegistrationDto),
      "You should specify a password."
    );
  }

  @Test
  void checkRegistration_passwordRepeatMismatch() {
    UserRegistrationDto userRegistrationDto = new UserRegistrationDto();
    userRegistrationDto.setEmail("john.doe@gmail.com");
    userRegistrationDto.setPassword("password");
    userRegistrationDto.setPassword("passw0rd");

    assertThrows(
      RuntimeException.class,
      () -> UserValidator.checkRegistration(userRegistrationDto),
      "Password and repeat password do not match."
    );
  }

  @Test
  void checkRegistration_phoneInvalid() {
    UserRegistrationDto userRegistrationDto = new UserRegistrationDto();
    userRegistrationDto.setEmail("john.doe@gmail.com");
    userRegistrationDto.setPhoneNumber("+38099937999a");
    userRegistrationDto.setPassword("xxx");
    userRegistrationDto.setPassword("xxy");

    assertThrows(
      RuntimeException.class,
      () -> UserValidator.checkRegistration(userRegistrationDto),
      "Password and repeat password do not match."
    );
  }

  @Test
  void checkRegistration_Ok() {
    UserRegistrationDto userRegistrationDto = new UserRegistrationDto();
    userRegistrationDto.setEmail("john.doe@gmail.com");
    userRegistrationDto.setPhoneNumber("+380999379992");
    userRegistrationDto.setPassword("password");
    userRegistrationDto.setPasswordRepeat("password");

    UserValidator.checkRegistration(userRegistrationDto);
  }
}