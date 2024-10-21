package org.ihorshein.lesson5.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "user")
public class User {

  @Id
  @Column(name = "userId")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String email;

  @Column(length = 25)
  private String phoneNumber;

  @Column(length = 64)
  private String password;

  @ManyToMany
  private List<Role> roles;
}
