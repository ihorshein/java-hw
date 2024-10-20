package org.ihorshein.lesson4.model;

public class User {
  private Long userId;

  private String email;

  private String phoneNumber;

  private String password;

  public User(Long userId, String email, String phoneNumber, String password) {
    this.userId = userId;
    this.email = email;
    this.phoneNumber = phoneNumber;
    this.password = password;
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public String getEmail() {
    return email;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public String getPassword() {
    return password;
  }
}
