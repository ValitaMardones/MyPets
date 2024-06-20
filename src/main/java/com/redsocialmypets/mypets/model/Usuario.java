package com.redsocialmypets.mypets.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Usuario {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private String nombre;
  private String apellido;
  private String correo;
  private String password;

  @CreationTimestamp
  private LocalDateTime fechaCreacion;

}
