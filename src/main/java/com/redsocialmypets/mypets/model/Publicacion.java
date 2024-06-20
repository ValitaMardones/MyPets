package com.redsocialmypets.mypets.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
public class Publicacion {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private String titulo;
  private String contenido;

  @CreationTimestamp
  private LocalDateTime fechaCreacion;

}
