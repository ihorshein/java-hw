package org.ihorshein.lesson4.model;

public class UserRegistrationDto {
  /**
   * (required): Must be in a valid email format.
   */
  private String email = "";

  /**
   * (optional): Should be validated if present (e.g., valid phone number format).
   */
  private String phoneNumber = "";

  /**
   * (required): User password.
   */
  private String password = "";

  /**
   * (required): Should be equal to {@link UserRegistrationDto#password}
   */
  private String passwordRepeat = "";

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getPasswordRepeat() {
    return passwordRepeat;
  }

  public void setPasswordRepeat(String repeatPassword) {
    this.passwordRepeat = repeatPassword;
  }
}
