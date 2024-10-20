package org.ihorshein.lesson4.model;

public record UserResponseDto(Long userId, String email, String phoneNumber) {
  @Override
  public String toString() {
    return "userId = " + userId + ", email = '" + email + "', phoneNumber = '" + phoneNumber + "'";
  }
}
