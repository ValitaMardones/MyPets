package com.redsocialmypets.mypets.model;

import com.redsocialmypets.mypets.model.Enum.ERol;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "roles")
public class Rol {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Enumerated(EnumType.STRING)
  @Column(name = "rol")
  private ERol nombreRol;

}
