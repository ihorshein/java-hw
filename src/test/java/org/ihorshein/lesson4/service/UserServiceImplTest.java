package org.ihorshein.lesson4.service;

import org.ihorshein.lesson4.model.User;
import org.ihorshein.lesson4.model.UserRegistrationDto;
import org.ihorshein.lesson4.model.UserResponseDto;
import org.ihorshein.lesson4.repository.UserRepository;
import org.ihorshein.lesson4.repository.UserRepositoryMysql;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

  @Mock
  private UserRepository userRepository;

  @InjectMocks
  private UserServiceImpl userService;

  @Test
  void registerUser() {
    UserRegistrationDto userRegistrationDto = new UserRegistrationDto();
    userRegistrationDto.setEmail("test@test.com");
    userRegistrationDto.setPassword("xxx");
    userRegistrationDto.setPasswordRepeat("xxx");

    Mockito.when(userRepository.create(Mockito.any(User.class)))
      .thenReturn(new User(
        1L,
        userRegistrationDto.getEmail(),
        userRegistrationDto.getPhoneNumber(),
        userRegistrationDto.getPassword()
      ));

    UserResponseDto user = userService.registerUser(userRegistrationDto);

    assertEquals(1L, user.userId());
    assertEquals(userRegistrationDto.getEmail(), user.email());
    assertEquals(userRegistrationDto.getPhoneNumber(), user.phoneNumber());
  }

  @Test
  void getUserById() {
    Mockito.when(userRepository.findById(1L))
      .thenReturn(Optional.of(new User(1L, "test@test.com", null, "xxx")));

    Mockito.when(userRepository.findById(2L))
      .thenReturn(Optional.empty());

    UserResponseDto user = userService.getUserById(1L);
    assertEquals(1L, user.userId());
    assertEquals("test@test.com", user.email());
    assertNull(user.phoneNumber());

    assertThrows(RuntimeException.class, () -> userService.getUserById(2L), "No value present");
  }
}