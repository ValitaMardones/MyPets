package com.redsocialmypets.mypets.model;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Data
@Table(name = "usuarios")
public class Usuario {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @NotBlank
  private String nombre;
  @NotBlank
  private String apellido;
  @NotBlank
  private String correo;
  @NotBlank
  private String password;

  @CreationTimestamp
  private LocalDateTime fechaCreacion;

  @JsonIgnore
  @OneToMany(mappedBy = "idUsuarioPerfilMascota")
  private List<PerfilMascota> usuarioPerfilMascota;

}
