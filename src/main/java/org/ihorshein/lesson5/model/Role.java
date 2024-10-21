package org.ihorshein.lesson5.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "role")
public class Role {

  @Id
  @Column(name = "roleId")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  // @Column(unique = true)
  private String name;
}
