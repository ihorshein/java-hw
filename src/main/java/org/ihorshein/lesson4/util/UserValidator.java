package org.ihorshein.lesson4.util;

import org.ihorshein.lesson4.model.UserRegistrationDto;

public class UserValidator {
  public static void checkRegistration(UserRegistrationDto userRegistrationDto) {
    String email = userRegistrationDto.getEmail();

    if (email.isBlank()) {
      throw new RuntimeException("You should specify an email address.");
    }

    if (!email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
      throw new RuntimeException("Email is not valid.");
    }

    String password = userRegistrationDto.getPassword();
    if (password.isEmpty()) {
      throw new RuntimeException("You should specify a password.");
    }

    if (!password.equals(userRegistrationDto.getPasswordRepeat())) {
      throw new RuntimeException("Password and repeat password do not match.");
    }

    String phoneNumber = userRegistrationDto.getPhoneNumber();
    if (!phoneNumber.isEmpty()
      && !phoneNumber.matches("^\\+?(\\d{1,3})?[-. ]?\\(?\\d{1,4}?\\)?[-. ]?\\d{1,4}[-. ]?\\d{1,9}$")
    ) {
      throw new RuntimeException("Phone number is not valid.");
    }
  }
}
