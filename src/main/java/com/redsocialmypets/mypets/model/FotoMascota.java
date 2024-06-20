package com.redsocialmypets.mypets.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class FotoMascota {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  // private ???? foto;
  private String descripcion;

  @CreationTimestamp
  private LocalDateTime fechaCreacion;

}
